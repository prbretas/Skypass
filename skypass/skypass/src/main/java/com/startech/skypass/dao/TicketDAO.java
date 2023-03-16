package com.startech.skypass.dao;

import com.startech.skypass.enums.Category;
import com.startech.skypass.dto.TicketDTO;
import jakarta.persistence.*;
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
    private Long idClient; //(fk_Client_Ticket)
    private Long idFlight; //(fk_Flight_Ticket)
    private String idSeat;

    private Category category; //( ECONOMICA/ EXECUTIVA/ PRIMEIRA_CLASSE)

    @Column(name = "lug_amount")
    private int luggageAmount;
    @Column(name = "lug_wt_KG")
    private double luggageWeight;
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
                .luggageAmount(luggageAmount)
                .luggageWeight(luggageWeight)
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
