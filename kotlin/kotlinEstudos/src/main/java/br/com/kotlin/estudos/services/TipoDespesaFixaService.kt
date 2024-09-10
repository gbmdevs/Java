package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.tipdespesa.TipDespesaDTO
import org.springframework.stereotype.Service
import br.com.kotlin.estudos.model.repository.TipDespesa
import br.com.kotlin.estudos.repository.TipDespesaRepository


@Service
class TipoDespesaFixaService(
    private val tipDespesaRepository: TipDespesaRepository,
    private val usuarioService: UsuarioService
){

    fun listarTodos(): List<TipDespesa> = tipDespesaRepository.findAll().toList()

    fun salvar(tipDespesaDTO: TipDespesaDTO): TipDespesa{
        try {
            val tipDespesa = TipDespesa(
                    tipoDesc = tipDespesaDTO.tipDespesaDesc,
                    usuario = usuarioService.findUserByEmailAuth(),
                    tipo = null
            )
            return tipDespesaRepository.save(tipDespesa)
        }catch (ex: Exception){
            println(ex)
            throw ex
        }

    }


}