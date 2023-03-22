package com.startech.skypass.controller;

import com.startech.skypass.dao.AirlineDAO;
import com.startech.skypass.dto.AirlineDTO;
import com.startech.skypass.repository.AirlineRepository;
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
@RequestMapping("/airlines")
public class AirlineController {
    //--------------------------------------|AIRLINE|------------------------------------------------------
    @Autowired
    private AirlineRepository airlineRepository;
    public List<AirlineDTO> AirlinesList = new ArrayList<AirlineDTO>();
    public HashMap<Integer, AirlineDTO> airlines = new HashMap<Integer, AirlineDTO>();

    @PostMapping
    public ResponseEntity<AirlineDTO> addAirline(@RequestBody @Valid AirlineDTO al) {
        AirlineDAO airlinePersisted = airlineRepository.save(al.toDAO());
        String tamanhoLista = String.valueOf(airlineRepository.findAll().size());
        System.out.println("\nCia Aérea cadastrada com SUCESSO!" + " - Quantidade de Cia Aéreas: " + tamanhoLista);
        System.out.println(airlinePersisted.toString());
        return new ResponseEntity<AirlineDTO>(airlinePersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AirlineDTO> updateAirline(@PathVariable("id") Long id, @RequestBody AirlineDTO al) {
        al.setId(id);
        AirlineDAO airlineUpdated = airlineRepository.save(al.toDAO());
        return new ResponseEntity<AirlineDTO>(airlineUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AirlineDTO>> getAllAirline() {
        return ResponseEntity.ok().body(airlineRepository.findAll()
                .stream()
                .map(airlineDAO -> airlineDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineDTO> getAirlineById(@PathVariable("id") Long id) {
        Optional<AirlineDAO> airline = airlineRepository.findById(id);
        if (airline.isPresent()) {
            return new ResponseEntity<AirlineDTO>(airline.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<AirlineDTO> deleteAirlineById(@PathVariable("id") Long id) {
        AirlineDAO airline = new AirlineDAO();
        airline.setId(id);
        airlineRepository.delete(airline);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/ativar")
    public void ativar(Long id) {
        airlineRepository.findById(id).ifPresent(airline -> {
            airline.ativar();
            airlineRepository.save(airline);
        });
    }

    @PostMapping("/{id}/inativar")
    public void inativar(Long id) {
        airlineRepository.findById(id).ifPresent(airline -> {
            airline.inativar();
            airlineRepository.save(airline);
        });
    }
}
