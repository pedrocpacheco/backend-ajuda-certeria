package com.ajudacerteira.backendjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ajudacerteira.backendjava.entities.Evento;
import com.ajudacerteira.backendjava.repositories.EventoRepository;

public class EventoService {
    
    @Autowired
    private EventoRepository repository;

    // Read
    @Transactional(readOnly = true)
    public List<Evento> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Evento findById(Long id){
        return repository.findById(id).get();
    }

    // Post
    @Transactional
    public Evento saveEvento(Evento evento){
        return repository.save(evento);
    }

    // Put
    @Transactional
    public Evento updateEvento(Long id, Evento evento){
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        evento.setId(id);
        return repository.save(evento);
    }

    // Delete
    @Transactional
    public void deleteEvento(Long id){
        repository.deleteById(id);
    }

}
