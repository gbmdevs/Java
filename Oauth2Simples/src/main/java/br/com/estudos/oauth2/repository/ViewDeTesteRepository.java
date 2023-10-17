package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.Balance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.estudos.oauth2.dto.ResumeBalance;

import br.com.estudos.oauth2.model.ViewDeTeste;

import java.util.List;
import java.math.BigDecimal;
import java.util.UUID;

import br.com.estudos.oauth2.repository.ReadOnlyViewRepository;

public interface ViewDeTesteRepository extends ReadOnlyViewRepository<ViewDeTeste,Long>{
     
    List<ViewDeTeste> findAll(); 

}