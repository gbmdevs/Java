package br.com.estudos.oauth2.service;

import br.com.estudos.oauth2.dto.ResumePositionsStocks;
import br.com.estudos.oauth2.model.StocksUserOperations;
import br.com.estudos.oauth2.dto.ResumePositionsStocks;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserResumeService{

   @Autowired
   private StocksUserOperationsService serviceUserOperations;


   public List<ResumePositionsStocks> buscarPosicoesUsuario(){
       List<StocksUserOperations> lista = serviceUserOperations.returnAllStocksOperations();
       List<ResumePositionsStocks> listaResume = new ArrayList();
       for(StocksUserOperations operacoes : lista){
          ResumePositionsStocks resumo = new ResumePositionsStocks();
          resumo.setTicket(operacoes.getStock().getTicket());
          resumo.setDateOperationBuy(operacoes.getDateOperateBuy());
          listaResume.add(resumo);            
       }
       return listaResume;
   }
     

}