package com.estudos.guilherme.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.estudos.guilherme.form.HelloWorldForm;

public class HelloWorldAction extends Action{
    
    public ActionForward execute(ActionMapping mapping,ActionForm form,
        HttpServletRequest request,HttpServletResponse response)
        throws Exception {
        
        System.out.println(request.getServletContext().getRealPath( "/" ));
        
        HelloWorldForm helloWorldForm = (HelloWorldForm) form;
        helloWorldForm.setMensagem("Estudos de Struts Funcionou!");
        
        return mapping.findForward("success");
    }
    
}