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

import com.ajudacerteira.backendjava.entities.Ong;
import com.ajudacerteira.backendjava.repositories.OngRepository;

@RestController
@CrossOrigin(origins = "*")
public class OngController {
    
    @Autowired
    private OngRepository repository;

    @GetMapping("/ongs")
    public List<Ong> findAll(){
        return repository.findAll();
    }
//
    @GetMapping(value = "/ongs/{id}")
    public Ong findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/ongs")
    public Ong saveOng(@RequestBody Ong ong){
        return repository.save(ong);
    }

    @PutMapping("/ongs/{id}")
    public Ong updateOng(@PathVariable Long id, @RequestBody Ong ong){
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        ong.setId(id);
        return repository.save(ong);
    }

    @DeleteMapping("/ongs/{id}")
    public void deleteOng(@PathVariable Long id){
        repository.deleteById(id);
    }
}

