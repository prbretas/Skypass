package com.startech.skypass.controller;

import com.startech.skypass.dao.AircraftDAO;
import com.startech.skypass.dto.AircraftDTO;
import com.startech.skypass.repository.AircraftRepository;
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
public class AircraftController {
    @Autowired
    private AircraftRepository aircraftRepository;
    public List<AircraftDTO> AircraftsList = new ArrayList<AircraftDTO>();
    public HashMap<Integer, AircraftDTO> aircrafts = new HashMap<Integer, AircraftDTO>();

    @PostMapping("/aircrafts")
    public ResponseEntity<AircraftDTO> addAircraft(@RequestBody @Valid AircraftDTO ac) {
        AircraftDAO aircraftPersisted = aircraftRepository.save(ac.toDAO());
        ac.calcularSeatsClass(ac.getNumSeats());
        String tamanhoLista = String.valueOf(aircraftRepository.findAll().size());
        System.out.println("\nAeronave Cadastrada com SUCESSO!" + " - Quantidade de Aeronaves: " + tamanhoLista);
        System.out.println(aircraftPersisted.toString());
        return new ResponseEntity<AircraftDTO>(aircraftPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/aircrafts/{id}/update")
    public ResponseEntity<AircraftDTO> updateAircraft(@PathVariable("id") Long id, @RequestBody AircraftDTO ac) {
        ac.setId(id);
        AircraftDAO aircraftUpdated = aircraftRepository.save(ac.toDAO());
        return new ResponseEntity<AircraftDTO>(aircraftUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/aircrafts")
    public ResponseEntity<List<AircraftDTO>> getAllAircrafts() {
        return ResponseEntity.ok().body(aircraftRepository.findAll()
                .stream()
                .map(aircraftDAO -> aircraftDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/aircrafts/{id}")
    public ResponseEntity<AircraftDTO> getAircraftById(@PathVariable("id") Long id) {
        Optional<AircraftDAO> aircraft = aircraftRepository.findById(id);
        if (aircraft.isPresent()) {
            return new ResponseEntity<AircraftDTO>(aircraft.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/aircrafts/{id}/delete")
    public ResponseEntity<AircraftDTO> deleteAircraftById(@PathVariable("id") Long id) {
        AircraftDAO aircraft = new AircraftDAO();
        aircraft.setId(id);
        aircraftRepository.delete(aircraft);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/aircrafts/{id}/ativar")
    public void ativarAircraft(Long id) {
        aircraftRepository.findById(id).ifPresent(aircraft -> {
            aircraft.ativar();
            aircraftRepository.save(aircraft);
        });
    }

    @PostMapping("/aircrafts/{id}/inativar")
    public void inativarAircraft(Long id) {
        aircraftRepository.findById(id).ifPresent(aircraft -> {
            aircraft.inativar();
            aircraftRepository.save(aircraft);
        });
    }

}
