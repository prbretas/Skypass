package com.startech.skypass.dao;

import com.startech.skypass.AirportDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "airport")
@Builder // PARA CONSTRUIR O OBJETO DA CLASSE
@AllArgsConstructor // CONSTRUTOR CHEIO
@NoArgsConstructor //CONSTRUTOR VAZIO
@Getter // CRIAR OS GET DOS ATRIBUTOS
@Setter // CRIAR OS SET DOS ATRIBUTOS
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

    public AirportDTO toDTO(){
        return AirportDTO.
                builder()
                .id(id)
                .idAdress(idAdress)
                .name(name)
                .iataCode(iataCode)
                .phone(phone)
                .email(email)
                .ativo(ativar())
                .build();
    }

    public boolean ativar() {
        return this.ativo = true;
    }

    public boolean inativar() {
        return this.ativo = false;
    }
}
