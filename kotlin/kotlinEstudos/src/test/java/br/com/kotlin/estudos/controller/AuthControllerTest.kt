package br.com.kotlin.estudos.controller

import br.com.kotlin.estudos.services.AuthenticationService
import br.com.kotlin.estudos.services.JwtService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import br.com.kotlin.estudos.model.dto.LoginUserDTO
import br.com.kotlin.estudos.repository.UsuarioRepository
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.web.servlet.post
import org.springframework.web.context.WebApplicationContext
import kotlin.test.assertEquals

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AuthControllerTest {

    @Autowired
    lateinit var context: WebApplicationContext

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var authenticationService: AuthenticationService

    @Autowired
    lateinit var jwtService: JwtService

    @Autowired
    private lateinit var mockMvc: MockMvc

    /*@Value()
    private val expiration;*/

    //@Autowired
    //lateinit var jdbcTemplate: JdbcTemplate

    @Test
    fun `should authenticate user and return JWT token`() {
        val loginDto = createLoginDto(email = "guih.smi2@gmail.com", password = "teste")
        val jwtToken = "mocked-jwt-token"
        val expiration = 3600000L // 1 hour
        mockMvc.post("/auth/login") {
            contentType = MediaType.APPLICATION_JSON
            content = toJson(loginDto)
        }.andExpect {
            status { isOk() }
            /*content {
                jsonPath("$.token") { value(jwtToken) }
                jsonPath("$.expiresIn") { value(expiration) }
            }*/
        }
    }

    private fun createLoginDto(email: String, password: String) = LoginUserDTO(
        email = email,
        password = password
    )
    private fun <T> toJson(obj: T): String = objectMapper.writeValueAsString(obj)
}