package br.com.estudo.oauth.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;

import br.com.estudo.oauth.controller.SegurancaController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SegurancaControllerTest{

    @Autowired
    private SegurancaController segurancaController;
   
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(segurancaController).build();
    }

    @Test
    public void requisicaoSegurancaController() throws Exception{
             this.mockMvc.perform(post("/seguranca/logar")             
              .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
              .param("grant_type", "password")
              .param("username", "teste")
              .param("password", "teste")
              .param("client_secret", "teste")
              .param("client_id", "teste"))
              .andDo(print());
           
    }

}