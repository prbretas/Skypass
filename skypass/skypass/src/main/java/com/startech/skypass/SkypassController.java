package com.startech.skypass;

import com.startech.skypass.dao.AdressDAO;
import com.startech.skypass.dao.ClientDAO;
import com.startech.skypass.repository.AdressRepository;
import com.startech.skypass.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class SkypassController {

    //--------------------------------------|CLIENT|------------------------------------------------------
    @Autowired
    private ClientRepository clientRepository;
    public List<ClientDTO> ClientsList = new ArrayList<ClientDTO>();
    public HashMap<Integer, ClientDTO> clients = new HashMap<Integer, ClientDTO>();

    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> addClient (@RequestBody @Valid ClientDTO c){
        ClientDAO clientePersisted = clientRepository.save(c.toDAO());
        String tamanhoLista = String.valueOf(clients.size());
        System.out.println("Cliente Cadastrado com SUCESSO!"+ " - Quantidade de Clientes: " + tamanhoLista);
        System.out.println( c.toString());
        return new ResponseEntity<ClientDTO>(clientePersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping ("/clients/{id}/update")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO c){
        c.setId(id);
        ClientDAO clientUpdated = clientRepository.save(c.toDAO());
        return new ResponseEntity<ClientDTO>(clientUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        return ResponseEntity.ok().body(clientRepository.findAll()
                .stream()
                .map(clientDAO -> clientDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping ("/clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id){
        Optional<ClientDAO> client = clientRepository.findById(id);
        if (client.isPresent()){
            return new ResponseEntity<ClientDTO>(client.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/clients/{id}/delete")
    public ResponseEntity<ClientDTO> deleteClientById(@PathVariable("id") Long id){
        ClientDAO client = new ClientDAO();
        client.setId(id);
        clientRepository.delete(client);
        return ResponseEntity.noContent().build();
    }
    //--------------------------------------- |ADRESS| -----------------------------------------------------
    @Autowired
    private AdressRepository adressRepository;
    public List<AdressDTO> AdressList = new ArrayList<AdressDTO>();
    public HashMap<Integer, AdressDTO> adresses = new HashMap<Integer, AdressDTO>();

    @PostMapping("/adresses")
    public ResponseEntity<AdressDTO> addAdress (@RequestBody @Valid AdressDTO ad){
        AdressDAO adressPersisted = adressRepository.save(ad.toDAO());
        String tamanhoLista = String.valueOf(adresses.size());
        System.out.println("Endereço Cadastrado com SUCESSO!"+ " - Quantidade de Endereços: " + tamanhoLista);
        System.out.println(ad.toString());
        return new ResponseEntity<AdressDTO>(adressPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping ("/adresses/{id}/update")
    public ResponseEntity<AdressDTO> updateAdress(@PathVariable("id") Long id, @RequestBody AdressDTO ad){
        ad.setId(id);
        AdressDAO adressUpdated = adressRepository.save(ad.toDAO());
        return new ResponseEntity<AdressDTO>(adressUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/adresses")
    public ResponseEntity<List<AdressDTO>> getAllAdresses(){
        return ResponseEntity.ok().body(adressRepository.findAll()
                .stream()
                .map(adressDAO -> adressDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping ("/adresses/{id}")
    public ResponseEntity<AdressDTO> getAdressById(@PathVariable("id") Long id){
        Optional<AdressDAO> adress = adressRepository.findById(id);
        if (adress.isPresent()){
            return new ResponseEntity<AdressDTO>(adress.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/adresses/{id}/delete")
    public ResponseEntity<AdressDTO> deleteAdressById(@PathVariable("id") Long id){
        AdressDAO adress = new AdressDAO();
        adress.setId(id);
        adressRepository.delete(adress);
        return ResponseEntity.noContent().build();
    }
    //------------------------------------------------|AIRCRAFT|-------------------------------------------
    public HashMap<String, Aircraft> aircrafts = new HashMap<String,Aircraft>();

    @PostMapping("/aircrafts")
    public Aircraft adicionarAircraft (@RequestBody Aircraft at){
        aircrafts.put(at.getId(), at);
        String tamanhoLista = String.valueOf(aircrafts.size());
        System.out.println("Aeronave Cadastrada com SUCESSO!"+ " - Quantidade de Aeronaves: " + tamanhoLista);
        System.out.println(at.toString());
        return at;
    }

    @GetMapping("/aircrafts")
    public Collection<Aircraft> getAllAircrafts(){
        return aircrafts.values();
    }

    @GetMapping ("/aircrafts/{id}")
    public Aircraft getAircraftById(@PathVariable("id") String id){
        return aircrafts.get(id);
    }

    @PutMapping ("/aircrafts/{id}/alterar")
    public Aircraft atualizaAircraft(@PathVariable("id") String id, @RequestBody Aircraft at){
        System.out.println("Aeronave Alterada com SUCESSO! "+ at.getId() + " " + at.getModel());
        return aircrafts.put(id,at);
    }
    @DeleteMapping ("/aircrafts/{id}/excluir")
    public Aircraft deletarAircraftById(@PathVariable("id") String id){
        System.out.println("Aeronave Deletada com SUCESSO!");
        return aircrafts.remove(id);
    }

    //--------------------------------------|FLIGHT|------------------------------------------------------

    public HashMap<String, Flight> flights = new HashMap<String, Flight>();

    @PostMapping("/flights")
    public Flight adicionarFlight (@RequestBody Flight ft){
        flights.put(ft.getId(), ft);
        String tamanhoLista = String.valueOf(flights.size());
        System.out.println("Voo Cadastrado com SUCESSO!"+ " - Quantidade de Voos: " + tamanhoLista);
        System.out.println(ft.toString());
        return ft;
    }

    @GetMapping("/flights")
    public Collection<Flight> getAllFlight(){
        return flights.values();
    }


    @GetMapping ("/flights/{id}")
    public Flight getFlightById(@PathVariable("id") String id){
        return flights.get(id);
    }

    @PutMapping ("/flights/{id}/alterar")
    public Flight atualizaFlight(@PathVariable("id") String id, @RequestBody Flight ft){
        System.out.println("Voo Alterado com SUCESSO! "+ ft.getId() + " " + ft.getLocation());
        return flights.put(id, ft);
    }
    @DeleteMapping ("/flights/{id}/excluir")
    public Flight deletarFlightById(@PathVariable("id") String id){
        System.out.println("Voo Deletado com SUCESSO!");
        return flights.remove(id);
    }

    //--------------------------------------|AIRLINE|------------------------------------------------------
    public HashMap<String, Airline> airlines = new HashMap<String,Airline>();

    @PostMapping("/airlines")
    public Airline adicionarCiaAerea (@RequestBody Airline al ){
        airlines.put(al.getId(),al);
        String tamanhoLista = String.valueOf(airlines.size());
        System.out.println("Cia Aérea Cadastrada com SUCESSO!" + tamanhoLista);
        System.out.println( al.toString());
        return al;
    }

    @GetMapping("/airlines")
    public Collection<Airline> getCiaAerea(){
        HashMap<Object, Object> Airline;
        return airlines.values();
    }

    @GetMapping ("/airlines/{id}")
    public Airline getAirlinesById(@PathVariable("id") String id){
        return airlines.get(id);
    }

    @PutMapping ("/airlines/{id}/alterar")
    public Airline atualizarAirline (@PathVariable("id") String id, @RequestBody Airline al){
        System.out.println("Cia Aérea Alterada com SUCESSO! "+ al.getId() + " " + al.getCompanyName());
        return airlines.put(id,al);
    }
    @DeleteMapping ("/airlines/{id}/excluir")
    public Airline deletarAirlineById(@PathVariable("id") String id){
        System.out.println("Cia Aérea Deletada com SUCESSO!");
        return airlines.remove(id);
    }

    //--------------------------------------- |AIRPORT| -----------------------------------------------------
    public HashMap<String, Airport> airports = new HashMap<String,Airport>();

    @PostMapping("/airports")
    public Airport adicionarAirport (@RequestBody Airport ap){
        airports.put(ap.getId(),ap);
        String tamanhoLista = String.valueOf(airports.size());
        System.out.println("Aeroporto Cadastrado com SUCESSO!"+ " - Quantidade de Aeroportos: " + tamanhoLista);
        System.out.println( ap.toString());
        return ap;
    }

    @GetMapping("/airports")
    public Collection<Airport> getAllAirports(){
        return airports.values();
    }

    @GetMapping ("/airports/{id}")
    public Airport getAirportById(@PathVariable("id") String id){
        return airports.get(id);
    }

    @PutMapping ("/airports/{id}/alterar")
    public Airport atualizarAirport(@PathVariable("id") String id, @RequestBody Airport ap){
        System.out.println("Aeroporto alterado com SUCESSO! "+ ap.getId() + " " + ap.getName());
        return airports.put(id,ap);
    }

    @DeleteMapping ("/airports/{id}/excluir")
    public Airport deletarAirportById(@PathVariable("id") String id){
        System.out.println("Aeroporto deletado com SUCESSO!");
        return airports.remove(id);
    }

    //--------------------------------------- |TICKETS| -----------------------------------------------------
    public HashMap<String, Ticket> tickets = new HashMap<String,Ticket>();

    @PostMapping("/tickets")
    public Ticket adicionarTicket (@RequestBody Ticket tk){
        tickets.put(tk.getId(),tk);
        String tamanhoLista = String.valueOf(tickets.size());
        System.out.println("\nPassagem Cadastrada com SUCESSO!"+ " - Quantidade de Passagens: " + tamanhoLista);
        System.out.println(tk.toString());
        return tk;
    }

    @GetMapping ("/tickets/{id}")
    public Ticket getTicketById(@PathVariable("id") String id){
        return tickets.get(id);
    }

    @GetMapping("/tickets")
    public Collection<Ticket> getAllTickets(){
        return tickets.values();
    }

    @PutMapping ("/tickets/{id}/alterar")
    public Ticket atualizarTicket(@PathVariable("id") String id, @RequestBody Ticket tk){
        System.out.println("\nPassagem alterada com SUCESSO!\n Id:"+ tk.getId() + " Nª do Vôo:" + tk.getIdFlight());
        return tickets.put(id,tk);
    }

    @DeleteMapping ("/tickets/{id}/excluir")
    public Ticket deletarTicketById(@PathVariable("id") String id){
        System.out.println("\nPassagem deletado com SUCESSO!");
        return tickets.remove(id);
    }
}
