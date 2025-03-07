package br.com.kotlin.estudos

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.runApplication
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.test.context.ContextConfiguration

import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class APISpringApplicationTest {

    @Test
    fun testForApp(){ 
        println("Teste foi!");
    }
  
}
 