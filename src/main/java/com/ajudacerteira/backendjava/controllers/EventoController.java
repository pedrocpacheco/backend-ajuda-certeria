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
    
    @Autowired
    private EventoRepository repository;

    @GetMapping("/eventos")
    public List<Evento> findAll(){
        return repository.findAll();
    }

    @GetMapping("/eventos/{id}")
    public Evento findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/eventos")
    public Evento saveEvento(@RequestBody Evento evento){
        return repository.save(evento);
    }

    @PutMapping("/eventos/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento evento){
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        evento.setId(id);
        return repository.save(evento);
    }

    @DeleteMapping("/eventos/{id}")
    public void deleteEvento(@PathVariable Long id){
        repository.deleteById(id);
    }
}