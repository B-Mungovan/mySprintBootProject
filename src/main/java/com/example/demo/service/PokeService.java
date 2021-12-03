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


public Poke getById(Integer id) {
	Optional<Poke> pokeToFind = this.repo.findById(id);
	Poke foundPoke = pokeToFind.get();
	return foundPoke;

}

public List<Poke> getAllPokemon() {
	return this.repo.findAll();
}
public Poke updatePoke(Poke poke, Integer id) {
	Optional<Poke> pokeToFind = this.repo.findById(id);
	Poke pokeToUpdate = pokeToFind.get();
	
	pokeToUpdate.setPokeLevel(poke.getPokeLevel());
	pokeToUpdate.setPokeName(poke.getPokeName());
	pokeToUpdate.setPokeNature(poke.getPokeNature());
	pokeToUpdate.setPokeType(poke.getPokeType());
	
	return this.repo.save(pokeToUpdate);
	
}
public boolean deletePokemon(Integer id) {
	this.repo.deleteById(id);
	boolean exists = this.repo.existsById(id);
	return !exists;
}

}