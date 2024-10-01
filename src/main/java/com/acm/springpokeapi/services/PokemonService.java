package com.acm.springpokeapi.services;

import com.acm.springpokeapi.models.PokemonDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;

@Service
public class PokemonService {

    private Logger logger = LoggerFactory.getLogger(PokemonService.class);

    @Value("${myapp.pokeapi.base}")
    private String pokeApiBaseUrl;

    private RestTemplate restTemplate;

    private HttpClient client;
    public PokemonService(@Autowired HttpClient client, @Autowired RestTemplate restTemplate) {
        this.client = client;
        this.restTemplate = restTemplate;
    }

    public PokemonDTO fetchPokemon(String name) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder str = new StringBuilder();
        str.append(pokeApiBaseUrl);
        logger.info(pokeApiBaseUrl);
        str.append("pokemon/");
        str.append(name);

        try{

            JsonElement request = restTemplate.getForObject(str.toString(), JsonElement.class);
            PokemonDTO pokemon = gson.fromJson(request,PokemonDTO.class);
            logger.info(pokemon.toString());
            return pokemon;

        } catch (HttpClientErrorException e) {
            logger.error("Error fetching Pokemon: ", e);
            return null;
        }

    }

}
