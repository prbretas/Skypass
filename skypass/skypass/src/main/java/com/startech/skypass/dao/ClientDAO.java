package com.startech.skypass.dao;

import com.startech.skypass.ClientDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "client")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ClientDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "client_userName")
    private String userName;
    private String name;
    private String lastName;
    private String numReg;
    private String phone;
    private String email;
    private String adress ;
    private String birthdate;

    public ClientDTO toDTO (){
        return ClientDTO.builder()
                .name(name)
                .lastName(lastName)
                .userName(userName)
                .numReg(numReg)
                .phone(phone)
                .email(email)
                .adress(adress)
                .birthdate(birthdate)
                .id(id)
                .build();
    }
}