package br.com.estudo.oauth.servicos;

import br.com.estudo.oauth.exceptions.TokenInvalidoException;
import br.com.estudo.oauth.exceptions.UsuarioOuSenhaInvalidaException;
import br.com.estudo.oauth.repository.UsuarioRepositorio;
import br.com.estudo.oauth.repository.SegurancaRepositorio;

import br.com.estudo.oauth.model.Usuario;
import br.com.estudo.oauth.model.SegurancaAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;

import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.error.OAuthError.CodeResponse;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;


import org.apache.commons.lang.StringUtils;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import br.com.estudo.oauth.utils.FormatadorUtil;

import br.com.estudo.oauth.utils.DateUtils;

import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;

// Log do Servidor
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SegurancaServico {

    @Value("${server.app.client.id}")
    private String APP_CLIENT_ID;
    @Value("${server.app.client.secret}")
    private String APP_CLIENT_SECRET;

    private static Logger logger = LoggerFactory.getLogger(SegurancaServico.class);

    @Autowired
    UsuarioRepositorio usuarioRepo;

    @Autowired
    SegurancaRepositorio segurancaRepo;

    private SegurancaAPI retornarPorUsuario(Usuario usuario) {
         return this.segurancaRepo.findByUsuario(usuario);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OAuthResponse logarOAuth(HttpServletRequest requisicao){
        try{

            OAuthTokenRequest oauthRequest = new OAuthTokenRequest(requisicao);
            String appClientId             = oauthRequest.getClientId();
            String appClientSecret         = oauthRequest.getClientSecret();

            // 1. Validar se ClientID e ClientPassword são validos
            try{
                this.validarAcessoAplicativo(appClientId,appClientSecret);
            }catch(TokenInvalidoException e){
                return this.retornarErroOAuth(HttpServletResponse.SC_UNAUTHORIZED, CodeResponse.UNAUTHORIZED_CLIENT, e);
            }

            // Pesquisar por usuario e senha
            String senha   = oauthRequest.getPassword();
            String login = oauthRequest.getUsername();
            Usuario usuario = null;
            
            try{  
                usuario = this.retornarPorUsuarioeSenha(login,FormatadorUtil.encryptMD5(senha));                 
            }catch(UsuarioOuSenhaInvalidaException e){
                return this.retornarErroOAuth(HttpServletResponse.SC_UNAUTHORIZED, CodeResponse.UNAUTHORIZED_CLIENT, e);
            }

            logger.info("Usuario encontrado: {} ", usuario);

            String acessoToken =  new OAuthIssuerImpl(new MD5Generator()).accessToken();
            Date proximaDataExp = this.retornarProximaDataExpiracao();

            logger.info("Token novo: {}",acessoToken);
            logger.info("Proxima Expiracao: {}",proximaDataExp.toString());

            this.atualizarToken(usuario,acessoToken,proximaDataExp);



            return OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK)
            .setParam("login",usuario.getLogin())
            .setParam("perfil",usuario.getPerfil().getNome())
            .setParam("nome",usuario.getNome())
            .setParam("criptografia",FormatadorUtil.encryptMD5(senha))
            .buildJSONMessage();
        }catch(OAuthProblemException ex) {
            return this.retornarErroOAuth(HttpServletResponse.SC_UNAUTHORIZED,CodeResponse.INVALID_REQUEST,ex);
        }catch(Exception ex){ 
            return this.retornarErroOAuth(HttpServletResponse.SC_BAD_REQUEST, CodeResponse.SERVER_ERROR, ex);
        }
    }

    // Validar todos os dados Recebidos na requisição
    public void validarAcessoAplicativo(String appClientId, String appClientSecret) throws TokenInvalidoException{
         logger.info("Chave de verificacao OAUTH: {} ", appClientSecret, appClientId);
         if(StringUtils.isBlank(appClientId)){
            throw new TokenInvalidoException("Atributo clientID é nulo.");
         }
         if(StringUtils.isBlank(appClientSecret)){
            throw new TokenInvalidoException("Atributo clientSecret é nulo.");
         }
         if(!appClientId.equalsIgnoreCase(APP_CLIENT_ID) || !appClientSecret.equalsIgnoreCase(APP_CLIENT_SECRET)){
            throw new TokenInvalidoException("Seguranca: aplicativo nao autorizado.");
         }
    }

    // Retornar erro em JSON
    public OAuthResponse retornarErroOAuth(int errorCode, String error, Exception e){
        try{
            String descricao = e.getMessage();
            return OAuthASResponse.errorResponse(errorCode)
               .setError(error + (descricao != null ? " - " + descricao : ""))
               .setErrorDescription(descricao)
               .buildJSONMessage();
        }catch(OAuthSystemException ex){
            throw new RuntimeException(ex);
        }
    }

    // Proxima data de Expiração
    public Date retornarProximaDataExpiracao(){
        Date agora = new Date();
        int dia = DateUtils.retornarUnidade(agora, DateUtils.DIA);
        int mes = DateUtils.retornarUnidade(agora, DateUtils.MES);
        int ano = DateUtils.retornarUnidade(agora, DateUtils.ANO);
        logger.info("Dia: {}",dia);
        logger.info("Mes: {}",mes);
        logger.info("Data Atual: {}",agora.toString());
        return DateUtils.retornarData(dia + "/" + mes + "/" + ano + " 23:59:59", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));
    }

    // Buscar por usuario e senha
    public Usuario retornarPorUsuarioeSenha(String login, String senha) throws UsuarioOuSenhaInvalidaException{
         Usuario usuario =  this.usuarioRepo.findByLoginAndSenha(login,senha);
         if(usuario == null){
              throw new UsuarioOuSenhaInvalidaException("Usuário não encontrado.");
         }
         return usuario;
    }

    // Atualizar o token do usuario
    private void atualizarToken(Usuario usuario,String token, Date proximaDataExpiracao ) throws TokenInvalidoException{
        // Verificar o usuario
        if(usuario == null){
            throw new TokenInvalidoException("Problema interno ao criar token: usuario nulo");
        }

        SegurancaAPI segurancaAPI = this.retornarPorUsuario(usuario);
        logger.info("Seguranca API : {}",segurancaAPI);
    }



}