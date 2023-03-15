package com.startech.skypass.repository;

import com.startech.skypass.dao.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends
        JpaRepository<ClientDAO, Long> {

}
