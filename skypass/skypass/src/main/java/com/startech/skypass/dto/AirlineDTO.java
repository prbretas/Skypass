package com.startech.skypass.dto;

import com.startech.skypass.dao.AddressDAO;
import com.startech.skypass.dao.AirlineDAO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirlineDTO {
    private Long idAirline;

    private AddressDAO idAddress; // fk_Adress_Airline
    private String companyName;
    private String numReg;
    private String phone;
    private String email;
    private boolean ativo;

    @Override
    public String toString() {
        return "\nAirline{" +
                "\nid='" + getIdAirline() +
                "\nidAddress=" + getIdAddress() +
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
                .idAirline(idAirline)
                .idAddress(idAddress)
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
