package com.startech.skypass.repository;

import com.startech.skypass.dao.FlightDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends
        JpaRepository<FlightDAO, Long> {
}
