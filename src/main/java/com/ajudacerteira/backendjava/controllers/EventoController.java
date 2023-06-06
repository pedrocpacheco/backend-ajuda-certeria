package com.ajudacerteira.backendjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajudacerteira.backendjava.entities.Evento;
import com.ajudacerteira.backendjava.repositories.EventoRepository;

@RestController
@CrossOrigin(origins = "*")
public class EventoController {
    
    @Autowired
    private EventoRepository repository;

    @GetMapping
    public List<Evento> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Evento findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping
    public Evento saveEvento(@RequestBody Evento evento){
        return repository.save(evento);
    }
}