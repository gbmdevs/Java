package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.repository.financial.TypeBalance
import br.com.kotlin.estudos.repository.TypeBalanceRepository
import org.springframework.stereotype.Service

@Service
class TypesService(
   private val typeBalanceRepository: TypeBalanceRepository
) {

    fun findAllTypeBalance(): List<TypeBalance>{
        return typeBalanceRepository.findAll().toList()
    }

}