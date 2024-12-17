
import kotlin.math.abs

object Day01 : Day<Long>(1, "Trebuchet?!") {
    private val words: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    override fun partOne(input: List<String>): Long {
        return input.sumOf{calibrationValue(it)}
    }

    override fun partTwo(input: List<String>): Long {
        return input.sumOf { row ->
            calibrationValue(row.mapIndexedNotNull { index, c ->
                if (c.isDigit()) c
                else
                    row.possibleWordsAt(index).firstNotNullOfOrNull { candidate ->
                        words[candidate]
                    }
               }.joinToString()
            )
        }
    }

    private fun calibrationValue(row: String): Long {
        return "${row.first { it.isDigit() }}${row.last { it.isDigit() }}".toLong()
    }

    private fun String.possibleWordsAt(startingAt: Int): List<String> =
        (3..5).map { len ->
            substring(startingAt, (startingAt + len).coerceAtMost(length))
    }

    override val partOneTestExamples: Map<List<String>, Long> = mapOf(
        listOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet"
        ) to 142
    )

    override val partTwoTestExamples: Map<List<String>, Long> = mapOf(
        listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        ) to 281
    )
}