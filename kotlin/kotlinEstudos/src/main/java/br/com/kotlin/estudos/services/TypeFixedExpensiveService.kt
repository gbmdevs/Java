package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.tipdespesa.TipDespesaDTO
import org.springframework.stereotype.Service
import br.com.kotlin.estudos.model.repository.financial.TypeFixedExpense
import br.com.kotlin.estudos.repository.TypeFixedExpenseRepository
import java.util.*


@Service
class TypeFixedExpensiveService(
    private val typeFixedExpenseRepository: TypeFixedExpenseRepository,
    private val usuarioService: UsuarioService
){

    fun listarTodos(): List<TypeFixedExpense> = typeFixedExpenseRepository.findAll().toList()

    fun salvar(tipDespesaDTO: TipDespesaDTO): TypeFixedExpense {
        try {
            val tipDespesa = TypeFixedExpense(
                    typeDesc = tipDespesaDTO.tipDespesaDesc,
                    usuario = usuarioService.findUserByEmailAuth(),
                    isFixed = true,
                    id = UUID.randomUUID()
            )
            return typeFixedExpenseRepository.save(tipDespesa)
        }catch (ex: Exception){
            println(ex)
            throw ex
        }

    }


}