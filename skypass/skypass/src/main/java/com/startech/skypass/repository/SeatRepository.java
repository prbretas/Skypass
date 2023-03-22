package com.test.skypassTests.repository;

import com.test.skypassTests.dao.SeatDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends
        JpaRepository<SeatDAO, Long> {
}
