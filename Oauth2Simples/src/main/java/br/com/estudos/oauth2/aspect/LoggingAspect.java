package br.com.estudos.oauth2.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.estudos.oauth2.model.Usuario;
import br.com.estudos.oauth2.repository.LogDetailsRepository;
import br.com.estudos.oauth2.model.LogDetails;

@Aspect
@Component
public class LoggingAspect { 

    @Autowired
    private LogDetailsRepository logRepository;

    // Pegar o log durante a inserção
    //@AfterReturning(pointcut = "execution(* org.springframework.data.repository.CrudRepository.save(..))", returning = "result")
    public void logInsertion(JoinPoint joinPoint, Object result) {
       //System.out.println("Entrei no log da insercao");
       if(result instanceof Usuario){
          System.out.println("Entrou na log do usuario");
          Usuario logUsuario = (Usuario) result;
          System.out.println("Sera persistido na log = " + logUsuario.toString());
          logRepository.save(new LogDetails("Inserção",logUsuario.getEmail()));
       }
    }

}