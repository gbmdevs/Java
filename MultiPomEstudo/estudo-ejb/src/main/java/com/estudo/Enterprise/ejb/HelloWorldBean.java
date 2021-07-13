package com.estudo.Enterprise.ejb;

import javax.ejb.Stateless;
import com.estudo.Enterprise.interfaces.HelloWorldRemote;


@Stateless
public class HelloWorldBean implements HelloWorldRemote {
    public String ola() {
        return "Ola mundo com EJB.";
    }
}