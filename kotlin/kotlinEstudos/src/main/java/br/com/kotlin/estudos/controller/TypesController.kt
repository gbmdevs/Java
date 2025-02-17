package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.dto.balance.BalanceDTORequest
import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.repository.financial.Balance
import br.com.kotlin.estudos.model.repository.financial.TypeBalance
import br.com.kotlin.estudos.services.BalanceService
import br.com.kotlin.estudos.services.TypesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/types")
class TypesController(
    private val  typesService: TypesService
){
    @GetMapping("/balance")
    @ResponseStatus(HttpStatus.OK)
    fun loadStockMarket(): List<TypeBalance>?{
        return typesService.findAllTypeBalance()
    }

}