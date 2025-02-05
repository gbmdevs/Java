package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.resumeOperation.ResumeOperationRequest
import br.com.kotlin.estudos.model.dto.resumeOperation.ResumeOperationResponse
import br.com.kotlin.estudos.model.repository.financial.StockUserOperation
import br.com.kotlin.estudos.repository.StocksDataHistoryRepository
import br.com.kotlin.estudos.repository.StocksUserOperationRepository
import br.com.kotlin.estudos.repository.UserResumeRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class UserResumeService(
        private val stockUserOperationRepository: StocksUserOperationRepository,
    private val userResumeRepository: UserResumeRepository
) {
    fun findAll(): List<StockUserOperation> = stockUserOperationRepository.findAll().toList()
    fun findPositionStockMarket(request: ResumeOperationRequest) : List<ResumeOperationResponse> {
        return userResumeRepository.findPositionStockMarket(request)
    }
}