package br.com.estudo.oauth;

import org.apache.oltu.oauth2.common.message.OAuthResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.estudo.oauth.model.Perfil;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping(value = "/home")
public class HomeController{ 

    @ResponseBody
    @RequestMapping(value = "/acesso/geral", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String acessoGeral() {
        return "Geral: Acesso Permitido!";
	}

    @RequestMapping(value = "/response", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Perfil> estudoResposta(){
        List<Perfil> lista = new ArrayList<>();
        lista.add(new Perfil(UUID.randomUUID()));
        lista.add(new Perfil(UUID.randomUUID()));
        lista.add(new Perfil(UUID.randomUUID()));
        lista.add(new Perfil(UUID.randomUUID()));
        return lista;
    }
}