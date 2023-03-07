package com.startech.skypass;

import com.startech.skypass.Client;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class SkypassController {
    public HashMap<String, Client> clients = new HashMap<String,Client>();

    @PostMapping("/client")
    public Client adicionarCliente (@RequestBody Client c){
        clients.put(c.getId(),c);
        String tamanhoLista = String.valueOf(clients.size());
        System.out.println("Cliente Cadastrado com SUCESSO!"+ " - Quantidade de Clientes: " + tamanhoLista);
        System.out.println( c.toString());
        return c;
    }

    @GetMapping("/client")
    public Collection<Client> getAllClientes(){
        return clients.values();
    }

    //@GetMapping ("/cliente/{id}/compras{idCompra}")
    @GetMapping ("/client/{id}")
    public Client getClientById(@PathVariable("id") String id){
        return clients.get(id);
    }

    @PutMapping ("/client/{id}")
    public Client atualizaCliente(@PathVariable("id") String id, @RequestBody Client c){
        System.out.println("Cliente Alterado com SUCESSO! "+ c.getId() + " " + c.getUserName());
        return clients.put(id,c);
    }

    @DeleteMapping ("/client/{id}")
    public Client deletarClienteById(@PathVariable("id") String id){
        return clients.remove(id);
    }



}
