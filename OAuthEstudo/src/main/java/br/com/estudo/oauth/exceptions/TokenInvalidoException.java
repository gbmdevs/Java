package br.com.estudo.oauth.exceptions;


public class TokenInvalidoException extends ExemploOAuthException {
     public TokenInvalidoException(String message){
          super(message);
     }

     public TokenInvalidoException(Throwable cause){
          super(cause);
     }
}