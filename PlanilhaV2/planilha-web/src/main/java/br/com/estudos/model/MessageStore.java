package br.com.estudos.model;

import java.util.ArrayList;
import java.util.List;

public class MessageStore {
    private String message;
    private List<String> listBuscadores;
    private List<String> listEmails;

    
    public MessageStore() {
        message = "Hello Struts do Jamal";
        listBuscadores = new ArrayList<String>();
        listBuscadores.add("Guilherme Braga");
        listBuscadores.add("Lais Gois Braga");
        listEmails     = new ArrayList<String>();
        listEmails.add("guih.smi2@outlook.com");
        listEmails.add("laaisgois@hotmail.com");
        listEmails.add("emails2@hotmail.com");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getListBuscadores() {
        return this.listBuscadores;
    }

    public void setListBuscadores(List<String> listBuscadores) {
        this.listBuscadores = listBuscadores;
    }
    
    public List<String> getListEmails() {
        return this.listEmails;
    }

    public void setListEmails(List<String> listEmails) {
        this.listEmails = listEmails;
    }

}