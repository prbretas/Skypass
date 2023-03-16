package com.startech.skypass.dao;

import com.startech.skypass.dto.AirportDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "airport")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AirportDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idAdress; // fk_Endereço_ Airport
    private String name;
    private String iataCode;
    private String phone;
    private String email;
    private boolean ativo;

    public AirportDTO toDTO (){
        return AirportDTO.builder()
                .id(id)
                .idAdress(idAdress)
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
