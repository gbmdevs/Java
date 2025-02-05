package br.com.kotlin.estudos.repository.impl

import br.com.kotlin.estudos.model.dto.resumeOperation.ResumeOperationRequest
import br.com.kotlin.estudos.model.dto.resumeOperation.ResumeOperationResponse
import br.com.kotlin.estudos.repository.UserResumeRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.util.*

@Repository
class UserResumeRepositoryImpl: UserResumeRepository {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun findPositionStockMarket(request: ResumeOperationRequest): List<ResumeOperationResponse> {
        val query = entityManager.createNativeQuery(
            """
SELECT sto.id,s.stock_ticket,sto.oper_buy_price,
IFNULL(sdh.stock_close,0),
sdh.stock_date,(sdh.stock_close - sto.oper_buy_price) 
as valuation,
sto.oper_buy_qt 
FROM STOCK_USER_OPER sto
INNER JOIN STOCK s ON s.id = sto.stock_id
LEFT JOIN STOCK_DATA_HIST sdh ON sdh.stock_id = s.id
WHERE sdh.stock_date = ( select max(sdh2.stock_date) from stock_data_hist  sdh2)
or sdh.stock_date is null  
and (sto.oper_situation = :situation or :situation is null)
order by valuation desc
            """
        )
        query.setParameter("situation", request.situation)
        return query.resultList.map { row ->
            val rowArray = row as Array<*>
            ResumeOperationResponse(
                id           = (rowArray[0] as String),
                ticket       = (rowArray[1] as String),
                operBuyPrice = (rowArray[2] as? BigDecimal),
                stockClose   = (rowArray[3] as BigDecimal),
                stockDate    = (rowArray[4] as? Date),
                operBuyQtd   = (rowArray[6] as? BigDecimal)
            )
        }
    }

}