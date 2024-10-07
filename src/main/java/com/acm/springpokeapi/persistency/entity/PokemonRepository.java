package com.acm.springpokeapi.persistency.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface PokemonRepository extends ListCrudRepository<Pokemon, Integer> {
}
