package br.com.springboot.controller;

import br.com.springboot.entity.MercadoFinanceiro;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class MercadoFinanController {
    
    //Listar todos os tickets disponiveis
    @GetMapping("/tickets")
    public List<MercadoFinanceiro> getAllStockTickets(){ 
        List<MercadoFinanceiro> lista = new ArrayList<>();
        return lista;
          
    }
}