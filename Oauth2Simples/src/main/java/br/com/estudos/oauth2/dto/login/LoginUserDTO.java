package br.com.estudos.oauth2.dto.login;

public class LoginUserDTO {
    private String email;
    private String password;

    public LoginUserDTO(){
        
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Login={email="+this.email+",senha="+this.password+"}";
    }

}