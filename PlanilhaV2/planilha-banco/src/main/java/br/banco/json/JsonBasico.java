package br.banco.json;

import java.util.List;

public class JsonBasico<T>{
      public List<T> dados;

    public List<T> getDados() {
        return this.dados;
    }

    public void setDados(List<T> dados) {
        this.dados = dados;
    }
}
