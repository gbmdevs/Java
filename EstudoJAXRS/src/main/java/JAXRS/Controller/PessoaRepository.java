package Planilha.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


import Planilha.Model.Pessoa;

public class PessoaRepository{
    private final static HashMap<Integer, Pessoa> pessoas = new HashMap();

    public List<Pessoa> GetAll(){
        return new ArrayList<Pessoa>(pessoas.values());
    }
}