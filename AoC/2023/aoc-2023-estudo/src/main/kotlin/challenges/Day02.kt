
import kotlin.math.abs

object Day02 : Day<Long>(2, "Cube Conundrum") {

    override fun partOne(input: List<String>): Long {
        val games: List<Game> = input.map {Game.of(it)}
        return games.filter {
            it.isPossible(12,13,14)
        }.sumOf{it.id}.toLong()
    }

    override fun partTwo(input: List<String>): Long {
        val games: List<Game> = input.map {Game.of(it)}
        return games.sumOf{ it.power() }
    }


    // Objeto jogo Elf
    private data class Game(val id: Int,val red: Int, val green: Int,val blue: Int){

        fun isPossible(red: Int, green: Int, blue: Int) =
            this.red <= red && this.green <= green && this.blue <= blue

        fun power(): Long {
            return (red * green * blue).toLong()
        }

        companion object{
            fun of(input: String): Game{
                val id = input.substringAfter(" ").substringBefore(":").toInt()
                val colors = mutableMapOf<String,Int>()

                input.substringAfter(":").split(";").forEach { turn ->
                    turn.split(",").map {it.trim()}.forEach { draw ->
                        val drawNum = draw.substringBefore(" ").toInt()
                        val color = draw.substringAfter(" ")
                        colors[color] = maxOf(drawNum, colors[color] ?: drawNum)
                    }
                }
                return Game(id, colors["red"] ?: 0, colors["green"] ?: 0, colors["blue"] ?: 0)
            }
        }
    }


    override val partOneTestExamples: Map<List<String>, Long> = mapOf(
        listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        ) to 8
    )

    override val partTwoTestExamples: Map<List<String>, Long> = mapOf(
        listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        ) to 2286
    )
}