package com.startech.skypass.repository;

import com.startech.skypass.dao.AirlineDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends
        JpaRepository<AirlineDAO, Long> {
}
