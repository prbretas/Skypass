package com.startech.skypass;

public class Airline {
    private String id;
    private String idAdress; // fk_Adress_Airline
    private String companyName;
    private String numReg;
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

       public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public boolean getAtivo() {
        return ativo;
    }

    public Airline(String id, String idAdress, String companyName, String numReg, String phone,
                   String email) {
        this.id = id;
        this.idAdress = idAdress;
        this.companyName = companyName;
        this.numReg = numReg;
        this.phone = phone;
        this.email = email;
        this.ativo = true;
    }

    public Airline() {
    }

    ;

    @Override
    public String toString() {
        return "Airline{" +'\'' +
                "id='" + getId() + '\'' +
                "companyName='" + getCompanyName() + '\'' +
                "numReg='" + getNumReg() + '\'' +
                "phone='" + getPhone() + '\'' +
                "email='" + getEmail() + '\'' +
                "ativo=" + getAtivo() +
                '}';
    }

    public boolean ativar() {
        return this.ativo = true;
    }

    public boolean inativar() {
        return this.ativo = false;
    }
}
