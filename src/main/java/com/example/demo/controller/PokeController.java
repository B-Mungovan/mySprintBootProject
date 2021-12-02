package com.example.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Poke;
import com.example.demo.service.PokeService;

@RestController

@SpringBootApplication
@RequestMapping(path = "/pokemon")
public class PokeController {

	private PokeService service;

	public PokeController(PokeService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Poke> createPoke(@RequestBody Poke poke) {
		ResponseEntity<Poke> response = new ResponseEntity<Poke>(this.service.createPokemon(poke), HttpStatus.CREATED);
		return response;
	}
}