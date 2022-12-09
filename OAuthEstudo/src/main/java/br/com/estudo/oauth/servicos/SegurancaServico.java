package br.com.estudo.oauth.servicos;

import br.com.estudo.oauth.exceptions.TokenInvalidoException;
import br.com.estudo.oauth.exceptions.UsuarioOuSenhaInvalidaException;
import br.com.estudo.oauth.repository.UsuarioRepositorio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.error.OAuthError.CodeResponse;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;

import org.apache.commons.lang.StringUtils;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class SegurancaServico {

    private final String APP_CLIENT_ID     = "exemploaplicativocliente";
    private final String APP_CLIENT_SECRET = "9834ba657bb2c60b5bb53de6f4201905";

    @Autowired
    UsuarioRepositorio usuarioRepo;

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
            String usuario = oauthRequest.getUsername();
            System.out.println("Usuario: " + usuario + " Senha: " + senha);

            try{
                 this.usuarioRepo.
            }catch(UsuarioOuSenhaInvalidaException e){
                return this.retornarErroOAuth(HttpServletResponse.SC_UNAUTHORIZED, CodeResponse.UNAUTHORIZED_CLIENT, e);

            }

            return OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK)
            .setParam("nome","Jamalzin")
            .buildJSONMessage();
        }catch(OAuthProblemException ex) {
            return this.retornarErroOAuth(HttpServletResponse.SC_UNAUTHORIZED,CodeResponse.INVALID_REQUEST,ex);
        }catch(Exception ex){ 
            return this.retornarErroOAuth(HttpServletResponse.SC_BAD_REQUEST, CodeResponse.SERVER_ERROR, ex);
        }
    }

    // Validar todos os dados Recebidos na requisição
    public void validarAcessoAplicativo(String appClientId, String appClientSecret) throws TokenInvalidoException{
         if(StringUtils.isBlank(appClientId)){
            throw new TokenInvalidoException("Atributo clientID é nulo.");
         }
         if(StringUtils.isBlank(appClientSecret)){
            throw new TokenInvalidoException("Atributo clientSecret é nulo.");
         }
         if(!appClientId.equalsIgnoreCase(APP_CLIENT_ID) && !appClientSecret.equalsIgnoreCase(APP_CLIENT_SECRET)){
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

}