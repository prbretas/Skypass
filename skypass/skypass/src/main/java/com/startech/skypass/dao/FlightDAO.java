package com.startech.skypass.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startech.skypass.dto.FlightDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "flight")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idFlight")
public class FlightDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idFlight;
    private Long idAircraft ;//(fk_Aeronave_flight)

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Departure_Airport")
    private AirportDAO idAirportDeparture;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Arrival_Airport")
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


    public FlightDTO toDTO (){
        return FlightDTO.builder()
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

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }




}
