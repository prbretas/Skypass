package com.startech.skypass.repository;

import com.startech.skypass.dao.AircraftDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends
        JpaRepository<AircraftDAO, Long> {
}
