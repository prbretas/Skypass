package com.startech.skypass.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startech.skypass.dto.AircraftDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "aircraft")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idAircraft")
public class AircraftDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAircraft;
    private String model;
    @Column(nullable = false, unique = true)
    private String numSerie;
    private String infoSystem;
    private String latitude;
    private String longitude;

    private double cargoWeight;

    private Long idAirline;//(fk_Airline_Aircraft)
    @OneToMany(mappedBy = "idAircraft", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SeatDAO> seats;


    private boolean ativo;

    @Override
    public String toString() {
        return "\nAircraft{" +
                "\nid=" + getIdAircraft() +
                "\nmodel='" + getModel() +
                "\nnumSerie='" + getNumSerie() +
                "\ninfoSystem='" + getInfoSystem() +
                "\nlatitude='" + getLatitude() +
                "\nlongitude='" + getLongitude() +
                "\ncargoWeight=" + getCargoWeight() +
                "\nidAirline=" + getIdAirline() +
                "\nseats='" + getSeats() +
                "\nativo=" + ativo +
                "\n}";
    }

    /*public int calcularSeatsClass(int numSeats){
        this.numSeats = numSeats;
        this.numEconomicSeats = (int) (numSeats * 0.7);
        this.numExecutiveSeats = (int) (numSeats * 0.2);
        this.numFirstClassSeats = (int) (numSeats * 0.1);
        int soma = numEconomicSeats+ numExecutiveSeats+numFirstClassSeats;

        if(soma>numSeats)
            numEconomicSeats-=1;
        else if(soma<numSeats)
            numEconomicSeats+=1;
        return  numSeats;
    }

    public void mostrarSeatsClass(){
        System.out.println("\nA quantidade de poltranas são:"
                + "\n- Economica: " + getNumEconomicSeats()
                + "\n- Executiva: " + getNumExecutiveSeats()
                + "\n- Primeira Classe: " + getNumFirstClassSeats()
                + "\n- Total de Poltronas: " + getNumSeats());
    }
*/


    public AircraftDTO toDTO (){
        return AircraftDTO.builder()
                .idAircraft(idAircraft)
                .model(model)
                .numSerie(numSerie)
                .infoSystem(infoSystem)
                .latitude(latitude)
                .longitude(longitude)
                .cargoWeight(cargoWeight)
                .idAirline(idAirline)
                .seats(seats)
                .ativo(ativo)
                .build();
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }



}
