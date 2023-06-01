package com.ajudacerteira.backendjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajudacerteira.backendjava.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
    
}
