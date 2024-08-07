package br.com.estudos.oauth2.controller;

import br.com.estudos.oauth2.dto.login.LoginUserDTO;
import br.com.estudos.oauth2.model.Usuario;
import br.com.estudos.oauth2.service.AuthenticationService;
import br.com.estudos.oauth2.service.StocksDataService;
import br.com.estudos.oauth2.service.StocksService;
import br.com.estudos.oauth2.service.jwt.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(AuthController.class)
@SpringBootTest
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String jwtToken;

    @Before
    public void setUp(){
        LoginUserDTO dto = new LoginUserDTO();
        dto.setEmail("guih.smi2@gmail.com");
        dto.setPassword("teste");
    }
    @Test
    @DisplayName("Test Spring @Autowired Integration")
    public void testAuthenticateUser() throws Exception {
        mockMvc.perform(post("/auth/login"));
    }

}