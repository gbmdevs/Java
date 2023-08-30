package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.Balance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudos.oauth2.dto.ResumeBalance;

import java.util.List;

@Repository
public interface BalanceRepository extends CrudRepository<Balance,Long>{
     
     @Query("SELECT new br.com.estudos.oauth2.dto.ResumeBalance(e.typeBalance,sum(e.value)) FROM Balance e " +
            "where e.typeBalance.situation = 'S' AND e.typeBalance.typeCompany = 'BANK' " + 
            "group by e.typeBalance.id")
     List<ResumeBalance> sumBalanceByTypeBalance();


}