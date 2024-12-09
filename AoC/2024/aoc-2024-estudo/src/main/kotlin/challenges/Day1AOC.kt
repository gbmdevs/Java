package challenges

import java.io.File
import java.io.BufferedReader
import java.io.InputStream
import kotlin.collections.List
import kotlin.math.abs

import challenges.ReadFile

fun day1AOC(){
  println("*-----------------------------------------------------------*")
  println("Desafio dia 1 AOC 2024")
  val filePath = ReadFile.readFileInput("day1input.txt")
  val bufferedReader: BufferedReader = File(filePath).bufferedReader()

      var result = 0
      var result2 = 0

      bufferedReader.use {
        val text = it.readText()
        val lines = text.lines()

        val leftNumbers    = mutableListOf<Int>()
        val rightNumbers   = mutableListOf<Int>()
        val numberDistinct: List<Int>

        lines.forEach { line ->
          if(line.isNotBlank()){
            val numbers = line.trim().split(Regex("\\s+")).map { it.toInt() }
            if (numbers.size == 2) {
              leftNumbers.add(numbers[0])
              rightNumbers.add(numbers[1])
            }
          }

        }
        leftNumbers.sort()
        rightNumbers.sort()

        leftNumbers.forEachIndexed { index, element ->
          result += abs((element - rightNumbers[index]) * -1)
          val count = rightNumbers.count {it == element}
          result2 += abs(element * count)
        }
      }

      println("Resultado parte1: $result")
      println("Resultado parte2: $result2")
  println("*-----------------------------------------------------------*")
}