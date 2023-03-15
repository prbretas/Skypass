package com.startech.skypass.repository;

import com.startech.skypass.dao.AdressDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends
        JpaRepository<AdressDAO, Long>{
}
