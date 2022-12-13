package br.com.estudo.oauth.servicos;

import org.junit.Test;
import org.junit.runner.RunWith;


import br.com.estudo.oauth.exceptions.TokenInvalidoException;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.message.OAuthResponse;

import br.com.estudo.oauth.servicos.SegurancaServico;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SegurancaServicoTest{

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
          requisicao.setAttribute("password","senha");
          OAuthResponse resposta =  segurancaService.logarOAuth(requisicao);
    }


}