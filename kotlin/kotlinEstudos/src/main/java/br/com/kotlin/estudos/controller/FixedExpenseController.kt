package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.dto.fixedExpense.FixedExpenseDTO
import br.com.kotlin.estudos.model.repository.financial.FixedExpense
import br.com.kotlin.estudos.services.BalanceService
import br.com.kotlin.estudos.services.FixedExpensiveService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/finance/fixed-expense")
class FixedExpenseController(
    private val  fixedExpensiveService: FixedExpensiveService
){
    private val logger = LoggerFactory.getLogger(FixedExpenseController::class.java)

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun insertFixedExpense(@RequestBody fixedExpenseDTO: FixedExpenseDTO): FixedExpense{
        logger.info("Recebendo dados: $fixedExpenseDTO")
        return fixedExpensiveService.save(fixedExpenseDTO)
    }
    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    fun returnAllFixedExpensive(): List<FixedExpense>?{
        logger.info("Entrou da despesa fixa");
        return fixedExpensiveService.findAll()
    }

   /* @GetMapping("/historic")
    @ResponseStatus(HttpStatus.OK)
    fun findHistoricByBalance(): List<BalanceResumeResponse>?{
        println("Entrou balance")
        return balanceService.findByResumeBalance()
    }*/

}