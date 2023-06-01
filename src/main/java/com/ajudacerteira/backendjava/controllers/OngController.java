package com.ajudacerteira.backendjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajudacerteira.backendjava.entities.Ong;
import com.ajudacerteira.backendjava.repositories.OngRepository;

@RestController
@RequestMapping(value = "/ongs")
public class OngController {
    
    @Autowired
    private OngRepository repository;

    @GetMapping
    public List<Ong> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Ong findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping
    public Ong saveOng(@RequestBody Ong ong){
        return repository.save(ong);
    }

}

