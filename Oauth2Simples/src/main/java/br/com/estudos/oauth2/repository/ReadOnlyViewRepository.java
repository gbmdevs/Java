package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.Balance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.estudos.oauth2.dto.ResumeBalance;

import br.com.estudos.oauth2.dto.ViewDeTesteDTO;

import java.util.List;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
// Usar para todas as Views de Esqueleto

@NoRepositoryBean
public interface ReadOnlyViewRepository<T, ID> extends JpaRepository<T,ID>{
     
    List<T> findAll();

    List<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    Optional<T> findById(ID id);

    long count();


}