package com.ajudacerteira.backendjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ajudacerteira.backendjava.entities.Ong;
import com.ajudacerteira.backendjava.repositories.OngRepository;

public class OngService {
    
    @Autowired
    private OngRepository repository;

    // Read
    @Transactional(readOnly = true)
    public List<Ong> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Ong findById(Long id){
        return repository.findById(id).get();
    }

    // Post
    @Transactional
    public Ong saveOng(Ong ong){
        return repository.save(ong);
    }

    // Put
    @Transactional
    public Ong updateOng(Long id, Ong ong){
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        ong.setId(id);
        return repository.save(ong);
    }

    // Delete
    @Transactional
    public void deleteOng(Long id){
        repository.deleteById(id);
    }

}
