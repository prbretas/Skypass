package com.startech.skypass.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startech.skypass.enums.Category;
import com.startech.skypass.dto.TicketDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idTicket")
public class TicketDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTicket;
    private Long idClient; //(fk_Client_Ticket)
    private Long idFlight; //(fk_Flight_Ticket)
    @Column(nullable = false, unique = true)
    private String idSeat;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "lug_amount")
    private int luggageAmount;
    @Column(name = "lug_wt_KG")
    private double luggageWeight;
    private String date;

    private double ticketPrice;
    private boolean ativo;

    @Override
    public String toString() {
        return "\nTicket{" +
                "\nid=" + getIdTicket() +
                "\nidClient=" + getIdClient() +
                "\nidFlight=" + getIdFlight() +
                "\nidSeat=" + getIdSeat() +
                "\ncategory=" + getCategory() +
                "\namountLuggage=" + getLuggageAmount() +
                "\nweightLuggage=" + getLuggageWeight() + "kg"+
                "\ndate=" + getDate() +
                "\nticketPrice=R$" + getTicketPrice() +
                "\nativo=" + ativo +
                "\n}";
    }
    public TicketDTO toDTO (){
        return TicketDTO.builder()
                .idTicket(idTicket)
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
