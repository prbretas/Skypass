package com.startech.skypass.dto;

import com.startech.skypass.dao.AddressDAO;
import com.startech.skypass.dao.AirportDAO;
import jakarta.validation.constraints.Email;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirportDTO {

    private Long idAirport;

    private String name;
    private String iataCode;
    private String phone;
    @Email
    private String email;

    private AddressDAO idAddress; // fk_Endereço_ Airport

    private boolean ativo;



    @Override
    public String toString() {
        return "\nAirport{" +
                "\nid='" + getIdAirport() +
                "\nidAdress='" + getIdAddress() +
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
                .idAirport(idAirport)
                .name(name)
                .iataCode(iataCode)
                .phone(phone)
                .email(email)
                .idAddress(idAddress)
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
