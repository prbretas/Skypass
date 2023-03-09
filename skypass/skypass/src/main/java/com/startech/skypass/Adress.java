package com.startech.skypass;

public class Adress {
     private String id;
    private String street;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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


    public Adress(String id, String street, int number, String city, String state, String stateCode, String country) {
        this.id = id;
        this.street = street;
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
        return "\nAdress{" +
                "\nid=" + getId() +
                "\nadress=" + getStreet() +
                "\nnumber=" + getNumber() +
                "\ncity=" + getCity() +
                "\nstate=" + getState() +
                "\nstateCode=" + getStateCode() +
                "\ncountry=" + getCountry() +
                "\n}";
    }

    public boolean ativar(){
        return this.ativo = true;
    }

    public boolean inativar(){
        return this.ativo = false;
    }

    public void getFullAdress(){
        System.out.println("\nO endereço completo é:"
                + "\n- Rua: " + getStreet()
                + "\n- Número: " + getNumber()
                + "\n- Cidade: " + getCity()
                + "\n- Estado: " + getState()
                + "\n- UF: " + getStateCode()
                + "\n- País: " + getCountry());
    }

}
