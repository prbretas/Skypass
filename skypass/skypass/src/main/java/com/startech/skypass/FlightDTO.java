package com.startech.skypass;

import com.startech.skypass.dao.FlightDAO;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class FlightDTO {

    private Long id;
    private Long idAircraft ;//(fk_Aeronave_flight)
    private Long idAirline ; //(fk_Airline_Flight)
    private String location;
    private String departureTime;
    private String arrivalTime;
    private int volumePassengers;
    private boolean ativo;

    @Override
    public String toString() {
        return "Flight{" +'\'' +
                "id=" + getId() + '\'' +
                "location=" + getLocation() + '\'' +
                "departureTime=" + getDepartureTime() + '\'' +
                "arrivalTime=" + getArrivalTime() + '\'' +
                "volumePassengers=" + getVolumePassengers() +
                '}';
    }

    public FlightDAO toDAO(){
        return FlightDAO.
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

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }

}