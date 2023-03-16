package com.startech.skypass.dao;

import com.startech.skypass.dto.FlightDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "flight")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class FlightDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idAircraft ;//(fk_Aeronave_flight)
    private Long idAirline ; //(fk_Airline_Flight)
    private Long departurePlace; //Fk_Airport_Flight
    private Long arrivalPlace;  //Fk_Airport_Flight
    private String departureTime;
    private String arrivalTime;
    private String date;
    private int numPassengers; // é quantidade de TICKETS TRUE DO FLIGHT
    private boolean ativo;

    @Override
    public String toString() {
        return "\nFlight{" +
                "\nid=" + getId() +
                "\nidAircraft=" + getIdAircraft() +
                "\nidAirline=" + getIdAirline() +
                "\ndeparturePlace=" + getDeparturePlace()+
                "\narrivalPlace=" + getArrivalPlace()+
                "\ndepartureTime=" + getDepartureTime() +
                "\narrivalTime=" + getArrivalTime() +
                "\ndate=" + getDate() +
                "\nvolumePassengers=" + getNumPassengers() +
                "\nativo=" + ativo +
                "\n}";
    }


    public FlightDTO toDTO (){
        return FlightDTO.builder()
                .id(id)
                .idAircraft(idAircraft)
                .idAirline(idAirline)
                .departurePlace(departurePlace)
                .arrivalPlace(arrivalPlace)
                .departureTime(departureTime)
                .arrivalTime(arrivalTime)
                .date(date)
                .numPassengers(numPassengers)
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
