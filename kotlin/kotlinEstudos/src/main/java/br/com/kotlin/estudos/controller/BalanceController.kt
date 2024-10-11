package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.dto.stock.StockRequestDTO
import br.com.kotlin.estudos.model.repository.Balance
import br.com.kotlin.estudos.services.StockDataService
import br.com.kotlin.estudos.model.stock.ChartResponse
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


}