package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.TypeBalance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface TypeBalanceRepository extends CrudRepository<TypeBalance,Long>{
     
     @Query("SELECT tb FROM TypeBalance tb WHERE tb.typeCompany= 'BROKER' AND tb.situation = 'S'")
     List<TypeBalance> findAllByBroker();

}