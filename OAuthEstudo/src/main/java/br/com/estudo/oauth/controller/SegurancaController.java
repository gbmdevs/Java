package br.com.estudo.oauth.controller;

import javax.servlet.http.HttpServletRequest;

import br.com.estudo.oauth.servicos.SegurancaServico;

import org.apache.oltu.oauth2.common.message.OAuthResponse;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/seguranca")
public class SegurancaController{

     @Autowired
     private SegurancaServico segurancaServico;

     @ResponseBody
     @RequestMapping(value="/logar",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public String logar(HttpServletRequest requisicao){
          OAuthResponse resposta = segurancaServico.logarOAuth(requisicao);
          return resposta.getBody();
     }

}