package com.estudo.Enterprise.Actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.estudo.Enterprise.interfaces.HelloWorldRemote;

/**
 *
 * @author claudio
 */
public class RegisterAction1 extends Action {
    @Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
HttpServletRequest request, HttpServletResponse response) throws Exception {
            
       try{
         //Método que faz o lookup para encontrar o EJB de HelloWorldRemote.
         InitialContext ctx = new InitialContext();

         HelloWorldRemote ejb = (HelloWorldRemote) ctx.lookup
         ("ejb:estudo-ear/estudo-web/HelloWorldBean!com.estudo.Enterprise.interfaces.HelloWorldRemote");
 
         System.out.println(ejb.ola());

       } catch(NamingException ex){
          ex.printStackTrace();
          System.out.println("Não encontrou EJB.");
       } catch(Exception ex){
          ex.printStackTrace();
          System.out.println(ex.getMessage());
       }
            return(mapping.findForward("success"));
      }
}