package com.startech.skypass;

import com.startech.skypass.dao.AirlineDAO;
import jakarta.validation.constraints.Email;
import lombok.*;

@Builder // PARA CONSTRUIR O OBJETO DA CLASSE
@AllArgsConstructor // CONSTRUTOR CHEIO
@NoArgsConstructor //CONSTRUTOR VAZIO
@Getter // CRIAR OS GET DOS ATRIBUTOS
@Setter // CRIAR OS SET DOS ATRIBUTOS
public class AirlineDTO {

    private Long id;
    private Long idAdress; // fk_Adress_Airline
    private String companyName;
    private String numReg;
    private String phone;
    @Email
    private String email;

    private boolean ativo;

    @Override
    public String toString() {
        return "Airline{" +'\'' +
                "id=" + getId() +
                "id='" + getId() + '\'' +
                "companyName='" + getCompanyName() + '\'' +
                "numReg='" + getNumReg() + '\'' +
                "phone='" + getPhone() + '\'' +
                "email='" + getEmail() + '\'' +
                '}';
    }

    public AirlineDAO toDAO(){
        return AirlineDAO.
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
