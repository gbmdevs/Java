package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.dto.balance.BalanceDTORequest
import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.repository.financial.Balance
import br.com.kotlin.estudos.services.BalanceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/balance")
class BalanceController(
    private val  balanceService: BalanceService
){
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findBalanceByUser(): List<Balance>?{
       return balanceService.findByUsuario()
    }

    @PostMapping
    fun insertBalance(@RequestBody request: BalanceDTORequest){
       balanceService.insertBalance(request)
    }


}