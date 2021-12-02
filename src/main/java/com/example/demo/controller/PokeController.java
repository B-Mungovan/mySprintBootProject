package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	

	@GetMapping("/getAll")
	ResponseEntity<List<Poke>> get() {
    ResponseEntity<List<Poke>> response = new ResponseEntity<List<Poke>>(this.service.getAllPokemon(), HttpStatus.OK);
    return response;
    }

	@GetMapping("{id}")
	public ResponseEntity<Poke> getById(@PathVariable Integer id) {
		return new ResponseEntity<Poke>(this.service.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Poke> updatePoke(@PathVariable Integer id, @RequestBody Poke poke) {
	ResponseEntity<Poke> response = new ResponseEntity<Poke>(this.service.updatePoke(poke, id), HttpStatus.ACCEPTED);
	return response;	
	}
	
	
	
}






