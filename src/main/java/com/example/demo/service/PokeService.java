package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.data.Poke;
import com.example.demo.repo.PokeRepo;

@Service
public class PokeService {
	private PokeRepo repo;

	public PokeService(PokeRepo repo) {
		this.repo = repo;
	}

public Poke createPokemon(Poke poke) {
	return this.repo.save(poke);
	
}

public List<Poke> getAllPokemon() {
	return this.repo.findAll();
}
public Poke getById(Integer id) {
	Optional<Poke> pokeToFind = this.repo.findById(id);
	Poke foundPoke = pokeToFind.get();
	return foundPoke;

}


}