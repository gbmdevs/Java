package br.com.estudos.oauth2;

import org.flywaydb.core.Flyway;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.context.ActiveProfiles;
import org.flywaydb.test.annotation.FlywayTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringAppTest {

    protected static String jwtToken;

    @Autowired
    private Flyway flyway;
    @BeforeAll
    public void setup(){
        flyway.clean();
        flyway.migrate();
    }

} 