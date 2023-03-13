package com.startech.skypass;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class SkypassController {

    //--------------------------------------|CLIENT|------------------------------------------------------
    public HashMap<String, Client> clients = new HashMap<String,Client>();

    @PostMapping("/clients")
    public Client adicionarCliente (@RequestBody Client c){
        clients.put(c.getId(),c);
        String tamanhoLista = String.valueOf(clients.size());
        System.out.println("Cliente Cadastrado com SUCESSO!"+ " - Quantidade de Clientes: " + tamanhoLista);
        System.out.println( c.toString());
        return c;
    }

    @GetMapping("/clients")
    public Collection<Client> getAllClientes(){
        return clients.values();
    }

    //@GetMapping ("/clients/{id}/compras{idCompra}")
    @GetMapping ("/clients/{id}")
    public Client getClientById(@PathVariable("id") String id){
        return clients.get(id);
    }

    @PutMapping ("/clients/{id}/alterar")
    public Client atualizaCliente(@PathVariable("id") String id, @RequestBody Client c){
        System.out.println("Cliente Alterado com SUCESSO! "+ c.getId() + " " + c.getUserName());
        return clients.put(id,c);
    }
    @DeleteMapping ("/clients/{id}/excluir")
    public Client deletarClienteById(@PathVariable("id") String id){
        System.out.println("Cliente Deletado com SUCESSO!");
        return clients.remove(id);
    }
    //--------------------------------------- |ADRESS| -----------------------------------------------------
    public HashMap<String, Adress> adresses = new HashMap<String,Adress>();

    @PostMapping("/adresses")
    public Adress adicionarAdress (@RequestBody Adress a){
        adresses.put(a.getId(),a);
        String tamanhoLista = String.valueOf(adresses.size());
        System.out.println("Endereço Cadastrado com SUCESSO!"+ " - Quantidade de Endereços: " + tamanhoLista);
        System.out.println( a.toString());
        return a;
    }

    @GetMapping("/adresses")
    public Collection<Adress> getAllEndereços(){
        return adresses.values();
    }

    @GetMapping ("/adresses/{id}")
    public Adress getAdressById(@PathVariable("id") String id){
        return adresses.get(id);
    }

    @PutMapping ("/adresses/{id}/alterar")
    public Adress atualizaAdress(@PathVariable("id") String id, @RequestBody Adress a){
        System.out.println("Endereço Alterado com SUCESSO! "+ a.getId() + " " + a.getStreet());
        return adresses.put(id,a);
    }

    @DeleteMapping ("/adresses/{id}/excluir")
    public Adress deletarAdressById(@PathVariable("id") String id){
        System.out.println("Endereço Deletado com SUCESSO!");
        return adresses.remove(id);
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
