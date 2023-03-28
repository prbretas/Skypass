package com.startech.skypass.dao;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.startech.skypass.dto.SeatDTO;
import com.startech.skypass.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Seat")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idSeat")
public class SeatDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idSeat;
    @Column(nullable = false, unique = true)
    private String seatName;
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "idAircraft")
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

    public SeatDTO toDTO (){
        return SeatDTO.builder()
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
