package com.startech.skypass.dao;

import com.startech.skypass.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "client")
@AllArgsConstructor // CONSTRUCTOR CHEIO
@NoArgsConstructor // CONSTRUCTOR VAZIO
@Builder
@Setter // CRIAR OS SET DOS ATRIBUTOS
@Getter // CRIAR OS GET DOS ATRIBUTOS
public class ClientDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "user_Name") // SOMENTE PARA DAR NOME A COLUNA DA TABELA
    private String userName;
    private String name;
    private String lastName;
    private String numReg;
    private String phone;
    private String email;

    private String password;

    private Long idAdress ;
    private String birthdate;
    private boolean ativo;

    public ClientDTO toDTO (){
        return ClientDTO.builder()
                .id(id)
                .name(name)
                .lastName(lastName)
                .userName(userName)
                .numReg(numReg)
                .phone(phone)
                .email(email)
                .password(password)
                .idAdress(idAdress)
                .birthdate(birthdate)
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