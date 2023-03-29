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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAirport;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String iataCode;
    private String phone;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress")
    private AddressDAO idAddress; // fk_Endereço_ Airport
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
                .name(name)
                .iataCode(iataCode)
                .phone(phone)
                .email(email)
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
