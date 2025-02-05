package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.dto.resumeOperation.ResumeOperationRequest
import br.com.kotlin.estudos.model.dto.resumeOperation.ResumeOperationResponse
import br.com.kotlin.estudos.model.repository.financial.StockUserOperation
import br.com.kotlin.estudos.services.UserResumeService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/user-resume")
class UserResumeController(private val userResumeService: UserResumeService){
    @GetMapping("/stocks-positions")
    fun resumeOperations(@RequestBody requestMapping: ResumeOperationRequest ): List<ResumeOperationResponse> {
        return userResumeService.findPositionStockMarket(requestMapping);
    }
}
  