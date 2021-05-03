package HelloEjbEstudos.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorldRemote{
    public String ola(){
        return "Ola mundo EJB";
    }
     
}