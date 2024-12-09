package challenges

import java.io.File
import java.io.BufferedReader
import java.io.InputStream
import kotlin.collections.List
import kotlin.math.abs

import challenges.ReadFile

fun day2AOC() {
    println("Desafio dia 2 AOC 2024")
    val filePath = ReadFile.readFileInput("day2input.txt")
    val bufferedReader: BufferedReader = File(filePath).bufferedReader()
    var totalIsSafe       = 0
    var totalIsSafeRefact = 0
    bufferedReader.use {
        val text = it.readText()
        val lines = text.lines()
        lines.forEach { line ->
            if (line.isNotBlank()) {
                val numbers = line.trim().split(Regex("\\s+")).map { it.toInt() }
                totalIsSafe = totalIsSafe(numbers,totalIsSafe)
                totalIsSafeRefact = totalIsSafe(numbers,totalIsSafeRefact)

            }
        }
        println("Total isSafe parte 1: $totalIsSafe")
        println("Total isSafe parte 2: $totalIsSafeRefact")
        println("*-----------------------------------------------------------*")
    }
}
fun totalIsSafe(numbers: List<Int>,totalIsSafe: Int) : Int {
    var isInc  = false
    var isDesc = false
    var isSafe = true
    var diffAnt = 0
    var i = 0
    println("Entrada: $numbers")
    do {
        var diff = (numbers[i] - numbers[i+1]) * -1
        if(diff == 0){
            isSafe = false
            break
        }
        if(i == 0 ){
            if(diff > 3 || diff < -3){
                isSafe = false
                break
            }
            if(diff > 0){
                isInc  = true
            }else{
                isDesc = true
            }
        } else{
            if((isInc == true && (diff < 0 || diff > 3)) ||
                    (isDesc == true && (diff > 0 || diff < -3))){
                isSafe = false
                break
            }
        }
        diffAnt = diff
        i++
    }while(i < numbers.size -1)
    if(isSafe) println("Safe: $numbers")
    return if (isSafe) totalIsSafe + 1 else totalIsSafe
 }
