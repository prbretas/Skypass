package com.startech.skypass.controller;

import com.startech.skypass.dao.FlightDAO;
import com.startech.skypass.dto.FlightDTO;
import com.startech.skypass.repository.FlightRepository;
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
public class FlightController {

    //--------------------------------------|FLIGHT|------------------------------------------------------

    @Autowired
    private FlightRepository flightRepository;
    public List<FlightDTO> FlightsList = new ArrayList<FlightDTO>();
    public HashMap<Integer, FlightDTO> flights = new HashMap<Integer, FlightDTO>();

    @PostMapping("/flights")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody @Valid FlightDTO ft) {
        FlightDAO flightPersisted = flightRepository.save(ft.toDAO());
        String tamanhoLista = String.valueOf(flightRepository.findAll().size());
        System.out.println("\nVôo cadastrado com SUCESSO!" + " - Quantidade de Vôo: " + tamanhoLista);
        System.out.println(flightPersisted.toString());
        return new ResponseEntity<FlightDTO>(flightPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/flights/{id}/update")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable("id") Long id, @RequestBody FlightDTO ft) {
        ft.setId(id);
        FlightDAO flightUpdated = flightRepository.save(ft.toDAO());
        return new ResponseEntity<FlightDTO>(flightUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/flights")
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        return ResponseEntity.ok().body(flightRepository.findAll()
                .stream()
                .map(flightDAO -> flightDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable("id") Long id) {
        Optional<FlightDAO> flight = flightRepository.findById(id);
        if (flight.isPresent()) {
            return new ResponseEntity<FlightDTO>(flight.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/flights/{id}/delete")
    public ResponseEntity<FlightDTO> deleteFlightById(@PathVariable("id") Long id) {
        FlightDAO flight = new FlightDAO();
        flight.setId(id);
        flightRepository.delete(flight);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/flights/{id}/ativar")
    public void ativar(Long id) {
        flightRepository.findById(id).ifPresent(flight -> {
            flight.ativar();
            flightRepository.save(flight);
        });
    }

    @PostMapping("/flights/{id}/inativar")
    public void inativar(Long id) {
        flightRepository.findById(id).ifPresent(flight -> {
            flight.inativar();
            flightRepository.save(flight);
        });
    }


}