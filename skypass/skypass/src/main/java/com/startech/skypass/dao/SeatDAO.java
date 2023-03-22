package com.test.skypassTests.dao;

import com.test.skypassTests.dto.SeatDTO;
import com.test.skypassTests.enums.Category;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Seat")
public class SeatDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, unique = true)
    private String seatName;
    private Category category;
    private boolean ativo;

    @Override
    public String toString() {
        return "SeatDTO{" +
                "id=" + getId() +
                ", name='" + getSeatName() + '\'' +
                ", category=" + getCategory() +
                '}';
    }

    public SeatDTO toDTO (){
        return SeatDTO.builder()
                .id(id)
                .SeatName(seatName)
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
