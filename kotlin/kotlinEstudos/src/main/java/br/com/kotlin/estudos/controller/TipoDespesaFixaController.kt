package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.dto.tipdespesa.TipDespesaDTO
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import br.com.kotlin.estudos.services.TipoDespesaFixaService
import br.com.kotlin.estudos.model.repository.TipDespesa
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController 
@RequestMapping("/finance")
class TipoDespesaFixaController(
    private val  tipDespesaService: TipoDespesaFixaService
){
    @GetMapping("/tipdespesa")
    fun listaTipDespesa(): List<TipDespesa>  {        
        println("Entrou")
        return tipDespesaService.listarTodos()
    }

    @PostMapping("/tipdespesa")
    fun cadastrarTipDespesa(@RequestBody tipdespesaDTO: TipDespesaDTO): TipDespesa{
        return tipDespesaService.salvar(tipdespesaDTO)
    }
}