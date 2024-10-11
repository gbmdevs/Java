package br.com.kotlin.estudos.model.repository.mapper

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class BalanceRowMapper: RowMapper<BalanceResumeResponse> {
    override fun mapRow(rs: ResultSet, rowNum: Int): BalanceResumeResponse {
        val type = rs.getInt("type")
        val typeName = rs.getString("type_name")
        val valueConsume = rs.getBigDecimal("value_consume")
        return BalanceResumeResponse(type, typeName, valueConsume)
    }
}