package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.dto.stock.StockRequestDTO
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import br.com.kotlin.estudos.services.StockDataService
import org.springframework.web.bind.annotation.PostMapping
import br.com.kotlin.estudos.model.stock.ChartResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

@RestController 
@RequestMapping("/stockmarket")
class StocksController(
    private val  stockDataService: StockDataService
){
    @PostMapping("/loadall")
    suspend fun loadStockMarket(@RequestBody request: StockRequestDTO): ResponseEntity<String>{
        println("Entrou carga Stock")
        stockDataService.getStockData(request)
        return ResponseEntity.ok("Retorno data stock")
    }


}