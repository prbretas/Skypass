package com.startech.skypass.controller;

import com.startech.skypass.dao.AddressDAO;
import com.startech.skypass.dto.AddressDTO;
import com.startech.skypass.repository.AddressRepository;
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
@RequestMapping("/adresses")
public class AddressController {

    //--------------------------------------- |ADDRESS| -----------------------------------------------------
    @Autowired
    private AddressRepository addressRepository;
    public List<AddressDTO> AddressList = new ArrayList<AddressDTO>();
    public HashMap<Integer, AddressDTO> adresses = new HashMap<Integer, AddressDTO>();

    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody @Valid AddressDTO ad) {
        AddressDAO addressPersisted = addressRepository.save(ad.toDAO());
        String tamanhoLista = String.valueOf(addressRepository.findAll().size());
        System.out.println("\nEndereço Cadastrado com SUCESSO!" + " - Quantidade de Endereços: " + tamanhoLista);
        System.out.println(addressPersisted.toString());
        ad.getFullAddress();
        return new ResponseEntity<AddressDTO>(addressPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO ad) {
        ad.setId(id);
        AddressDAO addressUpdated = addressRepository.save(ad.toDAO());
        return new ResponseEntity<AddressDTO>(addressUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAllAdresses() {
        return ResponseEntity.ok().body(addressRepository.findAll()
                .stream()
                .map(addressDAO -> addressDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable("id") Long id) {
        Optional<AddressDAO> address = addressRepository.findById(id);
        if (address.isPresent()) {
            return new ResponseEntity<AddressDTO>(address.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<AddressDTO> deleteAddressById(@PathVariable("id") Long id) {
        AddressDAO address = new AddressDAO();
        address.setId(id);
        addressRepository.delete(address);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{id}/ativar")
    public void ativar(Long id) {
        addressRepository.findById(id).ifPresent(address -> {
            address.ativar();
            addressRepository.save(address);
        });
    }

    @PostMapping("/{id}/inativar")
    public void inativar(Long id) {
        addressRepository.findById(id).ifPresent(address -> {
            address.inativar();
            addressRepository.save(address);
        });
    }



}
