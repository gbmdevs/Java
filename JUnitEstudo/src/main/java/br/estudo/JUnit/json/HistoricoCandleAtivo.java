package br.estudo.JUnit.json;

import java.util.Map;
import br.estudo.JUnit.json.DataCandleAtivo;

public class HistoricoCandleAtivo {

   private Map<String, Map<String,DataCandleAtivo>> dataCandleAtivo;

    public Map<String,Map<String,DataCandleAtivo>> getDataCandleAtivo() {
        return this.dataCandleAtivo;
    }

    public void setDataCandleAtivo(Map<String,Map<String,DataCandleAtivo>> dataCandleAtivo) {
        this.dataCandleAtivo = dataCandleAtivo;
    }





}