import kotlin.random.Random
import Deck

fun main() {
     repeat(2) { handNumber ->
         val deck = Deck() // New deck for each hand
        // println("Initial Deck: ${deck.deal(52).joinToString(" ")}")
         println("\n=== Hand ${handNumber + 1} ===")
         val ai1Hand = deck.deal(2)
         val ai2Hand = deck.deal(2)
         val communityCards = deck.deal(5)
         println("AI 1 Hand: ${ai1Hand.joinToString(" ")}")
         println("AI 2 Hand: ${ai2Hand.joinToString(" ")}")
         println("Community Cards: ${communityCards.joinToString(" ")}")

      }
}
