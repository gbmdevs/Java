package br.com.estudo.oauth.model;


import br.com.estudo.oauth.utils.Modelos;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permissao extends Modelos {

    @Id
    private Long id;

    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}