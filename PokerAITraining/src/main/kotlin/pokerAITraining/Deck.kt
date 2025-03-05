import java.util.Collections
import java.util.Random

class Deck {
    private val cards = mutableListOf<Card>()

    init {
        reset() // Initialize and shuffle on creation
    }

    fun reset() {
        cards.clear()
        val ranks = listOf("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A")
        val suits = listOf("?", "?", "?", "?")

        // Create all card combinations
        for (suit in suits) {
            for (rank in ranks) {
                cards.add(Card(rank, suit))
            }
        }

        // Shuffle using Collections.shuffle()
        Collections.shuffle(cards,Random(System.nanoTime()))
    }

    fun deal(num: Int): List<Card> {
        require(cards.size >= num) { "Not enough cards in the deck" }
        return List(num) { cards.removeAt(0) }
    }
}

data class Card(val rank: String, val suit: String) {
    override fun toString(): String = "$rank$suit"
}