package com.startech.skypass.dao;

import com.startech.skypass.AircraftDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "aircraft")
@Builder // PARA CONSTRUIR O OBJETO DA CLASSE
@AllArgsConstructor // CONSTRUTOR CHEIO
@NoArgsConstructor //CONSTRUTOR VAZIO
@Getter // CRIAR OS GET DOS ATRIBUTOS
@Setter // CRIAR OS SET DOS ATRIBUTOS
public class AircraftDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idAirline;//(fk_Airline_Aircraft)
    private String model;
    private String numSerie;
    private String infoSystem;
    private String latitude;
    private String longitude;
    private int numSeats;
    @Column(name = "Eco_Seats")
    private int numEconomicSeats;
    @Column(name = "Exe_Seats")
    private int numExecutiveSeats;
    @Column(name = "FC_Seats")
    private int numFirstClassSeats;
    private double cargoWeight;
    private boolean ativo;

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



    public AircraftDTO toDTO (){
        return AircraftDTO.builder()
                .id(id)
                .idAirline(idAirline)
                .model(model)
                .numSerie(numSerie)
                .infoSystem(infoSystem)
                .latitude(latitude)
                .longitude(longitude)
                .numSeats(calcularSeatsClass(numSeats))
                .numEconomicSeats(numEconomicSeats)
                .numExecutiveSeats(numExecutiveSeats)
                .numFirstClassSeats(numFirstClassSeats)
                .cargoWeight(cargoWeight)
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
