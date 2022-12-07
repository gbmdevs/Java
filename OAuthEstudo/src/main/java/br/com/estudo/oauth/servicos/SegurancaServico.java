package br.com.estudo.oauth.servicos;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.error.OAuthError.CodeResponse;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

@Service
public class SegurancaServico {

    private final String APP_CLIENT_ID = "exemploaplicativocliente";

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OAuthResponse logarOAuth(HttpServletRequest requisicao){
        try{

            OAuthTokenRequest oauthRequest = new OAuthTokenRequest(requisicao);
            String appClientId             = oauthRequest.getClientId();
            String appClientSecret         = oauthRequest.getClientSecret();

            return OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK)
            .setParam("nome","Jamalzin")
            .buildJSONMessage();
        }catch(OAuthProblemException ex) {
             ex.printStackTrace();
             return this.retornarErroOAuth(HttpServletResponse.SC_UNAUTHORIZED,CodeResponse.INVALID_REQUEST,ex);
        }catch(Exception ex){ 
            ex.printStackTrace();
            return this.retornarErroOAuth(HttpServletResponse.SC_BAD_REQUEST, CodeResponse.SERVER_ERROR, ex);
        }
    }

    // Retornar erro em JSON
    public OAuthResponse retornarErroOAuth(int errorCode, String error, Exception e){
        try{
            String descricao = e.getMessage();
            return OAuthASResponse.errorResponse(errorCode)
               .setError(error + (descricao != null ? " - " + descricao : ""))
               .setErrorDescription(descricao)
               .buildJSONMessage();
        }catch(OAuthSystemException ex){
            throw new RuntimeException(ex);
        }
    }

}