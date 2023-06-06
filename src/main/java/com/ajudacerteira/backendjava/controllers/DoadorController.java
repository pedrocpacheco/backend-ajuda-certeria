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

import com.ajudacerteira.backendjava.entities.Doador;
import com.ajudacerteira.backendjava.services.DoadorService;

@RestController
@CrossOrigin(origins = "*")
public class DoadorController {
    
    @Autowired
    private DoadorService service;

    @GetMapping("/doadores")
    public List<Doador> findAll(){
        return service.findAll();
    }

    @GetMapping("/doadores/{id}")
    public Doador findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/doadores")
    public Doador saveDoador(@RequestBody Doador doador){
        return service.saveDoador(doador);
    }

    @PutMapping("/doadores/{id}")
    public void updateDoador(@PathVariable Long id, @RequestBody Doador doador){;
        service.updateDoador(id, doador);
    }

    @DeleteMapping("/doadores/{id}")
    public void deleteDoador(@PathVariable Long id){
        service.deleteDoador(id);
    }
}
