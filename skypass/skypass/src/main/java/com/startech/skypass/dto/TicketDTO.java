package com.startech.skypass.dto;

import com.startech.skypass.enums.Category;
import com.startech.skypass.dao.TicketDAO;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDTO {

    private Long idTicket;
    private Category category; //( ECONOMICA/ EXECUTIVA/ PRIMEIRA_CLASSE)
    private int luggageAmount;
    private double luggageWeight;
    private String date;
    private double ticketPrice;

    private Long idClient; //(fk_Client_Ticket)
    private Long idFlight; //(fk_Flight_Ticket)
    private String idSeat; // (fk_Seat_Ticket)
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

    public TicketDAO toDAO(){
        return TicketDAO.
                builder()
                .idTicket(idTicket)
                .category(category)
                .luggageAmount(luggageAmount)
                .luggageWeight(luggageWeight)
                .date(date)
                .ticketPrice(ticketPrice)
                .idClient(idClient)
                .idFlight(idFlight)
                .idSeat(idSeat)
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
