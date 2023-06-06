package com.ajudacerteira.backendjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajudacerteira.backendjava.entities.Ong;
import com.ajudacerteira.backendjava.services.OngService;

@RestController
@CrossOrigin(origins = "*")
public class OngController {
    
    @Autowired
    private OngService service;

    @GetMapping("/ongs")
    public List<Ong> findAll(){
        return service.findAll();
    }
//
    @GetMapping(value = "/ongs/{id}")
    public Ong findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/ongs")
    public Ong saveOng(@RequestBody Ong ong){
        return service.saveOng(ong);
    }

    @PutMapping("/ongs/{id}")
    public Ong updateOng(@PathVariable Long id, @RequestBody Ong ong){
        return service.updateOng(id, ong);
    }

    @DeleteMapping("/ongs/{id}")
    public void deleteOng(@PathVariable Long id){
        service.deleteOng(id);
    }
}

