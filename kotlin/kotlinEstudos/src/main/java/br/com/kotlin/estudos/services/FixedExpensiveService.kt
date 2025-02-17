package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.dto.fixedExpense.FixedExpenseDTO
import br.com.kotlin.estudos.model.dto.tipdespesa.TipDespesaDTO
import br.com.kotlin.estudos.model.repository.financial.FixedExpense
import br.com.kotlin.estudos.model.repository.financial.Stock
import br.com.kotlin.estudos.model.repository.financial.TypeFixedExpense
import br.com.kotlin.estudos.repository.FixedExpensiveRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FixedExpensiveService(
        private val fixedExpensiveRepository: FixedExpensiveRepository,
        private val typeFixedExpensiveService: TypeFixedExpensiveService
) {
    fun findAll(): List<FixedExpense> = fixedExpensiveRepository.findAll().toList()

    fun save(fixedExpenseDTO: FixedExpenseDTO): FixedExpense {
        try {
            var typeFixedExpense = fixedExpenseDTO.typeFixedExpense?.let { typeFixedExpensiveService.findById(it.id) }
            val fixedExpense = FixedExpense(
                id = UUID.randomUUID(),
                typeFixedExpense = typeFixedExpense ,
                dueDate = fixedExpenseDTO.dueDate,
                valueExpenseActual = fixedExpenseDTO.value
            )
            return fixedExpensiveRepository.save(fixedExpense)
        }catch (ex: Exception){
            println(ex)
            throw ex
        }

    }
    //fun save(fixedExpensive: FixedExpense): FixedExpense = fixedExpensiveRepository.save(fixedExpensive)
}