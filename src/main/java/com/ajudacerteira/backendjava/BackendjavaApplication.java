package com.ajudacerteira.backendjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ajudacerteira.backendjava.repositories.DoadorRepository;

@SpringBootApplication
public class BackendjavaApplication{

	@Autowired
	DoadorRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(BackendjavaApplication.class, args);
	}
}
