package com.startech.skypass.dto;


import com.startech.skypass.dao.AddressDAO;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {

    private Long id;
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    private String addInfo;
    private String city;
    private String state;
    private String stateCode;
    @NotEmpty(message = "Por favor, insira um CEP")
    private String zipCode;
    private String country;


    @OneToOne(mappedBy = "address")
    private ClientDTO clientDTO;
    private boolean ativo;


    @Override
    public String toString() {
        return "\nAdress{" +
                "\nid=" + getId() +
                "\nstreet=" + getStreet() +
                "\nnumber=" + getNumber() +
                "\naddInfo=" + getAddInfo() +
                "\ncity=" + getCity() +
                "\nstate=" + getState() +
                "\nstateCode=" + getStateCode() +
                "\ncep=" + getZipCode() +
                "\ncountry=" + getCountry() +
                "\nativo=" + ativo +
                "\n}";
    }

    public void getFullAddress(){
        System.out.println("\nO endereço completo é:"
                + "\n- Logradouro: " + getStreet()
                + " Nº" + getNumber()
                + " - " + getAddInfo()
                + ", " + getCity()
                + ", " + getState()
                + "-" + getStateCode()
                + ", " + getZipCode()
                + ", " + getCountry());
    }


    public AddressDAO toDAO(){
        return AddressDAO.
                builder()
                .id(id)
                .street(street)
                .number(Integer.parseInt(number))
                .addInfo(addInfo)
                .city(city)
                .state(state)
                .stateCode(stateCode)
                .zipCode(zipCode)
                .country(country)
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
