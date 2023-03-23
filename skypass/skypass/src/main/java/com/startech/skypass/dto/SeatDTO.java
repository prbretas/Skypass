package com.startech.skypass.dto;

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

    private Long id;
    private String seatName;
    private Category category;
    private boolean ativo;


    @Override
    public String toString() {
        return "Seat{" +
                "\nid=" + id +
                "\n, name='" + seatName + '\'' +
                "\n, category=" + category +
                "\n, ativo=" + ativo +
                '}';
    }

    public SeatDAO toDAO (){
        return SeatDAO.builder()
                .id(id)
                .seatName(seatName)
                .category(category)
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
