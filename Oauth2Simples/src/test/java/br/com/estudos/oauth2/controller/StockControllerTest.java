package br.com.estudos.oauth2.controller;

import br.com.estudos.oauth2.dto.login.LoginUserDTO;
import br.com.estudos.oauth2.model.Usuario;
import br.com.estudos.oauth2.service.AuthenticationService;
import br.com.estudos.oauth2.service.jwt.JwtService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;

import br.com.estudos.oauth2.controller.StockController;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class StockControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationService authenticationService;

    private String jwtToken;

    @BeforeAll
    public void jwtToken(){
        LoginUserDTO dto = new LoginUserDTO();
        dto.setEmail("guih.smi2@gmail.com");
        dto.setEmail("teste");
        Usuario usuario = authenticationService.authenticate(dto);
        jwtToken = jwtService.generateToken(usuario);
    }
    @Test
    public void testeJwt(){
        System.out.println("JWT" +jwtToken);
    }


/*
    @Test
    public void testGetAllStocks() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/stocks"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetRetriveDataStock() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/stocks/retrivedata")
               .param("dataInicio","2023-07-01")
               .param("dataFinal","2023-07-26")
               .param("ticket","BBAS3"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

*/
}