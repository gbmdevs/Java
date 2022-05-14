package br.com.requisicao.util;

import com.google.gson.Gson;

import java.util.List;

public class ConverteJSON {

    public <T> String retornaJSON(T classe){
        return new Gson().toJson(classe);
    }

    public <T> String retornaJSON(List<T> classe){
        return new Gson().toJson(classe);
    }
}