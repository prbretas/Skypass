package com.startech.skypass;

import java.util.Date;

public class Client {

    private String id;
    private String userName;
    private String name;
    private String lastName;
    private String numReg;
    private String phone;
    private String email;
    private String adress ; //fk_ADRESS_CLIENT
    private String birthday;

    private boolean ativo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumReg() {
        return numReg;
    }

    public void setNumReg(String numReg) {
        this.numReg = numReg;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Client(String id, String userName, String name, String lastName, String numReg, String phone, String email, String adress, String birthday) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.numReg = numReg;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.birthday = birthday;
        this.ativo = true;
    }

    public Client(){

    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + getId() + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", numReg='" + getNumReg() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", adress='" + getAdress() + '\'' +
                ", birthday=" + getBirthday() +
                ", ativo=" + getAtivo() +
                '}';
    }
}
