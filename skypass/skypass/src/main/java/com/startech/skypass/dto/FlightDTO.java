package com.startech.skypass.dto;

import com.startech.skypass.dao.FlightDAO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDTO {

    private Long id;
    private Long idAircraft ;//(fk_Aeronave_flight)
    private Long idAirline ; //(fk_Airline_Flight)
    private Long departurePlace; //Fk_Airport_Flight
    private Long arrivalPlace;  //Fk_Airport_Flight
    private String departureTime;
    private String arrivalTime;
    private String date;
    private int numPassengers; // quantidade de assentos true do aviao
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

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }


    public FlightDAO toDAO(){
        return FlightDAO.
                builder()
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



}