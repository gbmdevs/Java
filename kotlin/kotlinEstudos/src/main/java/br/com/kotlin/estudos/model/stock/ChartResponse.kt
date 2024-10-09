package br.com.kotlin.estudos.model.stock

data class ChartResponse(
        val chart: ChartResult
)

data class ChartResult(
        val result: List<Result>,
        val error: String? = null
)

data class Result(
        val meta: Meta,
        val timestamp: List<Long>,
        val indicators: Indicators
)

data class Meta(
        val currency: String,
        val symbol: String,
        val exchangeName: String,
        val fullExchangeName: String,
        val instrumentType: String,
        val firstTradeDate: Long,
        val regularMarketTime: Long,
        val regularMarketPrice: Double
)

data class Indicators(
        val quote: List<Quote>
)

data class Quote(
        val open: List<Double>,
        val volume: List<Long>,
        val low: List<Double>,
        val close: List<Double>,
        val high: List<Double>
)