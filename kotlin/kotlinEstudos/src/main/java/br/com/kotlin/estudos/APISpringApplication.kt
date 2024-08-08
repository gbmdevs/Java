package br.com.kotlin.estudos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class APISpringApplication 
     fun main(args: Array<String>) {
         runApplication<APISpringApplication>(*args) 
     }
