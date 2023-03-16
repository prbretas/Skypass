package com.startech.skypass.dao;

import com.startech.skypass.dto.AirlineDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "airline")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AirlineDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idAdress; // fk_Adress_Airline
    private String companyName;
    private String numReg;
    private String phone;
    private String email;

    private boolean ativo;

    public AirlineDTO toDTO (){
        return AirlineDTO.builder()
                .id(id)
                .idAdress(idAdress)
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
