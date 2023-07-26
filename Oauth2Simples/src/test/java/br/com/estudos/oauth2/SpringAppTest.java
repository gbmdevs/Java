package br.com.estudos.oauth2;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.context.ActiveProfiles;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAppTest { 

    @Test
    public void AplicativoRodando(){
        System.out.println("Test");
    }

} 