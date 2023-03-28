package com.startech.skypass.controller;

import com.startech.skypass.dao.TicketDAO;
import com.startech.skypass.dto.TicketDTO;
import com.startech.skypass.repository.TicketRepository;
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
@RequestMapping("/tickets")
public class TicketController {

    //--------------------------------------- |TICKETS| -----------------------------------------------------
    @Autowired
    private TicketRepository ticketRepository;
    public List<TicketDTO> TicketsList = new ArrayList<TicketDTO>();
    public HashMap<Integer, TicketDTO> tickets = new HashMap<Integer, TicketDTO>();

    @PostMapping
    public ResponseEntity<TicketDTO> addTicket(@RequestBody @Valid TicketDTO tk) {
        TicketDAO ticketPersisted = ticketRepository.save(tk.toDAO());
        String tamanhoLista = String.valueOf(ticketRepository.findAll().size());
        System.out.println("\nPassagem cadastrada com SUCESSO!" + " - Quantidade de Passagens: " + tamanhoLista);
        System.out.println(ticketPersisted.toString());
        return new ResponseEntity<TicketDTO>(ticketPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable("id") Long id, @RequestBody TicketDTO tk) {
        tk.setIdTicket(id);
        TicketDAO ticketUpdated = ticketRepository.save(tk.toDAO());
        return new ResponseEntity<TicketDTO>(ticketUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        return ResponseEntity.ok().body(ticketRepository.findAll()
                .stream()
                .map(ticketDAO -> ticketDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable("id") Long id) {
        Optional<TicketDAO> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            return new ResponseEntity<TicketDTO>(ticket.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<TicketDTO> deleteTicketById(@PathVariable("id") Long id) {
        TicketDAO ticket = new TicketDAO();
        ticket.inativar(); //--------------------- INATIVAR
        ticket.setIdTicket(id);
        ticketRepository.delete(ticket);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/ativar")
    public void ativar(Long id) {
        ticketRepository.findById(id).ifPresent(ticket -> {
            ticket.ativar();
            ticketRepository.save(ticket);
        });
    }

    @PostMapping("/{id}/inativar")
    public void inativar(Long id) {
        ticketRepository.findById(id).ifPresent(ticket -> {
            ticket.inativar();
            ticketRepository.save(ticket);
        });
    }
}
