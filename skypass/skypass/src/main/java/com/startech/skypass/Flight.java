package com.startech.skypass;

import lombok.Builder;
import java.util.Date;

public class Flight {

    private String id;
    private String idAircraft ;//(fk_Aeronave_flight)
    private String idAirline ; //(fk_Airline_Flight)

    private String location;
    private String departureTime;
    private String arrivalTime;
    private int volumePassengers; // quantidade de assentos true do aviao
    private boolean ativo;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIdAircraft() {
        return idAircraft;
    }

    public void setIdAircraft(String idAircraft) {
        this.idAircraft = idAircraft;
    }

    public String getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(String idAirline) {
        this.idAirline = idAirline;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getVolumePassengers() {
        return volumePassengers;
    }
    public void setVolumePassengers(int volumePassengers) {
        this.volumePassengers = volumePassengers;
    }

    public boolean getAtivo() {
        return ativo;
    }

    @Builder
    public Flight(String id, String idAirline, String idAircraft, String location, String departureTime, String arrivalTime, int volumePassengers) {
        this.id = id;
        this.idAirline =idAirline;
        this.idAircraft = idAircraft;
        this.location = location;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.volumePassengers = volumePassengers;
        this.ativo = true;
    }

    @Builder
    public Flight() {

    }

    @Override
    public String toString() {
        return "\nFlight{" +
                "\nid=" + getId() +
                "\nlocation=" + getLocation() +
                "\ndepartureTime=" + getDepartureTime() +
                "\narrivalTime=" + getArrivalTime() +
                "\nvolumePassengers=" + getVolumePassengers() +
                "\n}";
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }

}