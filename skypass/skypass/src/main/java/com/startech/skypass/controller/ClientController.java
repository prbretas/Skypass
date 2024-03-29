package com.startech.skypass.controller;

import com.startech.skypass.dao.ClientDAO;
import com.startech.skypass.dto.ClientDTO;
import com.startech.skypass.repository.ClientRepository;
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
@RequestMapping("/api/v1/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    public List<ClientDTO> clientsList = new ArrayList<ClientDTO>();
    public HashMap<Integer, ClientDTO> clients = new HashMap<Integer, ClientDTO>();

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO c) {
        ClientDAO clientPersisted = clientRepository.save(c.toDAO());
        String tamanhoLista = String.valueOf(clientRepository.findAll().size());
        System.out.println("Cliente Cadastrado com SUCESSO!" + " - Quantidade de Clientes: " + tamanhoLista);
        System.out.println(clientPersisted.toString());
        clientPersisted.toDTO();
        return new ResponseEntity<ClientDTO>(clientPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO c) {
        c.setIdClient(id);
        ClientDAO clientUpdated = clientRepository.save(c.toDAO());
        return new ResponseEntity<ClientDTO>(clientUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok().body(clientRepository.findAll()
                .stream()
                .map(clientDAO -> clientDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id) {
        Optional<ClientDAO> client = clientRepository.findById(id);

        if (client.isPresent())
            return new ResponseEntity<ClientDTO>(client.get().toDTO(), HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ClientDTO> deleteClientById(@PathVariable("id") Long id) {
        ClientDAO client = new ClientDAO();
        client.setIdClient(id);
        clientRepository.delete(client);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/ativar")
    public void ativar(@PathVariable("id") Long id) {
        clientRepository.findById(id).ifPresent(client -> {
            client.ativar();
            clientRepository.save(client);
        });
    }


    @PostMapping("/{id}/inativar")
    public void inativar(@PathVariable("id") Long id) {
        clientRepository.findById(id).ifPresent(client -> {
            client.inativar();
            clientRepository.save(client);
        });
    }



}
