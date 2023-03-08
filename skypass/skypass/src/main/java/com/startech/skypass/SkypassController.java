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
    //-----------------------------------------------------------------------------------------------------

}
