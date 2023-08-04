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

   @Autowired
   private StocksDataService serviceStocksData;

   public List<ResumePositionsStocks> buscarPosicoesUsuario(){
       List<StocksUserOperations> lista = serviceUserOperations.returnAllStocksOperations();
       List<ResumePositionsStocks> listaResume = new ArrayList();
       for(StocksUserOperations operacoes : lista){
          ResumePositionsStocks resumo = new ResumePositionsStocks();
          Object[] teste = serviceStocksData.findMaxDateCloseAndMaxValueClose();
          resumo.setTicket(operacoes.getStock().getTicket());
          resumo.setDateOperationBuy(operacoes.getDateOperateBuy());
          resumo.setPriceBuy(operacoes.getStockValueBuy());
          resumo.setQtdPriceBuy(operacoes.getQtdStocksBuy());
          resumo.setPercentValuation(calculatePercentPosition(operacoes));
          resumo.setActualPrice((Double) teste[0]);
          listaResume.add(resumo);            
       }
       return listaResume;
   }

   private Double calculatePercentPosition(StocksUserOperations operation){
      return -1.1;
   }
     

}