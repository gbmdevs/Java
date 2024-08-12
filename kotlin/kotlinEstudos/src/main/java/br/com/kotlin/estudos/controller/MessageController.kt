package br.com.kotlin.estudos.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
class MessageController{
    @GetMapping("/")
    fun index(): Boolean = true
}
  