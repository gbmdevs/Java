package br.com.estudos.oauth2.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.PrePersist;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import java.util.Arrays;
import java.util.Collection;

@Table(name = "usuario")
@Entity
public class Usuario implements UserDetails { 

    @Id
    @Column(nullable = false)
    private UUID id;
    
    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="token")
    private String token;

    public Usuario(String username,String email,String password){
        this.username  = username;
        this.email = email;
        this.password = password;
        this.token = "";
        this.id = UUID.randomUUID();
    }

    public Usuario(){

    }


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return this.username;
    }

    public void setNome(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @PrePersist
    public void prePersist(){
         this.id = UUID.randomUUID();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String toString(){
        return "Usuario = [ ID =  "+ this.id + ", Email = " + this.email + ", Nome = " + this.username  + ", password = " + this.password + "]";
    }

}