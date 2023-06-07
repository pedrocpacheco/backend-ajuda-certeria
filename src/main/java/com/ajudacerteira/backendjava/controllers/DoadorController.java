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

import com.ajudacerteira.backendjava.entities.Doador;
import com.ajudacerteira.backendjava.repositories.DoadorRepository;

@RestController
@CrossOrigin(origins = "*")
public class DoadorController {
// Link do Endpoint Funcional: https://backend-ajuda-certeria-production.up.railway.app/doadores
    
    @Autowired
    private DoadorRepository repository;

    // Encontra e retorna todos os Doadores cadastrados -> GET
    @GetMapping("/doadores")
    public List<Doador> findAll(){
        return repository.findAll();
    }

    // Encontra e retorna o Doador com ID igual ao ID passado na requisição -> GET
    @GetMapping("/doadores/{id}")
    public Doador findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    // Adiciona um novo Doador, este, deve ser passado no corpo da requisição -> POST
    @PostMapping("/doadores")
    public Doador saveDoador(@RequestBody Doador doador){
        return repository.save(doador);
    }

    // Atualiza um Doador existente. É necessario passar o id do Doador que deseja atualizar, e o seu novo corpo -> PUT
    @PutMapping("/doadores/{id}")
    public Doador updateDoador(@PathVariable Long id, @RequestBody Doador doador){
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        doador.setId(id);
        return repository.save(doador);
    }

    @DeleteMapping("/doadores/{id}")
    public void deleteDoador(@PathVariable Long id){
        repository.deleteById(id);
    }
}
