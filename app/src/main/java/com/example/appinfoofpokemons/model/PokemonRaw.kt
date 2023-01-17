package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class PokemonRaw(

    @SerializedName("name") val pokemonName: String,
    @SerializedName("url") val pokemonUrl: String
)