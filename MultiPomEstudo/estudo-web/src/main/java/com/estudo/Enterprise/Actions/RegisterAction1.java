package com.estudo.Enterprise.Actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 *
 * @author claudio
 */
public class RegisterAction1 extends Action {
    @Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
HttpServletRequest request, HttpServletResponse response) throws Exception {
            return(mapping.findForward("success"));
      }
}