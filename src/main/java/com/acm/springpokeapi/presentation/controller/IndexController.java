package com.acm.springpokeapi.presentation.controller;

import com.acm.springpokeapi.models.PokemonDTO;
import com.acm.springpokeapi.services.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    private final PokemonService pokemonService;
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    public IndexController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping(path = "/fetcher", method = RequestMethod.GET)
    public String indexController(Model model) {
        Map<String, Object> map = new HashMap<>();
        return "index";
    }

    @GetMapping("/envioinfo")
    public String enviarInfo(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        logger.info(name);
        PokemonDTO pokemon = pokemonService.fetchPokemon(name);
        if (pokemon == null) {
            model.addAttribute("error", "The pokemon doesnt exist, please try again.");
            return "error";
        }
        model.addAttribute("pokemon", pokemon);
        return "pokemon";
    }

}
