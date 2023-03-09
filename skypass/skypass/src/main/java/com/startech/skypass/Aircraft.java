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
    private int numSeats;
    private int numEconomicSeats;
    private int numExecutiveSeats;
    private int numFirstClassSeats;
    private double altitude;
    private double cargoWeight;
    private double velocity;
    private double fuel;

    private double range;
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

    public int getNumSeats() {
        return numSeats;
    }
    public void setNumSeats(int numSeats) {
        this.numSeats = calcularSeatsClass(numSeats);
    }

    public int getNumEconomicSeats() {
        return numEconomicSeats;
    }
    public int getNumExecutiveSeats() {
        return numExecutiveSeats;
    }
    public int getNumFirstClassSeats() {
        return numFirstClassSeats;
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

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
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
                    int numSeats,
                    double altitude,
                    double cargoWeight,
                    double velocity,
                    double fuel,
                    double range) {
        this.id = id;
        this.idAirline = idAirline;
        this.model = model;
        this.numSerie = numSerie;
        this.infoSystem = infoSystem;
        this.numSeats = numSeats;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.cargoWeight = cargoWeight;
        this.velocity = velocity;
        this.fuel = fuel;
        this.range = range;
        this.ativo = true;
    }

    @Builder
    public Aircraft() {

    }

    @Override
    public String toString() {
        return "\nAircraft{" +
                "\nid=" + getId() +
                "\nidAirline=" + getIdAirline() +
                "\nmodel='" + getModel() +
                "\nnumSerie='" + getNumSerie() +
                "\ninfoSystem='" + getInfoSystem() +
                "\nlatitude='" + getLatitude() +
                "\nlongitude='" + getLongitude() +
                "\nnumSeats=" + getNumSeats() +
                "\naltitude=" + getAltitude() +
                "\ncargoWeight=" + getCargoWeight() +
                "\nvelocity=" + getVelocity() +
                "\nfuel=" + getFuel() +
                "\nrange=" + getRange() +
                "\nativo=" + getAtivo() +
                "\n}";
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }


    public int calcularSeatsClass(int numSeats){
        this.numSeats = numSeats;
        this.numEconomicSeats = (int) (numSeats * 0.7);
        this.numExecutiveSeats = (int) (numSeats * 0.2);
        this.numFirstClassSeats = (int) (numSeats * 0.1);
        return  numSeats;
    }

    public void mostrarSeatsClass(){
        System.out.println("\nA quantidade de poltranas são:"
                + "\n- Economica: " + getNumEconomicSeats()
                + "\n- Executiva: " + getNumExecutiveSeats()
                + "\n- Primeira Classe: " + getNumFirstClassSeats()
                + "\n- Total de Poltronas: " + getNumSeats());
    }

}