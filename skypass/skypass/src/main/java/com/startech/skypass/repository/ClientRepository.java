package com.startech.skypass.repository;


import com.startech.skypass.dao.ClientDAO;
import com.startech.skypass.dto.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ClientRepository extends
        JpaRepository<ClientDAO, Long> {

}
