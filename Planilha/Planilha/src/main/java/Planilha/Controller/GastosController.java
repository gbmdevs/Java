package Planilha.Controller;

import Planilha.Model.Gastos;
import java.util.Date;
import java.util.List;

public class GastosController {
   
    private Double totalSpent;
  //  private Date dataAtual;
    private List<Gastos> gastos;

 
public void setGastos(List<Gastos> gastos){
    this.gastos = gastos;
}

public void setTotalSpent(Double totalSpent){
    this.totalSpent = totalSpent;
}


}