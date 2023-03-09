package com.startech.skypass;

public class Adress {
     private String id;
    private String street;
    private int number;

    private String addInfo;
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

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
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


    public Adress(String id, String street, int number, String addInfo, String city, String state, String stateCode, String country) {
        this.id = id;
        this.street = street;
        this.addInfo = addInfo;
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
                "\nstreet=" + getStreet() +
                "\nnumber=" + getNumber() +
                "\naddInfo=" + getAddInfo() +
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
                + "\n- Logradouro: " + getStreet()
                + " Nº" + getNumber()
                + " - " + getAddInfo()
                + ", " + getCity()
                + ", " + getState()
                + "-" + getStateCode()
                + ", " + getCountry());
    }

}
