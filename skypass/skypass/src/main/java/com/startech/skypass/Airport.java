package com.startech.skypass;

public class Airport {
    private String id;
    private String idAdress; // fk_Endereço_ Airport
    private String name;
    private String iataCode;
    private String phone;
    private String email;

    private boolean ativo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(String idAdress) {
        this.idAdress = idAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public Airport(String id, String idAdress, String name, String iataCode, String phone, String email, boolean ativo) {
        this.id = id;
        this.idAdress = idAdress;
        this.name = name;
        this.iataCode = iataCode;
        this.phone = phone;
        this.email = email;
        this.ativo = true;
    }


    public Airport() {
    }

    @Override
    public String toString() {
        return "\nAirport{" +
                "\nid='" + getId() +
                "\nidAdress='" + getIdAdress() +
                "\nname='" + getName() +
                "\niataCode='" + getIataCode() +
                "\nphone='" + getPhone() +
                "\nemail='" + getEmail() +
                "\nativo=" + getAtivo() +
                "\n}";
    }

    public boolean ativar() {
        return this.ativo = true;
    }

    public boolean inativar() {
        return this.ativo = false;
    }
}
