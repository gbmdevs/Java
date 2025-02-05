package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.model.repository.Vote
import br.com.kotlin.estudos.repository.VoteRepository
import org.springframework.stereotype.Controller
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo

@Controller
class VoteController(private val voteRepository: VoteRepository) {
    @MessageMapping("/vote")
    @SendTo("/topic/votes")
    fun handleVote(option: String): Map<String, Int> {
        val vote = voteRepository.findByOption(option) ?: Vote(option = option)
        vote.count++
        voteRepository.save(vote)
        return voteRepository.findAll().associate { it.option to it.count }
    }
}