package com.test.skypassTests.dto;


import com.test.skypassTests.dao.SeatDAO;
import com.test.skypassTests.enums.Category;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeatDTO {

    private Long id;
    private String SeatName;
    private Category category;
    private boolean ativo;


    @Override
    public String toString() {
        return "Seat{" +
                "\nid=" + id +
                "\n, name='" + SeatName + '\'' +
                "\n, category=" + category +
                "\n, ativo=" + ativo +
                '}';
    }

    public SeatDAO toDAO (){
        return SeatDAO.builder()
                .id(id)
                .seatName(SeatName)
                .category(category)
                .build();
    }

    public boolean ativar() {
        return this.ativo = true;
    }
    public boolean inativar() {
        return this.ativo = false;
    }

}
