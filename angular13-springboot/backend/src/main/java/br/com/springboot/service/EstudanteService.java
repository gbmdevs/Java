
package br.com.springboot.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import br.com.springboot.model.Estudante;
import br.com.springboot.repository.EstudanteRepository;

@Service
public class EstudanteService{

    @Autowired
    EstudanteRepository estudanteRepo;

public List<Estudante> getAllEstudantes(){
      List<Estudante> estudantes = new ArrayList<Estudante>();
      estudanteRepo.findAll().forEach(estudante -> estudantes.add(estudante));
      return estudantes;
}

public void saveOrUpdate(Estudante estudante){
    estudanteRepo.save(estudante);
}

}