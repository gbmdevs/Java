package br.com.kotlin.estudos.util

import java.sql.Date
import java.time.*
import java.time.format.DateTimeFormatter

object DateConverter {
    fun convertSecondToDate(seconds: Long): LocalDate{
       return  Instant.ofEpochSecond(seconds).atZone(ZoneId.systemDefault()).toLocalDate()
    }
    fun formatLocalDateToString(date: LocalDate): String{
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return date.format(formatter)
    }

    fun convertDateToSecond(date: LocalDate): Long{
        val localDateTime = date.atStartOfDay()
        return localDateTime.toEpochSecond(ZoneOffset.UTC)
    }
}