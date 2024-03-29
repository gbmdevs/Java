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
import java.util.stream.IntStream;

@Service
public class UserResumeService{

   @Autowired
   private StocksUserOperationsService serviceUserOperations;

   @Autowired
   private StocksDataService serviceStocksData;

   @Autowired
   private TypeBalanceService typeBalanceService;

   @Autowired
   private BalanceService balanceService;


   public List<ResumePositionsStocks> buscarPosicoesUsuario(String status){
       List<StocksUserOperations> lista = serviceUserOperations.findBySitOperation(status);
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
      IntStream.range(0,lista.size()).forEach(index ->{
          resumeListInvest.add(new ResumeInvestmentBalance(lista.get(index)));          
          resumeListInvest.get(index).setAvailableBalance(
                   balanceService.findAvailableBalanceByTypeBalance(lista.get(index).getId()));
          resumeListInvest.get(index).setTotalBalance(sumQuantityValueStock(lista.get(index)));
      });         
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
     

   private BigDecimal sumQuantityValueStock(TypeBalance broker){
      Double sum = 0.0;
      List<ResumePositionsStocks> lista = buscarPosicoesUsuario("A");
      for(ResumePositionsStocks operacoes : lista){
         Double value = (operacoes.getActualPrice().doubleValue() * operacoes.getQtdPriceBuy());
         sum = sum + value;
      }
      return new BigDecimal(sum).setScale(2,RoundingMode.DOWN);
   } 

}