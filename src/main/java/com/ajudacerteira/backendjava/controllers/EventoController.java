package com.ajudacerteira.backendjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/eventos")
    public List<Evento> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/eventos/{id}")
    public Evento findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/eventos")
    public Evento saveEvento(@RequestBody Evento evento){
        Evento save = repository.save(evento);
        return save;
    }

    @DeleteMapping("/eventos/{id}")
    public void deleteEvento(@PathVariable Long id){
        repository.deleteById(id);
    }

}