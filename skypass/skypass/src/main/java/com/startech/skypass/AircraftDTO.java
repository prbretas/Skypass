package com.startech.skypass;

import com.startech.skypass.dao.AircraftDAO;
import lombok.*;

@Builder // PARA CONSTRUIR O OBJETO DA CLASSE
@AllArgsConstructor // CONSTRUTOR CHEIO
@NoArgsConstructor //CONSTRUTOR VAZIO
@Getter // CRIAR OS GET DOS ATRIBUTOS
@Setter // CRIAR OS SET DOS ATRIBUTOS
public class AircraftDTO {

    private Long id;
    private Long idAirline;//(fk_Airline_Aircraft)
    private String model;
    private String numSerie;
    private String infoSystem;
    private String latitude;
    private String longitude;
    private int numSeats;
    private int numEconomicSeats;
    private int numExecutiveSeats;
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
                "\nnumEconomicSeats=" + getNumEconomicSeats() +
                "\nnumExecutiveSeats=" + getNumExecutiveSeats() +
                "\nnumFirstClassSeats=" + getNumFirstClassSeats() +
                "\ncargoWeight=" + getCargoWeight() +
                "\nativo=" + ativo +
                "\n}";
    }

    public AircraftDAO toDAO(){
        return AircraftDAO.
                builder()
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
