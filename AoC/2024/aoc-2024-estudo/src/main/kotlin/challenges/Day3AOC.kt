package challenges

import java.io.File
import java.io.BufferedReader
import java.io.InputStream
import kotlin.collections.List
import kotlin.math.abs

import challenges.ReadFile

fun day3AOC() {
    println("Desafio dia 3 AOC 2024")
    val filePath = ReadFile.readFileInput("day3input.txt")
    val bufferedReader: BufferedReader = File(filePath).bufferedReader()
    bufferedReader.use {
        val text = it.readText()
        val lines = text.lines()
        regexLocatePart1(text)
        regexLocatePart2(text)
    }
}

fun regexLocatePart1(text: String){
    var result = 0
    val regex = Regex("mul[\\(](\\d+),(\\d+)[\\)]")
    val matches = regex.findAll(text)
    matches.forEach { match ->
        var (num1, num2) = match.destructured
        result += abs(num1.toInt() * num2.toInt())
    }
    println("Resultado multi part1: $result")
}

fun regexLocatePart2(text: String){
    var result = 0
    val regex = Regex("(?s)don't\\(\\)(?:[^d]++|d(?!o\\(\\)))*+(?:do\\(\\)|${'$'})|mul\\((\\d+),(\\d+)\\)")
    val matches = regex.findAll(text)
    matches.forEach { match ->
        var (num1, num2) = match.destructured
        if(num2.isNotBlank()){
            result += abs(num1.toInt() * num2.toInt())
        }

    }

    println("Resultado multi part2: $result")
    println("*-----------------------------------------------------------*")
}