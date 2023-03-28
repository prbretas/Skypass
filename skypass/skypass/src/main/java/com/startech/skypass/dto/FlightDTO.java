package com.startech.skypass.dto;

import com.startech.skypass.dao.AirportDAO;
import com.startech.skypass.dao.FlightDAO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDTO {

    private Long idFlight;
    private Long idAircraft ;//(fk_Aeronave_flight)
    private AirportDAO idAirportDeparture;
    private AirportDAO idAirportArrival;  //Fk_Airport_Flight
    private String departureTime;
    private String arrivalTime;
    private String date;
    private int numPassengers; // é quantidade de TICKETS TRUE DO FLIGHT
    private boolean ativo;

    @Override
    public String toString() {
        return "\nFlight{" +
                "\nid=" + getIdFlight() +
                "\nidAircraft=" + getIdAircraft() +
                "\ndeparturePlace=" + getIdAirportDeparture()+
                "\narrivalPlace=" + getIdAirportArrival()+
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
                .idFlight(idFlight)
                .idAircraft(idAircraft)
                .idAirportDeparture(idAirportDeparture)
                .idAirportArrival(idAirportArrival)
                .departureTime(departureTime)
                .arrivalTime(arrivalTime)
                .date(date)
                .numPassengers(numPassengers)
                .ativo(ativar())
                .build();
    }



}