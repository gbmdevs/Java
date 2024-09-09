package br.com.kotlin.estudos.services

import org.springframework.stereotype.Service
import br.com.kotlin.estudos.model.repository.TipDespesa
import br.com.kotlin.estudos.repository.TipDespesaRepository


@Service
class TipoDespesaFixaService(
    private val tipDespesaRepository: TipDespesaRepository
){

    fun listarTodos(): List<TipDespesa> = tipDespesaRepository.findAll().toList()

}