package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.repository.StockDataHistory
import br.com.kotlin.estudos.model.repository.StockUserOperation
import br.com.kotlin.estudos.services.UserResumeService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/user-resume")
class UserResumeController(private val userResumeService: UserResumeService){
    @GetMapping("/stocks-positions")
    fun index(): List<StockUserOperation> {
        return userResumeService.findAll()
    }
}
  