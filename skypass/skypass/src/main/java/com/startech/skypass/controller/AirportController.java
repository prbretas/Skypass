package com.startech.skypass.controller;

import com.startech.skypass.dao.AirportDAO;
import com.startech.skypass.dto.AirportDTO;
import com.startech.skypass.repository.AirportRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/airports")
public class AirportController {

    //--------------------------------------- |AIRPORT| -----------------------------------------------------
    @Autowired
    private AirportRepository airportRepository;
    public List<AirportDTO> AirportsList = new ArrayList<AirportDTO>();
    public HashMap<Integer, AirportDTO> airports = new HashMap<Integer, AirportDTO>();

    @PostMapping
    public ResponseEntity<AirportDTO> addAirport(@RequestBody @Valid AirportDTO ap) {
        AirportDAO airportPersisted = airportRepository.save(ap.toDAO());
        String tamanhoLista = String.valueOf(airportRepository.findAll().size());
        System.out.println("\nAeroporto Cadastrado com SUCESSO!" + " - Quantidade de Aeroportos: " + tamanhoLista);
        System.out.println(airportPersisted.toString());
        return new ResponseEntity<AirportDTO>(airportPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable("id") Long id, @RequestBody AirportDTO ap) {
        ap.setId(id);
        AirportDAO airportUpdated = airportRepository.save(ap.toDAO());
        return new ResponseEntity<AirportDTO>(airportUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        return ResponseEntity.ok().body(airportRepository.findAll()
                .stream()
                .map(airportDAO -> airportDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable("id") Long id) {
        Optional<AirportDAO> airport = airportRepository.findById(id);
        if (airport.isPresent()) {
            return new ResponseEntity<AirportDTO>(airport.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<AirportDTO> deleteAirportById(@PathVariable("id") Long id) {
        AirportDAO airport = new AirportDAO();
        airport.setId(id);
        airportRepository.delete(airport);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/ativar")
    public void ativarAirport(Long id) {
        airportRepository.findById(id).ifPresent(airport -> {
            airport.ativar();
            airportRepository.save(airport);
        });
    }

    @PostMapping("/{id}/inativar")
    public void inativarAirport(Long id) {
        airportRepository.findById(id).ifPresent(airport -> {
            airport.inativar();
            airportRepository.save(airport);
        });
    }
}
