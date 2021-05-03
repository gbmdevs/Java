package HelloEjbEstudos.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote{
    public abstract String ola();
}