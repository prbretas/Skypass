package com.startech.skypass;

import com.startech.skypass.dao.AirportDAO;
import lombok.*;

@Builder // PARA CONSTRUIR O OBJETO DA CLASSE
@AllArgsConstructor // CONSTRUTOR CHEIO
@NoArgsConstructor //CONSTRUTOR VAZIO
@Getter // CRIAR OS GET DOS ATRIBUTOS
@Setter // CRIAR OS SET DOS ATRIBUTOS
public class AirportDTO {
    private Long id;
    private Long idAdress; // fk_Endereço_ Airport
    private String name;
    private String iataCode;
    private String phone;
    private String email;
    private boolean ativo;

    @Override
    public String toString() {
        return "Airport{" + '\'' +
                "id='" + getId() + '\'' +
                "idAdress='" + getIdAdress() + '\'' +
                "name='" + getName() + '\'' +
                "iataCode='" + getIataCode() + '\'' +
                "phone='" + getPhone() + '\'' +
                "email='" + getEmail() + '\'' +
                '}';
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
