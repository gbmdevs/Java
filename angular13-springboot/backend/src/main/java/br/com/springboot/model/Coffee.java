package br.com.springboot.model;


public class Coffee {
    private String brand;
    private String origin;
    private String characteristics;

    public Coffee(String brand, String origin, String characteristics){
        this.brand           = brand;
        this.origin          = origin;
        this.characteristics = characteristics;  
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCharacteristics() {
        return this.characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

}