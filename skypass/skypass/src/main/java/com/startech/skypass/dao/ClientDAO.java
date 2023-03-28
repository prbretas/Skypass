package com.startech.skypass.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startech.skypass.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idClient")
public class ClientDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;
    //@Column(name = "user_Name") // SOMENTE PARA DAR NOME A COLUNA DA TABELA
    @Column(nullable = false, unique = true)
    private String userName;
    private String name;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String numReg;
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress")
    private AddressDAO idAddress;
    private String birthdate;
    private boolean ativo;

    @Override
    public String toString() {
        return "\nClient{" +
                "\nid=" + getIdClient() +
                "\nuserName=" + getUserName() +
                "\nname=" + getName() +
                "\nlastName=" + getLastName() +
                "\nnumReg=" + getNumReg() +
                "\nphone=" + getPhone() +
                "\nemail=" + getEmail() +
                "\npassword=" + getPassword() +
                "\nidAddress=" + getIdAddress() +
                "\nbirthday=" + getBirthdate() +
                "\nativo=" + ativo +
                "\n}";
    }

    public ClientDTO toDTO (){
        return ClientDTO.builder()
                .idClient(idClient)
                .name(name)
                .lastName(lastName)
                .userName(userName)
                .numReg(numReg)
                .phone(phone)
                .email(email)
                .password(password)
                .idAddress(idAddress)
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