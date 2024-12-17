
class Main

private val days = listOf<Day<*>>(
    Day01
)

fun main(args: Array<String>){
    if (args.isNotEmpty()) {
        val number = args[0].toInt()
        days.find { it.number == number }?.also { printDay(it) } ?: error("Day $number not found!")
    } else{
        days.forEach { printDay(it) }
    }
}

private fun printDay(day: Day<*>) {
    val header = "=== Dia ${day.number.toString().padStart(2, '0')}: ${day.title} ==="
    val footer = "=".repeat(header.length)
    println(header)
    println("|> Parte 1: ${day.partOne()}")
    println("|> Parte 2: ${day.partTwo()}")
    println(footer)
}