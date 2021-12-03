package com.example.demo.controllers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.example.demo.data.Poke;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:test-schema.sql", "classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class PokemonControllerIntegrationTests {

	//private static final ResultMatcher status = null;

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test 
	void getAllPokemonTest() throws Exception{
		String ListOfPokemonJSON = this.mapper.writeValueAsString(List.of(
				new Poke(1, 70, "Rayquaza", "Dragon Flying", "Brave"),
				new Poke(2, 12,"Charmander", "Fire", "Timid")
				));
		
		RequestBuilder request = get("/pokemon/getAll");
		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(ListOfPokemonJSON);
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	@Test
	void createPokemonTest() throws Exception {
		String testPokemonAsJson = this.mapper.writeValueAsString(
				new Poke(null, 13,"Bidoof", "Normal", "Sassy" ));
		String testPokemonAsJsonResponse = this.mapper.writeValueAsString(
				new Poke(3, 13,"Bidoof", "Normal", "Sassy" ));
		
		RequestBuilder request = post("/pokemon/create").contentType(MediaType.APPLICATION_JSON).content(testPokemonAsJson);
		ResultMatcher status = status().isCreated();
		ResultMatcher content = content().json(testPokemonAsJsonResponse);
		this.mvc.perform(request).andExpect(status).andExpect(content);
}
	@Test 
	void deletePokemonTest() throws Exception {
		this.mvc.perform(delete("/pokemon/delete/1")).andExpect(status().isOk());
	}
	@Test 
	void updatePokemonTest() throws Exception {
		String updatedPokemonAsJson = this.mapper.writeValueAsString(new Poke(1, 70, "Rayquaza", "Dragon Flying", "Brave"));
		RequestBuilder request = put("/pokemon/update/1").contentType(MediaType.APPLICATION_JSON).content(updatedPokemonAsJson);
		ResultMatcher status = status().isAccepted();
		ResultMatcher content = content().json(updatedPokemonAsJson);
		this.mvc.perform(request).andExpect(status).andExpect(content);
		}
	@Test 
	void getByIdPokemonTest() throws Exception {
		String foundPokemonJSON = this.mapper.writeValueAsString(
				new Poke(1, 70, "Rayquaza", "Dragon Flying", "Brave"));
		
		RequestBuilder request = get("/pokemon/1");
		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(foundPokemonJSON);
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	}
	
