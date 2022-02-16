package br.estudo.JUnit.json;

import br.estudo.JUnit.json.DataCandleAtivo;

public class HistoricoCandleAtivo {

      private String data;
      private DataCandleAtivo dataCandle;

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataCandleAtivo getDataCandle() {
        return this.dataCandle;
    }

    public void setDataCandle(DataCandleAtivo dataCandle) {
        this.dataCandle = dataCandle;
    }
}