package com.startech.skypass.repository;

import com.startech.skypass.dao.AirportDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends
        JpaRepository<AirportDAO, Long> {
}
