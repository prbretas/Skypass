package com.startech.skypass;

import com.startech.skypass.dao.TicketDAO;
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


    @Override
    public String toString() {
        return "\nTicket{" +
                "\nid=" + getId() +
                "\nidClient=" + getIdClient() +
                "\nidFlight=" + getIdFlight() +
                "\nidSeat=" + getIdSeat() +
                "\ncategory=" + getCategory() +
                "\namountLuggage=" + getAmountLuggage() +
                "\nweightLuggage=" + getWeightLuggage() + "kg"+
                "\ndate=" + getDate() +
                "\nticketPrice=R$" + getTicketPrice() +
                "\nativo=" + ativo +
                "\n}";
    }

    public TicketDAO toDAO(){
        return TicketDAO.
                builder()
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
                .build();
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }
}
