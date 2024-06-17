package br.com.estudos.oauth2.dto.login;

public class LoginResponse{

    private String token;
    private long expiresIn;

    public LoginResponse(){

    }

    public LoginResponse(String token,long expiresIn){
        this.token     = token;
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }


}