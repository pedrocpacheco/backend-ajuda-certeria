package com.ajudacerteira.backendjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajudacerteira.backendjava.entities.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Long>{

    Doador update(Long id, Doador doador);
    
}
