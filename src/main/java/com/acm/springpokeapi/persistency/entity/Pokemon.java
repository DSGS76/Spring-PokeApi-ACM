package com.acm.springpokeapi.persistency.entity;

import com.acm.springpokeapi.models.PokemonDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pokemon {

    @Id
    private int id;
    private String name;
    private int height;
    private int weight;

}
