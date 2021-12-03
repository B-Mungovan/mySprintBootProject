package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.Poke;


	@Repository
	public interface PokeRepo extends JpaRepository<Poke, Integer>{

	}


