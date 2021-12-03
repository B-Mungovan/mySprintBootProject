package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poke {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private Integer id;
	private int pokeLevel;
	private String pokeName;
	private String pokeNature;
	private String pokeType;
   
	public Poke() {
	}
	
	public Poke( Integer id, int pokeLevel, String pokeName, String pokeNature,String pokeType) {
		super();

		this.id = id;
		this.pokeLevel = pokeLevel;
		this.pokeName = pokeName;
		this.pokeNature = pokeNature;
		this.pokeType = pokeType;	
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPokeLevel() {
		return pokeLevel;
	}

	public void setPokeLevel(int pokeLevel) {
		this.pokeLevel = pokeLevel;
	}

	public String getPokeName() {
		return pokeName;
	}

	public void setPokeName(String pokeName) {
		this.pokeName = pokeName;
	}

	public String getPokeNature() {
		return pokeNature;
	}

	public void setPokeNature(String pokeNature) {
		this.pokeNature = pokeNature;
	}

	public String getPokeType() {
		return pokeType;
	}

	public void setPokeType(String pokeType) {
		this.pokeType = pokeType;
	}
}
		