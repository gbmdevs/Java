package JAXRS.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;



import JAXRS.Model.Pessoa;

public class PessoaRepository{
    private final static HashMap<Integer, Pessoa> pessoas = new HashMap();

    // Busca todos
    public List<Pessoa> GetAll(){       
        return new ArrayList<Pessoa>(pessoas.values());
    }

    // Filtrar pelo ID
    public Pessoa Get(final int id){
         return pessoas.get(id);
    }

    // Adicionar uma Pessoa
    public void Add(final Pessoa pessoa) {
        if(pessoa.getId() == 0 )
            pessoa.setId(generateId(pessoas.size() + 1));
        pessoas.put(pessoa.getId(), pessoa);
    }

    // Gerar o ID
    private int generateId(final int possible)
    {
        if(pessoas.containsKey(possible))
            return generateId(possible + 1);
        return possible;
    }

}