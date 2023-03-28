package com.startech.skypass.controller;

import com.startech.skypass.dao.AircraftDAO;
import com.startech.skypass.dao.SeatDAO;
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
@RequestMapping("/aircrafts")
public class AircraftController {
    @Autowired
    private AircraftRepository aircraftRepository;
    public List<AircraftDTO> AircraftsList = new ArrayList<AircraftDTO>();
    public HashMap<Integer, AircraftDTO> aircrafts = new HashMap<Integer, AircraftDTO>();

    @PostMapping
    public ResponseEntity<AircraftDTO> addAircraft(@RequestBody @Valid AircraftDTO ac) {
        AircraftDAO aircraftPersisted = aircraftRepository.save(ac.toDAO());
        String tamanhoLista = String.valueOf(aircraftRepository.findAll().size());
        System.out.println("\nAeronave Cadastrada com SUCESSO!" + " - Quantidade de Aeronaves: " + tamanhoLista);
        System.out.println(aircraftPersisted.toString());
        return new ResponseEntity<AircraftDTO>(aircraftPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AircraftDTO> updateAircraft(@PathVariable("id") Long id, @RequestBody AircraftDTO ac) {
        ac.setIdAircraft(id);
        AircraftDAO aircraftUpdated = aircraftRepository.save(ac.toDAO());
        return new ResponseEntity<AircraftDTO>(aircraftUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AircraftDTO>> getAllAircrafts() {
        return ResponseEntity.ok().body(aircraftRepository.findAll()
                .stream()
                .map(aircraftDAO -> aircraftDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AircraftDTO> getAircraftById(@PathVariable("id") Long id) {
        Optional<AircraftDAO> aircraft = aircraftRepository.findById(id);
        if (aircraft.isPresent()) {
            return new ResponseEntity<AircraftDTO>(aircraft.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<AircraftDTO> deleteAircraftById(@PathVariable("id") Long id) {
        AircraftDAO aircraft = new AircraftDAO();
        aircraft.setIdAircraft(id);
        aircraftRepository.delete(aircraft);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/ativar")
    public void ativar(Long id) {
        aircraftRepository.findById(id).ifPresent(aircraft -> {
            aircraft.ativar();
            aircraftRepository.save(aircraft);
        });
    }

    @PostMapping("/{id}/inativar")
    public void inativar(Long id) {
        aircraftRepository.findById(id).ifPresent(aircraft -> {
            aircraft.inativar();
            aircraftRepository.save(aircraft);
        });
    }

}
