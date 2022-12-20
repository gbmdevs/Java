package br.com.estudo.oauth.servicos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;


import br.com.estudo.oauth.exceptions.TokenInvalidoException;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.message.OAuthResponse;

import br.com.estudo.oauth.servicos.SegurancaServico;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SegurancaServicoTest{

    //@Autowired
    //private MockMvc mockMvc;

    @Autowired
    private SegurancaServico segurancaService;

    @Autowired
    private HttpServletRequest requisicao;

    @Test(expected = TokenInvalidoException.class)
    public void clientIDeClientSecretInvalidos(){
          segurancaService.validarAcessoAplicativo("Teste","teste");
    }

    @Test(expected = TokenInvalidoException.class)
    public void clientIDemBranco(){
          segurancaService.validarAcessoAplicativo("","teste");
    }

    @Test(expected = TokenInvalidoException.class)
    public void clientSecretemBranco(){
          segurancaService.validarAcessoAplicativo("Teste","");
    }

    @Test
    public void logarnoOAuth(){
        try{
          requisicao.setAttribute("grant_type","password");
          requisicao.setAttribute("username","teste");
          requisicao.setAttribute("password","teste");
          requisicao.setAttribute("client_secret","9834ba657bb2c60b5bb53de6f4201905");
          requisicao.setAttribute("client_id","exemploaplicativocliente");
          OAuthResponse resposta =  segurancaService.logarOAuth(requisicao);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


}