package br.estudo.JUnit.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

public class MetaInfoAtivo{
    @JsonProperty("1. Information")
    private String informacao;

    @JsonProperty("2. Symbol")
    private String simbolo;

    @JsonProperty("3. Last Refreshed")
    private String ultimaAtualizacao;

    @JsonProperty("4. Output Size")
    private String saidaTamanho;

    @JsonProperty("5. Time Zone")
    private String timeZone;

    public String getInformacao() {
        return this.informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getUltimaAtualizacao() {
        return this.ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getSaidaTamanho() {
        return this.saidaTamanho;
    }

    public void setSaidaTamanho(String saidaTamanho) {
        this.saidaTamanho = saidaTamanho;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}