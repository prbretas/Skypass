package com.startech.skypass;

public class Adress {
    private String id;
    private String adress;
    private int number;
    private String city;
    private String state;
    private String stateCode;
    private String country;
    private boolean ativo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public Adress(String id, String adress, int number, String city, String state, String stateCode, String country) {
        this.id = id;
        this.adress = adress;
        this.number = number;
        this.city = city;
        this.state = state;
        this.stateCode = stateCode;
        this.country = country;
        this.ativo = true;
    }
    public Adress() {

    }

    @Override
    public String toString() {
        return "Adress{" +'\'' +
                "id=" + getId() + '\'' +
                "adress=" + getAdress() + '\'' +
                "number=" + getNumber() +
                "city=" + getCity() + '\'' +
                "state=" + getState() + '\'' +
                "stateCode=" + getStateCode() + '\'' +
                "country=" + getCountry() + '\'' +
                '}';
    }

    public boolean ativar(){
        return this.ativo = true;
    }

    public boolean inativar(){
        return this.ativo = false;
    }

}
