package challenges

import java.io.File
import java.io.BufferedReader
import java.io.InputStream
import kotlin.collections.List
import kotlin.math.abs

import challenges.ReadFile

fun day7AOC() {
    println("Desafio dia 7 AOC 2024")
    val filePath = ReadFile.readFileInput("day7input.txt")
    val bufferedReader: BufferedReader = File(filePath).bufferedReader()
    bufferedReader.use {
        val text = it.readText()
        val lines = text.lines()
        lines.forEach{ line ->
            if (line.isNotBlank()) {
               val numbers = line.replace(":", "").trim().split(Regex("\\s+")).map {it.toInt()}
               calculateOperationPart1(numbers)
            }
        }
    }
}

fun calculateOperationPart1(numbers: List<Int>) {
    val result = numbers[0]
    val operation = 0
    for ((index, numero) in numbers.drop(1).withIndex()) {
        val multiply = numbers.size - 2
        val sum =  numbers.size - 2
        println("$index sum $sum Valor: $numero")
        if(index > 0){

        }

    }

}

