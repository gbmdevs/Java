package br.com.estudo.oauth;

import org.apache.oltu.oauth2.common.message.OAuthResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/home")
public class HomeController{ 

    @ResponseBody
    @RequestMapping(value = "/acesso/geral", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String acessoGeral() {
        return "Geral: Acesso Permitido!";
	}

}