package com.ajudacerteira.backendjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ajudacerteira.backendjava.entities.Doador;
import com.ajudacerteira.backendjava.repositories.DoadorRepository;

public class DoadorService {
    
    @Autowired
    private DoadorRepository repository;

    // Read
    @Transactional(readOnly = true)
    public List<Doador> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Doador findById(Long id){
        return repository.findById(id).get();
    }

    // Post
    @Transactional
    public Doador saveDoador(Doador doador){
        return repository.save(doador);
    }

    // Put
    @Transactional
    public Doador updateDoador(Long id, Doador doador){
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        doador.setId(id);
        return repository.save(doador);
    }

    // Delete
    @Transactional
    public void deleteDoador(Long id){
        repository.deleteById(id);
    }

}
