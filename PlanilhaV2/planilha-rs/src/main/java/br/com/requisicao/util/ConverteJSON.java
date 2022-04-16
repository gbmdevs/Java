package br.com.requisicao.util;

import com.google.gson.Gson;

public class ConverteJSON {


    public <T> String retornaJSON(T classe){
        return new Gson().toJson(classe);
    }

}