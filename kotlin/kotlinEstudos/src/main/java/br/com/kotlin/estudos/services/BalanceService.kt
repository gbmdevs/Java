package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.balance.BalanceDTORequest
import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.repository.financial.Balance
import br.com.kotlin.estudos.repository.BalanceRepository
import br.com.kotlin.estudos.repository.ResumeBalanceRepository
import br.com.kotlin.estudos.repository.TypeBalanceRepository
import org.springframework.stereotype.Service

@Service
class BalanceService(
    private val resumeBalanceRepository: ResumeBalanceRepository,
    private val typeBalanceRepository: TypeBalanceRepository,
    private val balanceRepository: BalanceRepository,
    private val usuarioService: UsuarioService
) {

    fun findByResumeBalance(): List<BalanceResumeResponse>?{
        try {
            return resumeBalanceRepository.findByResumeBalance()
        }catch (ex: Exception){
            println(ex)
            return null
        }
    }

    fun insertBalance(request: BalanceDTORequest){
        val typeBalance = typeBalanceRepository.findByType(request.typeBalance)
        if(typeBalance == null){
            throw  Exception()
        }
        val balance = Balance(
            typeBalance = typeBalance,
            dateConsume = request.dateConsume,
            valueConsume = request.value,
            user = usuarioService.findUserByEmailAuth(),
            description = request.description
        )
        balanceRepository.save(balance)
    }

    fun findByUsuario(): List<Balance>?{
        val usuario = usuarioService.findUserByEmailAuth()
        return balanceRepository.findByUser(usuario)
    }

}