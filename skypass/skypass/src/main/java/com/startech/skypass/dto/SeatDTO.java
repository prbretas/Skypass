package com.startech.skypass.dto;

import com.startech.skypass.dao.AircraftDAO;
import com.startech.skypass.dao.SeatDAO;
import com.startech.skypass.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeatDTO {

    private Long idSeat;
    private String seatName;
    private Category category;
    private AircraftDAO idAircraft;
    private boolean ativo;


    @Override
    public String toString() {
        return "Seat{" +
                "\nid=" + getIdSeat() +
                "\n, name='" + getSeatName() +
                "\n, category=" + getCategory() +
                "\n, aircraft=" + getIdAircraft() +
                "\n, ativo=" + ativo +
                '}';
    }

    public SeatDAO toDAO (){
        return SeatDAO.builder()
                .idSeat(idSeat)
                .seatName(seatName)
                .category(category)
                .idAircraft(idAircraft)
                .ativo(ativar())
                .build();
    }

    public boolean ativar() {
        return this.ativo = true;
    }
    public boolean inativar() {
        return this.ativo = false;
    }

}
