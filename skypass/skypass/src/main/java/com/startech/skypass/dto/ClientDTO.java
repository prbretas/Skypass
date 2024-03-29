package com.startech.skypass.dto;

import com.startech.skypass.dao.AddressDAO;
import com.startech.skypass.dao.ClientDAO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {

    private Long idClient;
    @NotBlank
    private String userName;
    @NotEmpty(message = "Por favor, insira um nome")
    private String name;
    @NotEmpty(message = "Por favor, insira um sobrenome")
    private String lastName;
    private String numReg;
    private String phone;
    @Email
    private String email;
    private String password;
    private String birthdate;
    private AddressDAO idAddress; //fk_ADRESS_CLIENT
    private boolean ativo;

    @Override
    public String toString() { // UTILIZAMOS ESSA FUNÇÃO PARA RETORNAR NO CONSOLE QUANDO OBJ FOR CRIADO
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

    public ClientDAO toDAO(){
        return ClientDAO.
                builder()
                .idClient(idClient)
                .name(name)
                .lastName(lastName)
                .userName(userName)
                .numReg(numReg)
                .phone(phone)
                .email(email)
                .password(password)
                .birthdate(birthdate)
                .idAddress(idAddress)
                .ativo(ativar())
                .build();
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }



}
