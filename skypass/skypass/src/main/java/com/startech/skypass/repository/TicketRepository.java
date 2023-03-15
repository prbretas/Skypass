package com.startech.skypass.repository;

import com.startech.skypass.dao.TicketDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends
        JpaRepository<TicketDAO, Long> {
}
