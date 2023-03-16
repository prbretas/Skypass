package com.startech.skypass.dao;

import com.startech.skypass.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
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

    @Override
    public String toString() {
        return "\nClient{" +
                "\nid=" + getId() +
                "\nuserName=" + getUserName() +
                "\nname=" + getName() +
                "\nlastName=" + getLastName() +
                "\nnumReg=" + getNumReg() +
                "\nphone=" + getPhone() +
                "\nemail=" + getEmail() +
                "\npassword=" + getPassword() +
                "\nidAdress=" + getIdAdress() +
                "\nbirthday=" + getBirthdate() +
                "\nativo=" + ativo +
                "\n}";
    }

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