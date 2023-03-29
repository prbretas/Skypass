package com.startech.skypass.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startech.skypass.dto.AirlineDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "airline")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idAirline")
public class AirlineDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAirline;
    private String companyName;
    @Column(nullable = false, unique = true)
    private String numReg;
    private String phone;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress")
    private AddressDAO idAddress; // fk_Adress_Airline
    private boolean ativo;

    @Override
    public String toString() {
        return "\nAirline{" +
                "\nid='" + getIdAirline() +
                "\nidAddress=" + getIdAddress() +
                "\ncompanyName='" + getCompanyName() +
                "\nnumReg='" + getNumReg() +
                "\nphone='" + getPhone() +
                "\nemail='" + getEmail() +
                "\nativo=" + ativo +
                "\n}";
    }


    public AirlineDTO toDTO (){
        return AirlineDTO.builder()
                .idAirline(idAirline)
                .idAddress(idAddress)
                .companyName(companyName)
                .numReg(numReg)
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
