package com.startech.skypass.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startech.skypass.dto.AirportDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "airport")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idAirport")
public class AirportDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAirport;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress")
    private AddressDAO idAddress; // fk_Endereço_ Airport
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String iataCode;
    private String phone;
    private String email;
    private boolean ativo;

    @Override
    public String toString() {
        return "\nAirport{" +
                "\nid='" + getIdAirport() +
                "\nidAddress='" + getIdAddress() +
                "\nname='" + getName() +
                "\niataCode='" + getIataCode() +
                "\nphone='" + getPhone() +
                "\nemail='" + getEmail() +
                "\nativo=" + ativo +
                "\n}";
    }


    public AirportDTO toDTO (){
        return AirportDTO.builder()
                .idAirport(idAirport)
                .idAddress(idAddress)
                .name(name)
                .iataCode(iataCode)
                .phone(phone)
                .email(email)
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
