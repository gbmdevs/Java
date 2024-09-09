package br.com.kotlin.estudos.repository

import java.util.Optional

import br.com.kotlin.estudos.model.repository.TipDespesa

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TipDespesaRepository : CrudRepository<TipDespesa, Long> {

}