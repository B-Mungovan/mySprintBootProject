package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Poke {
	private static int ID_COUNTER = 0;

	@Id
	private int id;
	private String pokeName;
	private int pokeLevel;
	private String pokeType;
	private String pokeNature;

	public Poke() {
	}
	public Poke(String pokeName, int pokeLevel, String pokeType, String pokeNature) {
		super();

		this.id = ID_COUNTER++;
		this.pokeLevel = pokeLevel;
		this.pokeName = pokeName;
		this.pokeNature = pokeNature;
		this.pokeType = pokeType;
		}
		public Poke(int id, String pokeName, int pokeLevel, String pokeType, String pokeNature) {
		super();

		this.id = id;
		this.pokeLevel = pokeLevel;
		this.pokeName = pokeName;
		this.pokeNature = pokeNature;
		this.pokeType = pokeType;

		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPokeName() {
			return pokeName;
		}
		public void setPokeName(String pokeName) {
			this.pokeName = pokeName;
		}
		public int getPokeLevel() {
			return pokeLevel;
		}
		public void setPokeLevel(int pokeLevel) {
			this.pokeLevel = pokeLevel;
		}
		public String getPokeType() {
			return pokeType;
		}
		public void setPokeType(String pokeType) {
			this.pokeType = pokeType;
		}
		public String getPokeNature() {
			return pokeNature;
		}
		public void setPokeNature(String pokeNature) {
			this.pokeNature = pokeNature;
		}
		
}
