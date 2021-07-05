package com.estudos.guilherme.form;

import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm {
    String mensagem;

    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return this.mensagem;
    }
}