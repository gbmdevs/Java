package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.dto.fixedExpense.FixedExpenseDTO
import br.com.kotlin.estudos.services.BalanceService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fixed-expense")
class FixedExpenseController(
    private val  balanceService: BalanceService
){
    private val logger = LoggerFactory.getLogger(FixedExpenseController::class.java)
    // Cadastrar uma despesa fixa
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun insertFixedExpense(@RequestBody fixedExpenseDTO: FixedExpenseDTO){
        logger.info("Recebendo dados: $fixedExpenseDTO")
    }

    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    fun loadStockMarket(): List<BalanceResumeResponse>?{
        println("Entrou balance")
        return balanceService.findByResumeBalance()
    }

    @GetMapping("/historic")
    @ResponseStatus(HttpStatus.OK)
    fun findHistoricByBalance(): List<BalanceResumeResponse>?{
        println("Entrou balance")
        return balanceService.findByResumeBalance()
    }


}