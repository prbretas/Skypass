package com.startech.skypass.repository;

import com.startech.skypass.dao.AddressDAO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends
        JpaRepository<AddressDAO, Long>{

    @Override
    Optional<AddressDAO> findById(Long id);
    Optional<AddressDAO> findByStreet(String street);
    Optional<AddressDAO> findByNumber(String number);
    Optional<AddressDAO> findByAddInfo(String addInfo);
    Optional<AddressDAO> findByCity(String city);
    Optional<AddressDAO> findByState(String state);
    Optional<AddressDAO> findByStateCode(String stateCode);
    Optional<AddressDAO> findByZipCode(String zipCode);
    Optional<AddressDAO> findByCountry(String country);






}
