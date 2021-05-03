package ChamaEJB;

//import HelloEJB.HelloEjbEstudos.ejb.HelloWorldRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TesteEJB{
    public static void main(String[] args){

        try{
            System.out.println("Iniciando Chamada");

            InitialContext ctx = new InitialContext();

            HelloWorldRemote ejb = (HelloWorldRemote) ctx.lookup
            ("HelloWorldBean");

        }catch(NamingException ex){
            ex.printStackTrace();
            System.out.println("Nao encontrou o EJB");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            
        }

    }
}