package com.ajudacerteira.backendjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajudacerteira.backendjava.entities.Doador;
import com.ajudacerteira.backendjava.repositories.DoadorRepository;

@RestController
@CrossOrigin(origins = "*")
public class DoadorController {
    
    @Autowired
    private DoadorRepository repository;

    @GetMapping("/doadores")
    public List<Doador> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/doadores/{id}")
    public Doador findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/doadores")
    public Doador saveDoador(@RequestBody Doador doador){
        Doador save = repository.save(doador);
        return save;
    }
}
