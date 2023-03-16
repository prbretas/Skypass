package com.startech.skypass.dto;

import com.startech.skypass.dao.AirportDAO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirportDTO {

    private Long id;
    private Long idAdress; // fk_Endereço_ Airport
    private String name;
    private String iataCode;
    private String phone;
    @Email
    private String email;
    private boolean ativo;


    @Override
    public String toString() {
        return "\nAirport{" +
                "\nid='" + getId() +
                "\nidAdress='" + getIdAdress() +
                "\nname='" + getName() +
                "\niataCode='" + getIataCode() +
                "\nphone='" + getPhone() +
                "\nemail='" + getEmail() +
                "\nativo=" + ativo +
                "\n}";
    }

    public AirportDAO toDAO(){
        return AirportDAO.
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
