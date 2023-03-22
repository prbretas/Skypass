package com.startech.skypass.repository;


import com.startech.skypass.dao.SeatDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends
        JpaRepository<SeatDAO, Long> {
}
