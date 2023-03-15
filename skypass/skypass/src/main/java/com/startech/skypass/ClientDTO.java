package com.startech.skypass;

import com.startech.skypass.dao.ClientDAO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder // PARA CONSTRUIR O OBJETO DA CLASSE
@AllArgsConstructor // CONSTRUTOR CHEIO
@NoArgsConstructor //CONSTRUTOR VAZIO
@Getter // CRIAR OS GET DOS ATRIBUTOS
@Setter // CRIAR OS SET DOS ATRIBUTOS
public class ClientDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
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
    private String adress ; //fk_ADRESS_CLIENT
    private String birthdate;
    private boolean ativo;

    @Override
    public String toString() { // UTILIZAMOS ESSA FUNÇÃO PARA RETORNAR NO CONSOLE QUANDO OBJ FOR CRIADO
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
                "\nativo=" + ativo +
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
