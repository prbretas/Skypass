package com.startech.skypass;

import com.startech.skypass.dao.AircraftDAO;
import lombok.*;

@Builder // PARA CONSTRUIR O OBJETO DA CLASSE
@AllArgsConstructor // CONSTRUTOR CHEIO
@NoArgsConstructor //CONSTRUTOR VAZIO
@Getter // CRIAR OS GET DOS ATRIBUTOS
@Setter // CRIAR OS SET DOS ATRIBUTOS
public class AircraftDTO {

    private Long id;
    private Long idAirline;//(fk_Airline_Aircraft)
    private String model;
    private String numSerie;
    private String infoSystem;
    private String latitude;
    private String longitude;
    private double cargoWeight;
    private boolean ativo;


    @Override
    public String toString() {
        return "Aircraft{" + '\'' +
                "id=" + getId() + '\'' +
                "idAirline=" + getIdAirline() + '\'' +
                "model='" + getModel() + '\'' +
                "numSerie='" + getNumSerie() + '\'' +
                "infoSystem='" + getInfoSystem() + '\'' +
                "latitude='" + getLatitude() + '\'' +
                "longitude='" + getLongitude() + '\'' +
                "cargoWeight=" + getCargoWeight() +
                '}';
    }

    public AircraftDAO toDAO(){
        return AircraftDAO.
                builder()
                .id(id)
                .idAirline(idAirline)
                .model(model)
                .numSerie(numSerie)
                .infoSystem(infoSystem)
                .latitude(latitude)
                .longitude(longitude)
                .cargoWeight(cargoWeight)
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