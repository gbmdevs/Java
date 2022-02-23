
package br.estudo.JUnit.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;


public class HistoricoAtivo{
     @JsonProperty("Meta Data")
     private MetaInfoAtivo mia;

     @JsonProperty("Time Series (Daily)")
     private HistoricoCandleAtivo listaHistorico;



    public MetaInfoAtivo getMia() {
        return this.mia;
    }

    public void setMia(MetaInfoAtivo mia) {
        this.mia = mia;
    }

    public HistoricoCandleAtivo getListaHistorico() {
        return this.listaHistorico;
    }

    public void setListaHistorico(HistoricoCandleAtivo listaHistorico) {
        this.listaHistorico = listaHistorico;
    }


}