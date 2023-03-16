package com.startech.skypass.repository;

import com.startech.skypass.dao.AddressDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends
        JpaRepository<AddressDAO, Long>{
}
