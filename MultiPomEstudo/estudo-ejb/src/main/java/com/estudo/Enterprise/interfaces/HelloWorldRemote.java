package com.estudo.Enterprise.interfaces;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote{
    public abstract String ola();
}