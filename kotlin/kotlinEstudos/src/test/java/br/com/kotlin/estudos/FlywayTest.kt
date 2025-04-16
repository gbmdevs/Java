package br.com.kotlin.estudos

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
import kotlin.test.assertEquals

@SpringBootTest
@ActiveProfiles("test")
class FlywayTest {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @Test
    fun `test flyway migration for test profile`() {
        val count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM usuario", Int::class.java)
        assertEquals(1, count, "Expected one user in test DB")
    }
}