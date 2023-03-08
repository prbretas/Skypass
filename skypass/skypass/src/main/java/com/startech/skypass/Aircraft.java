package com.startech.skypass;

import lombok.Builder;
import java.util.Date;

public class Aircraft {
    private String id;

    private String idAirline;//(fk_Airline_Aircraft)
    private String model;
    private String numSerie;
    private String infoSystem;
    private String latitude;
    private String longitude;
    private double altitude;
    private double cargoWeight;
    private double velocity;
    private double fuel;
    private boolean ativo;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(String idAirline) {
        this.idAirline = idAirline;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getNumSerie() {
        return numSerie;
    }
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }
    public String getInfoSystem() {
        return infoSystem;
    }
    public void setInfoSystem(String infoSystem) {
        this.infoSystem = infoSystem;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public double getAltitude() {
        return altitude;
    }
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
    public double getCargoWeight() {
        return cargoWeight;
    }
    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
    public double getVelocity() {
        return velocity;
    }
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    public double getFuel() {
        return fuel;
    }
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public boolean getAtivo() {
        return ativo;
    }

    @Builder
    public Aircraft(String id,
                    String idAirline,
                    String model,
                    String numSerie,
                    String infoSystem,
                    String latitude,
                    String longitude,
                    double altitude,
                    double cargoWeight,
                    double velocity,
                    double fuel) {
        this.id = id;
        this.idAirline = idAirline;
        this.model = model;
        this.numSerie = numSerie;
        this.infoSystem = infoSystem;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.cargoWeight = cargoWeight;
        this.velocity = velocity;
        this.fuel = fuel;
        this.ativo = true;
    }

    @Builder
    public Aircraft() {

    }

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
                "altitude=" + getAltitude() +
                "cargoWeight=" + getCargoWeight() +
                "velocity=" + getVelocity() +
                "fuel=" + getFuel() +
                "ativo=" + getAtivo() +
                '}';
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }
}