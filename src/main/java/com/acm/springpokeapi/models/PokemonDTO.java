package com.acm.springpokeapi.models;

import com.google.gson.annotations.SerializedName;

public record PokemonDTO(
        @SerializedName("id") int id,
        @SerializedName("name") String name,
        @SerializedName("height")  int height,
        @SerializedName("weight") int weight) {
}
