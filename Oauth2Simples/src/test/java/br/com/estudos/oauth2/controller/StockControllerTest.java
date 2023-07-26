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
public class StockControllerTest{

    @Autowired
    private MockMvc mockMvc;
    
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


}