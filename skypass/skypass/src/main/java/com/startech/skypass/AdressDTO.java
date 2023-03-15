package com.startech.skypass;

import com.startech.skypass.dao.AdressDAO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdressDTO {
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
                "\n}";
    }

    public void getFullAdress(){
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


    public AdressDAO toDAO(){
        return AdressDAO.
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
                .build();
    }


}
