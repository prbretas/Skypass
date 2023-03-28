package com.startech.skypass.controller;

import com.startech.skypass.dao.SeatDAO;
import com.startech.skypass.dto.SeatDTO;
import com.startech.skypass.repository.SeatRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
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
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private SeatRepository seatRepository;
    public List<SeatDTO> seatsList = new ArrayList<SeatDTO>();
    public HashMap<Integer, SeatDTO> seats = new HashMap<Integer, SeatDTO>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SeatDTO> addSeat(@RequestBody @Valid SeatDTO st) {
        SeatDAO seatPersisted = seatRepository.save(st.toDAO());
        String tamanhoLista = String.valueOf(seatRepository.findAll().size());
        System.out.println("Assento Cadastrado com SUCESSO!" + " - Quantidade de Assentos: " + tamanhoLista);
        System.out.println(seatPersisted.toString());
        seatPersisted.toDTO();
        return new ResponseEntity<SeatDTO>(seatPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<SeatDTO> updateSeat(@PathVariable("id") Long id, @RequestBody SeatDTO st) {
        st.setIdSeat(id);
        SeatDAO seatUpdated = seatRepository.save(st.toDAO());
        System.out.println(st.getIdSeat() + " - Assento Alterado com SUCESSO!");
        return new ResponseEntity<SeatDTO>(seatUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SeatDTO>> getAllSeats() {
        return ResponseEntity.ok().body(seatRepository.findAll()
                .stream()
                .map(seatDAO -> seatDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatDTO> getSeatById(@PathVariable("id") Long id) {
        Optional<SeatDAO> seat = seatRepository.findById(id);

        if (seat.isPresent())
            return new ResponseEntity<SeatDTO>(seat.get().toDTO(), HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<SeatDTO> deleteSeatById(@PathVariable("id") Long id) {
        SeatDAO seat = new SeatDAO();
        seat.setIdSeat(id);
        seatRepository.delete(seat);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> tratar(ConstraintViolationException exception) {
        List<String> erros = new ArrayList<>();

        for(ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String erro = String.format(
                    "%s %s",
                    violation.getPropertyPath().toString(),
                    violation.getMessage()
            );
            erros.add(erro);
        }
        return erros;
    }
}
