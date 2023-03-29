package com.startech.skypass.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startech.skypass.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idAddress")
public class AddressDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    @Column(name = "street_Avenue") //somente para alterar o nome do atributo na tabela
    private String street;
    private int number;
    private String addInfo;
    private String city;
    private String state;
    private String stateCode;
    private String zipCode;
    private String country;
    private boolean ativo;

    @Override
    public String toString() {
        return "\nAdress{" +
                "\nid=" + getIdAddress() +
                "\nstreet=" + getStreet() +
                "\nnumber=" + getNumber() +
                "\naddInfo=" + getAddInfo() +
                "\ncity=" + getCity() +
                "\nstate=" + getState() +
                "\nstateCode=" + getStateCode() +
                "\ncep=" + getZipCode() +
                "\ncountry=" + getCountry() +
                "\nativo=" + ativo +
                "\n}";
    }
    public AddressDTO toDTO (){
        return AddressDTO.builder()
                .street(street)
                .number(String.valueOf(number))
                .addInfo(addInfo)
                .city(city)
                .state(state)
                .stateCode(stateCode)
                .zipCode(zipCode)
                .country(country)
                .idAddress(idAddress)
                .ativo(ativo)
                .build();
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }




}
