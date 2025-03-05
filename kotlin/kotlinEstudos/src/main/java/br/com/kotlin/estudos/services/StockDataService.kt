package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.stock.StockRequestDTO
import br.com.kotlin.estudos.model.repository.financial.Stock
import br.com.kotlin.estudos.model.repository.financial.StockDataHistory
import br.com.kotlin.estudos.model.repository.stock.ChartResponse
import br.com.kotlin.estudos.repository.StocksDataHistoryRepository
import br.com.kotlin.estudos.util.DateConverter
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import org.springframework.stereotype.Service
import com.google.gson.Gson

@Service
class StockDataService(private val stocksService: StocksService , private  val stocksDataHistoryRepository: StocksDataHistoryRepository){

    private val client = HttpClient(CIO)

    suspend fun getStockData(request: StockRequestDTO) {
        val listStocks = retrieveStocksTickets()
        listStocks.forEach {stocks ->
            callClientDataStocks(stocks.stockTicket,stocks.stockLoc,stocks,
                    DateConverter.convertDateToSecond(request.dateBegin),
                    DateConverter.convertDateToSecond(request.dateEnd))
        }
        closeClient()
    }

    // Fecha o cliente quando não for mais necessário
    fun closeClient() {
        client.close()
    }

    suspend fun callClientDataStocks(symbol: String, loc: String, stock: Stock, dateBegin: Long, dateEnd: Long){
        val gson = Gson()
        val jsonResponse: String = client.get("https://query1.finance.yahoo.com/v8/finance/chart/$symbol.$loc?formatted=true&includeAdjustedClose=true&interval=1d&period1=$dateBegin&period2=$dateEnd").body()
        println("Json: $jsonResponse")
        val chartResponse = gson.fromJson(jsonResponse, ChartResponse::class.java)
        println("Variavel: $chartResponse")
        if(chartResponse.chart != null){
           loadDataBalanceStocks(chartResponse,stock)
        }
    }

    fun retrieveStocksTickets(): List<Stock>{
        return stocksService.findAll();
    }
    fun loadDataBalanceStocks(response: ChartResponse, stock: Stock){
        try {
            response.chart.result.get(0).timestamp.forEachIndexed { index, date ->
                val stockDataHistory = StockDataHistory(
                    stock = stock,
                    dateStock = DateConverter.convertSecondToDate(date),
                    stockOpen = response.chart.result.get(0).indicators.quote.get(0).open.get(index).toBigDecimal(),
                    stockClose = response.chart.result.get(0).indicators.quote.get(0).close.get(index).toBigDecimal(),
                    stockHigh = response.chart.result.get(0).indicators.quote.get(0).high.get(index).toBigDecimal(),
                    stockLow = response.chart.result.get(0).indicators.quote.get(0).low.get(index).toBigDecimal()
                )
                stocksDataHistoryRepository.save(stockDataHistory)
            }
        }catch(ex: Exception){
            println("Erro no banco de dados $ex");
        }

    }
}