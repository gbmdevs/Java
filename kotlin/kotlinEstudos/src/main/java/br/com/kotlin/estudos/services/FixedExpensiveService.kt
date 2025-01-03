package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.tipdespesa.TipDespesaDTO
import org.springframework.stereotype.Service
import br.com.kotlin.estudos.model.repository.TypeFixedExpense
import br.com.kotlin.estudos.repository.TypeFixedExpenseRepository


@Service
class FixedExpensiveService(
    private val typeFixedExpenseRepository: TypeFixedExpenseRepository,
    private val usuarioService: UsuarioService
){

    fun listarTodos(): List<TypeFixedExpense> = typeFixedExpenseRepository.findAll().toList()

    fun salvar(tipDespesaDTO: TipDespesaDTO): TypeFixedExpense{
        try {
            val tipDespesa = TypeFixedExpense(
                    tipoDesc = tipDespesaDTO.tipDespesaDesc,
                    usuario = usuarioService.findUserByEmailAuth(),
                    tipo = null
            )
            return typeFixedExpenseRepository.save(tipDespesa)
        }catch (ex: Exception){
            println(ex)
            throw ex
        }

    }


}