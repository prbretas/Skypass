package com.startech.skypass;

import com.startech.skypass.Client;
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

    @PutMapping ("/clients/{id}")
    public Client atualizaCliente(@PathVariable("id") String id, @RequestBody Client c){
        System.out.println("Cliente Alterado com SUCESSO! "+ c.getId() + " " + c.getUserName());
        return clients.put(id,c);
    }
    @DeleteMapping ("/clients/{id}")
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

    @PutMapping ("/adresses/{id}")
    public Adress atualizaAdress(@PathVariable("id") String id, @RequestBody Adress a){
        System.out.println("Endereço Alterado com SUCESSO! "+ a.getId() + " " + a.getStreet());
        return adresses.put(id,a);
    }

    @DeleteMapping ("/adresses/{id}")
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

    @PutMapping ("/aircrafts/{id}")
    public Aircraft atualizaAircraft(@PathVariable("id") String id, @RequestBody Aircraft at){
        System.out.println("Aeronave Alterada com SUCESSO! "+ at.getId() + " " + at.getModel());
        return aircrafts.put(id,at);
    }
    @DeleteMapping ("/aircrafts/{id}")
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

    //@GetMapping ("/clients/{id}/compras{idCompra}")
    @GetMapping ("/flights/{id}")
    public Flight getFlightById(@PathVariable("id") String id){
        return flights.get(id);
    }

    @PutMapping ("/flights/{id}")
    public Flight atualizaFlight(@PathVariable("id") String id, @RequestBody Flight ft){
        System.out.println("Voo Alterado com SUCESSO! "+ ft.getId() + " " + ft.getLocation());
        return flights.put(id, ft);
    }
    @DeleteMapping ("/flights/{id}")
    public Flight deletarFlightById(@PathVariable("id") String id){
        System.out.println("Voo Deletado com SUCESSO!");
        return flights.remove(id);
    }

        //--------------------------------------|AIRLINE|------------------------------------------------------
    public HashMap<String, Airline> airlines = new HashMap<String,Airline>();

    @PostMapping("/airlines")
    public Airline adicionarCiaAerea (@RequestBody Airline al ){
        Airline.put(al.getId(),al);
        String tamanhoLista = String.valueOf(Airline.size());
        System.out.println("Cia Aérea Cadastrada com SUCESSO!" + tamanhoLista);
        System.out.println( al.toString());
        return al;
    }

    @GetMapping("/airlines")
    public Collection<Airline> getCiaAerea(){
        HashMap<Object, Object> Airline;
        return List.of(java.Airline.values());
    }

    @GetMapping ("/airlines/{id}")
    public Airline getCiaAerea(@PathVariable("id") String id){
        return Airline.get(id);
    }

    @PutMapping ("/airlines/{id}")
    public Airline Airline (@PathVariable("id") String id, @RequestBody Airline al){
        System.out.println("Cia aérea Alterada com SUCESSO! "+ al.getId() + " " + al.getCompanyName());
        return airlines.put(id,al);
    }
    @DeleteMapping ("/airlines/{id}")
    public Airline deletarAirlineById(@PathVariable("id") String id){
        System.out.println("Cia aérea Deletada com SUCESSO!");
        return airlines.remove(id);
    }

    //--------------------------------------- |ADRESS| -----------------------------------------------------
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

    @PutMapping ("/airports/{id}")
    public Airport atualizaAirport(@PathVariable("id") String id, @RequestBody Airport ap){
        System.out.println("Aeroporto alterado com SUCESSO! "+ ap.getId() + " " + ap.getStreet());
        return airports.put(id,ap);
    }

    @DeleteMapping ("/airports/{id}")
    public Airport deletarAirportById(@PathVariable("id") String id){
        System.out.println("Aeroporto deletado com SUCESSO!");
        return airports.remove(id);
    }
}
