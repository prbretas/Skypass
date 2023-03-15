package com.startech.skypass.dao;

import com.startech.skypass.Category;
import com.startech.skypass.TicketDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class TicketDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String idClient; //(fk_Client_Ticket)
    private String idFlight; //(fk_Flight_Ticket)
    private String idSeat;
    private Category category; //( ECONOMICA/ EXECUTIVA/ PRIMEIRA_CLASSE)
    private int amountLuggage;
    private double weightLuggage;
    private String date;
    private double ticketPrice;
    private boolean ativo;


    public TicketDTO toDTO (){
        return TicketDTO.builder()
                .id(id)
                .idClient(idClient)
                .idFlight(idFlight)
                .idSeat(idSeat)
                .category(category)
                .amountLuggage(amountLuggage)
                .weightLuggage(weightLuggage)
                .date(date)
                .ticketPrice(ticketPrice)
                .ativo(ativar())
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
