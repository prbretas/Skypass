package com.startech.skypass.dao;


import com.startech.skypass.dto.SeatDTO;
import com.startech.skypass.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @Enumerated(EnumType.STRING)
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
                .seatName(seatName)
                .category(category)
                .ativo(ativo)
                .build();
    }
    public boolean ativar() {
        return this.ativo = true;
    }
    public boolean inativar() {
        return this.ativo = false;
    }
}
