package com.startech.skypass.dao;

import com.startech.skypass.AdressDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "adress")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class AdressDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "street")
    private String street;

    private int number;
    private String addInfo;
    private String city;
    private String state;
    private String stateCode;
    private String zipCode;
    private String country;



    public AdressDTO toDTO (){
        return AdressDTO.builder()
                .street(street)
                .number(String.valueOf(number))
                .addInfo(addInfo)
                .city(city)
                .state(state)
                .stateCode(stateCode)
                .zipCode(zipCode)
                .country(country)
                .id(id)
                .build();
    }
}
