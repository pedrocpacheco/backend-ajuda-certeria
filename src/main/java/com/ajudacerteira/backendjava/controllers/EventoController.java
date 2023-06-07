package com.ajudacerteira.backendjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajudacerteira.backendjava.entities.Evento;
import com.ajudacerteira.backendjava.repositories.EventoRepository;

@RestController
@CrossOrigin(origins = "*")
public class EventoController {
// Link do Endpoint funcional: https://backend-ajuda-certeria-production.up.railway.app/eventos
    
    @Autowired
    private EventoRepository repository;

    // Encotra e Retorna todos os Eventos já cadastrados -> GET
    @GetMapping("/eventos")
    public List<Evento> findAll(){
        return repository.findAll();
    }

    // Encontra e Retorna o Evento de ID igual ao ID especificado na requisição -> GET
    @GetMapping("/eventos/{id}")
    public Evento findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    // Adiciona um novo Evento. Suas informações devem ser passadas no corpo da requisição -> POST
    @PostMapping("/eventos")
    public Evento saveEvento(@RequestBody Evento evento){
        return repository.save(evento);
    }

    // Atualiza um Evento existente. É necessario passar o ID do Evento que deseja atualizar, e o seu novo corpo -> PUT
    @PutMapping("/eventos/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento evento){
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        evento.setId(id);
        return repository.save(evento);
    }

    // Deleta o Evento com ID igual ao id especificado na requisição -> DELETE
    @DeleteMapping("/eventos/{id}")
    public void deleteEvento(@PathVariable Long id){
        repository.deleteById(id);
    }
}