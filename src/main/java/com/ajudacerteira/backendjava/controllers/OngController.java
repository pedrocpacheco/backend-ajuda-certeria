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

    @GetMapping(value = "/ongs/{id}")
    public Ong findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/ongs")
    public Ong saveOng(@RequestBody Ong ong){
        return repository.save(ong);
    }

    @DeleteMapping("/ongs/{id}")
    public void deleteOng(@PathVariable Long id){
        repository.deleteById(id);
    }
}

