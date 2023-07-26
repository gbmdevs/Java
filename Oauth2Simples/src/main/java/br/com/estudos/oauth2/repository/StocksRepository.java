package br.com.estudos.oauth2.repository;

import java.util.Optional;
import java.util.List;

import br.com.estudos.oauth2.model.Stocks;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface StocksRepository extends CrudRepository<Stocks,Long>{

    List<Stocks> findAll();

    Optional<Stocks> findByTicket(String ticket);


}