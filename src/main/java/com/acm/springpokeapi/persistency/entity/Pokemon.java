package com.acm.springpokeapi.persistency.entity;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {

    private int id;
    private String name;
    private int height;
    private int weight;

}
