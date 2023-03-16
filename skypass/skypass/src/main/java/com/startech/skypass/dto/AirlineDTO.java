package com.startech.skypass.dto;

import com.startech.skypass.dao.AirlineDAO;
import com.startech.skypass.dao.ClientDAO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirlineDTO {
    private Long id;
    private Long idAdress; // fk_Adress_Airline
    private String companyName;
    private String numReg;
    private String phone;
    private String email;
    private boolean ativo;

    @Override
    public String toString() {
        return "\nAirline{" +
                "\nid='" + getId() +
                "\ncompanyName='" + getCompanyName() +
                "\nnumReg='" + getNumReg() +
                "\nphone='" + getPhone() +
                "\nemail='" + getEmail() +
                "\nativo=" + ativo +
                "\n}";
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
