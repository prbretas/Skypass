package com.startech.skypass.dao;

import com.startech.skypass.FlightDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "flight")
@AllArgsConstructor // CONSTRUCTOR CHEIO
@NoArgsConstructor // CONSTRUCTOR VAZIO
@Builder
@Setter // CRIAR OS SET DOS ATRIBUTOS
@Getter // CRIAR OS GET DOS ATRIBUTOS

public class FlightDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idAircraft ;//(fk_Aeronave_flight)
    private Long idAirline ; //(fk_Airline_Flight)
    private String location;
    private String departureTime;
    private String arrivalTime;
    private int volumePassengers;
    private boolean ativo;

    public FlightDTO toDTO(){
        return FlightDTO.
                builder()
                .id(id)
                .idAircraft(idAircraft)
                .idAirline(idAirline)
                .location(location)
                .departureTime(departureTime)
                .arrivalTime(arrivalTime)
                .volumePassengers(volumePassengers)
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
