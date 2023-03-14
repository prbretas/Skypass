package com.startech.skypass;

import com.startech.skypass.dao.ClientDAO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {

    private Long id;
    @NotBlank
    private String userName;
    @NotEmpty(message = "Por favor, insira um nome")
    private String name;
    @NotEmpty(message = "Por favor, insira um sobrenome")
    private String lastName;
    private String numReg;
    private String phone;
    private String email;
    private String adress ; //fk_ADRESS_CLIENT
    private String birthdate;


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
                "\nadress=" + getAdress() +
                "\nbirthday=" + getBirthdate() +
                "\n}";
    }


    public ClientDAO toDAO(){
        return ClientDAO.
                builder()
                .id(id)
                .name(name)
                .lastName(lastName)
                .userName(userName)
                .numReg(numReg)
                .phone(phone)
                .email(email)
                .adress(adress)
                .birthdate(birthdate)
                .build();
    }

}
