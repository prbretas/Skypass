package com.startech.skypass.dao;

import com.startech.skypass.AirlineDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "airline")
@Builder // PARA CONSTRUIR O OBJETO DA CLASSE
@AllArgsConstructor // CONSTRUTOR CHEIO
@NoArgsConstructor //CONSTRUTOR VAZIO
@Getter // CRIAR OS GET DOS ATRIBUTOS
@Setter // CRIAR OS SET DOS ATRIBUTOS
public class AirlineDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idAdress; // fk_Adress_Airline
    @Column(name = "company_Name")
    private String companyName;
    private String numReg;
    private String phone;
    private String email;
    private boolean ativo;

    public AirlineDTO toDTO(){
        return AirlineDTO.
                builder()
                .id(id)
                .idAdress(idAdress)
                .companyName(companyName)
                .numReg(numReg)
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
