package br.com.estudos.oauth2.service;

import br.com.estudos.oauth2.dto.ResumePositionsStocks;
import br.com.estudos.oauth2.model.StocksUserOperations;
import br.com.estudos.oauth2.model.TypeBalance;
import br.com.estudos.oauth2.dto.ResumeInvestmentBalance;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserResumeService{

   @Autowired
   private StocksUserOperationsService serviceUserOperations;

   @Autowired
   private StocksDataService serviceStocksData;

   @Autowired
   private TypeBalanceService typeBalanceService;

   public List<ResumePositionsStocks> buscarPosicoesUsuario(){
       List<StocksUserOperations> lista = serviceUserOperations.returnAllStocksOperations();
       List<ResumePositionsStocks> listaResume = new ArrayList();
       for(StocksUserOperations operacoes : lista){
          ResumePositionsStocks resumo = new ResumePositionsStocks();
          BigDecimal actualPrice = serviceStocksData.findMaxDateCloseAndMaxValueClose(operacoes.getStock());
          resumo.setTicket(operacoes.getStock().getTicket());
          resumo.setDateOperationBuy(operacoes.getDateOperateBuy());
          resumo.setPriceBuy(operacoes.getStockValueBuy());
          resumo.setQtdPriceBuy(operacoes.getQtdStocksBuy());
          resumo.setPercentValuation(calculatePercentPosition(operacoes.getStockValueBuy(),actualPrice));
          resumo.setActualPrice(actualPrice);
          listaResume.add(resumo);            
       }
       return listaResume;
   }

   public List<ResumeInvestmentBalance> returnInvestimentBalance(){
      List<ResumeInvestmentBalance> resumeListInvest = new ArrayList();
      List<TypeBalance> lista = typeBalanceService.findAllByBroker();
      lista.forEach(item -> {
           resumeListInvest.add(new ResumeInvestmentBalance(item));
      });
      System.out.println("Tamanho do broker: " + lista.size());
      return resumeListInvest;
   }

   private BigDecimal calculatePercentPosition(BigDecimal priceBuy, BigDecimal actualPrice){
      if(priceBuy != null && actualPrice != null){
         BigDecimal diff = actualPrice.subtract(priceBuy);
         return diff.divide(priceBuy,new MathContext(4, RoundingMode.HALF_UP))
                    .multiply(new BigDecimal(100))
                    .setScale(2,RoundingMode.DOWN);
      }else{
         return new BigDecimal(0.0);
      }
   }
     

}