package com.acm.springpokeapi;

import com.acm.springpokeapi.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPokeApiApplication implements CommandLineRunner {

    private PokemonService pokemonService;

    public SpringPokeApiApplication(@Autowired PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringPokeApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
