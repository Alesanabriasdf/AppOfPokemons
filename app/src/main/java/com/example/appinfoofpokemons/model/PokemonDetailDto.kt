package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailDto (
    @SerializedName("types") val pokemonTypes : List<Types>,
    @SerializedName("forms") val pokemonEvolutions : List<Forms>,
    @SerializedName("abilities") val pokemonSkills : List<Skills>,
    @SerializedName("moves") val pokemonMoves : List<Moves>

    )