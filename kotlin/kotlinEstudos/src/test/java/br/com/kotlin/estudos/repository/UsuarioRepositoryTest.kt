package br.com.kotlin.estudos.repository

import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
import kotlin.test.assertEquals

@SpringBootTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    private lateinit var userRepository: UsuarioRepository

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @Test
    fun `should inject userRepository`() {
        val count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM usuario", Int::class.java)
        print(count)
        assertNotNull(userRepository)
    }
}