package br.com.estudos.oauth2.controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.estudos.oauth2.controller.StockController;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserResumeControllerTest{

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetAllStocksPositions() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
               .get("/user-resume/stocks-positions"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetReturnOfInvestiment() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
               .get("/user-resume/investment/balance"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testExportAllStocksPositions() throws Exception{
       /* mockMvc.perform(MockMvcRequestBuilders
               .get("/user-resume/export"))
               .andExpect(MockMvcResultMatchers.status().isOk()); */
    }

}