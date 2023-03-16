package com.startech.skypass.dao;

import com.startech.skypass.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "address")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class AddressDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "street")
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
                "\nid=" + getId() +
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
                .id(id)
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
