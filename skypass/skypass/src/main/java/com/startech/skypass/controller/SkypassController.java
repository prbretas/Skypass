package com.startech.skypass.controller;

import com.startech.skypass.dao.*;
import com.startech.skypass.dto.*;
import com.startech.skypass.repository.*;
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
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO c) {
        ClientDAO clientePersisted = clientRepository.save(c.toDAO());
        c.ativar();//------------------------ ATIVAR
        String tamanhoLista = String.valueOf(clientRepository.findAll().size());
        System.out.println("Cliente Cadastrado com SUCESSO!" + " - Quantidade de Clientes: " + tamanhoLista);
        System.out.println(c.toString());
        return new ResponseEntity<ClientDTO>(clientePersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/clients/{id}/update")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO c) {
        c.setId(id);
        ClientDAO clientUpdated = clientRepository.save(c.toDAO());
        return new ResponseEntity<ClientDTO>(clientUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok().body(clientRepository.findAll()
                .stream()
                .map(clientDAO -> clientDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id) {
        Optional<ClientDAO> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return new ResponseEntity<ClientDTO>(client.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/clients/{id}/delete")
    public ResponseEntity<ClientDTO> deleteClientById(@PathVariable("id") Long id) {
        ClientDAO client = new ClientDAO();
        client.setId(id);
        clientRepository.delete(client);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/clients/{id}/ativar")
    public void ativarClient(Long id) {
        clientRepository.findById(id).ifPresent(client -> {
            client.ativar();
            clientRepository.save(client);
        });
    }

    @PostMapping("/clients/{id}/inativar")
    public void inativarClient(Long id) {
        clientRepository.findById(id).ifPresent(client -> {
            client.inativar();
            clientRepository.save(client);
        });
    }

    //--------------------------------------- |ADDRESS| -----------------------------------------------------
    @Autowired
    private AddressRepository addressRepository;
    public List<AddressDTO> AddressList = new ArrayList<AddressDTO>();
    public HashMap<Integer, AddressDTO> adresses = new HashMap<Integer, AddressDTO>();

    @PostMapping("/adresses")
    public ResponseEntity<AddressDTO> addAddress(@RequestBody @Valid AddressDTO ad) {
        AddressDAO addressPersisted = addressRepository.save(ad.toDAO());
        String tamanhoLista = String.valueOf(addressRepository.findAll().size());
        ad.ativar();//------------------------ ATIVAR
        System.out.println("\nEndereço Cadastrado com SUCESSO!" + " - Quantidade de Endereços: " + tamanhoLista);
        System.out.println(ad.toString());
        ad.getFullAddress();
        return new ResponseEntity<AddressDTO>(addressPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/adresses/{id}/update")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO ad) {
        ad.setId(id);
        AddressDAO addressUpdated = addressRepository.save(ad.toDAO());
        return new ResponseEntity<AddressDTO>(addressUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/adresses")
    public ResponseEntity<List<AddressDTO>> getAllAdresses() {
        return ResponseEntity.ok().body(addressRepository.findAll()
                .stream()
                .map(addressDAO -> addressDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/adresses/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable("id") Long id) {
        Optional<AddressDAO> address = addressRepository.findById(id);
        if (address.isPresent()) {
            return new ResponseEntity<AddressDTO>(address.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/adresses/{id}/delete")
    public ResponseEntity<AddressDTO> deleteAddressById(@PathVariable("id") Long id) {
        AddressDAO address = new AddressDAO();
        address.setId(id);
        addressRepository.delete(address);
        return ResponseEntity.noContent().build();
    }

    //------------------------------------------------|AIRCRAFT|-------------------------------------------

    @Autowired
    private AircraftRepository aircraftRepository;
    public List<AircraftDTO> AircraftsList = new ArrayList<AircraftDTO>();
    public HashMap<Integer, AircraftDTO> aircrafts = new HashMap<Integer, AircraftDTO>();

    @PostMapping("/aircrafts")
    public ResponseEntity<AircraftDTO> addAircraft(@RequestBody @Valid AircraftDTO ac) {
        AircraftDAO aircraftPersisted = aircraftRepository.save(ac.toDAO());
        ac.calcularSeatsClass(ac.getNumSeats());
        ac.ativar();//------------------------ ATIVAR
        String tamanhoLista = String.valueOf(aircraftRepository.findAll().size());
        System.out.println("\nAeronave Cadastrada com SUCESSO!" + " - Quantidade de Aeronaves: " + tamanhoLista);
        System.out.println(ac.toString());
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

    //--------------------------------------|FLIGHT|------------------------------------------------------

    @Autowired
    private FlightRepository flightRepository;
    public List<FlightDTO> FlightsList = new ArrayList<FlightDTO>();
    public HashMap<Integer, FlightDTO> flights = new HashMap<Integer, FlightDTO>();

    @PostMapping("/flights")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody @Valid FlightDTO ft) {
        FlightDAO flightPersisted = flightRepository.save(ft.toDAO());
        ft.ativar();//------------------------ ATIVAR
        String tamanhoLista = String.valueOf(flightRepository.findAll().size());
        System.out.println("\nVôo cadastrado com SUCESSO!" + " - Quantidade de Vôo: " + tamanhoLista);
        System.out.println(ft.toString());
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
    public void ativarFlight(Long id) {
        flightRepository.findById(id).ifPresent(flight -> {
            flight.ativar();
            flightRepository.save(flight);
        });
    }

    @PostMapping("/flights/{id}/inativar")
    public void inativarFlight(Long id) {
        flightRepository.findById(id).ifPresent(flight -> {
            flight.inativar();
            flightRepository.save(flight);
        });
    }


    //--------------------------------------|AIRLINE|------------------------------------------------------

    @Autowired
    private AirlineRepository airlineRepository;
    public List<AirlineDTO> AirlinesList = new ArrayList<AirlineDTO>();
    public HashMap<Integer, AirlineDTO> airlines = new HashMap<Integer, AirlineDTO>();

    @PostMapping("/airlines")
    public ResponseEntity<AirlineDTO> addAirline(@RequestBody @Valid AirlineDTO al) {
        AirlineDAO airlinePersisted = airlineRepository.save(al.toDAO());
        al.ativar();//------------------------ ATIVAR
        String tamanhoLista = String.valueOf(airlineRepository.findAll().size());
        System.out.println("\nCia Aérea cadastrada com SUCESSO!" + " - Quantidade de Cia Aéreas: " + tamanhoLista);
        System.out.println(al.toString());
        return new ResponseEntity<AirlineDTO>(airlinePersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/airlines/{id}/update")
    public ResponseEntity<AirlineDTO> updateAirline(@PathVariable("id") Long id, @RequestBody AirlineDTO al) {
        al.setId(id);
        AirlineDAO airlineUpdated = airlineRepository.save(al.toDAO());
        return new ResponseEntity<AirlineDTO>(airlineUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/airlines")
    public ResponseEntity<List<AirlineDTO>> getAllAirline() {
        return ResponseEntity.ok().body(airlineRepository.findAll()
                .stream()
                .map(airlineDAO -> airlineDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/airlines/{id}")
    public ResponseEntity<AirlineDTO> getAirlineById(@PathVariable("id") Long id) {
        Optional<AirlineDAO> airline = airlineRepository.findById(id);
        if (airline.isPresent()) {
            return new ResponseEntity<AirlineDTO>(airline.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/airlines/{id}/delete")
    public ResponseEntity<AirlineDTO> deleteAirlineById(@PathVariable("id") Long id) {
        AirlineDAO airline = new AirlineDAO();
        airline.setId(id);
        airlineRepository.delete(airline);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/airlines/{id}/ativar")
    public void ativarAirline(Long id) {
        airlineRepository.findById(id).ifPresent(airline -> {
            airline.ativar();
            airlineRepository.save(airline);
        });
    }

    @PostMapping("/airlines/{id}/inativar")
    public void inativarAirline(Long id) {
        airlineRepository.findById(id).ifPresent(airline -> {
            airline.inativar();
            airlineRepository.save(airline);
        });
    }

    //--------------------------------------- |AIRPORT| -----------------------------------------------------

    @Autowired
    private AirportRepository airportRepository;
    public List<AirportDTO> AirportsList = new ArrayList<AirportDTO>();
    public HashMap<Integer, AirportDTO> airports = new HashMap<Integer, AirportDTO>();

    @PostMapping("/airports")
    public ResponseEntity<AirportDTO> addAirport(@RequestBody @Valid AirportDTO ap) {
        AirportDAO airportPersisted = airportRepository.save(ap.toDAO());
        ap.ativar();//------------------------ ATIVAR
        String tamanhoLista = String.valueOf(airportRepository.findAll().size());
        System.out.println("\nAeroporto Cadastrado com SUCESSO!" + " - Quantidade de Aeroportos: " + tamanhoLista);
        System.out.println(ap.toString());
        return new ResponseEntity<AirportDTO>(airportPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/airports/{id}/update")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable("id") Long id, @RequestBody AirportDTO ap) {
        ap.setId(id);
        AirportDAO airportUpdated = airportRepository.save(ap.toDAO());
        return new ResponseEntity<AirportDTO>(airportUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/airports")
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        return ResponseEntity.ok().body(airportRepository.findAll()
                .stream()
                .map(airportDAO -> airportDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable("id") Long id) {
        Optional<AirportDAO> airport = airportRepository.findById(id);
        if (airport.isPresent()) {
            return new ResponseEntity<AirportDTO>(airport.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/airports/{id}/delete")
    public ResponseEntity<AirportDTO> deleteAirportById(@PathVariable("id") Long id) {
        AirportDAO airport = new AirportDAO();
        airport.setId(id);
        airportRepository.delete(airport);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/airports/{id}/ativar")
    public void ativarAirport(Long id) {
        airportRepository.findById(id).ifPresent(airport -> {
            airport.ativar();
            airportRepository.save(airport);
        });
    }

    @PostMapping("/airports/{id}/inativar")
    public void inativarAirport(Long id) {
        airportRepository.findById(id).ifPresent(airport -> {
            airport.inativar();
            airportRepository.save(airport);
        });
    }
    //--------------------------------------- |TICKETS| -----------------------------------------------------
    @Autowired
    private TicketRepository ticketRepository;
    public List<TicketDTO> TicketsList = new ArrayList<TicketDTO>();
    public HashMap<Integer, TicketDTO> tickets = new HashMap<Integer, TicketDTO>();

    @PostMapping("/tickets")
    public ResponseEntity<TicketDTO> addTicket(@RequestBody @Valid TicketDTO tk) {
        TicketDAO ticketPersisted = ticketRepository.save(tk.toDAO());
        tk.ativar();//------------------------ ATIVAR
        String tamanhoLista = String.valueOf(ticketRepository.findAll().size());
        System.out.println("\nPassagem cadastrada com SUCESSO!" + " - Quantidade de Passagens: " + tamanhoLista);
        System.out.println(tk.toString());
        return new ResponseEntity<TicketDTO>(ticketPersisted.toDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/tickets/{id}/update")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable("id") Long id, @RequestBody TicketDTO tk) {
        tk.setId(id);
        TicketDAO ticketUpdated = ticketRepository.save(tk.toDAO());
        return new ResponseEntity<TicketDTO>(ticketUpdated.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        return ResponseEntity.ok().body(ticketRepository.findAll()
                .stream()
                .map(ticketDAO -> ticketDAO.toDTO())
                .collect(Collectors.toList()));
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable("id") Long id) {
        Optional<TicketDAO> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            return new ResponseEntity<TicketDTO>(ticket.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/tickets/{id}/delete")
    public ResponseEntity<TicketDTO> deleteTicketById(@PathVariable("id") Long id) {
        TicketDAO ticket = new TicketDAO();
        ticket.inativar(); //--------------------- INATIVAR
        ticket.setId(id);
        ticketRepository.delete(ticket);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tickets/{id}/ativar")
    public void ativarTicket(Long id) {
        ticketRepository.findById(id).ifPresent(ticket -> {
            ticket.ativar();
            ticketRepository.save(ticket);
        });
    }

    @PostMapping("/tickets/{id}/inativar")
    public void inativarTicket(Long id) {
        ticketRepository.findById(id).ifPresent(ticket -> {
            ticket.inativar();
            ticketRepository.save(ticket);
        });
    }


}