package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class GlobalDto(

    @SerializedName("results") val listOfPokemons : List<PokemonRaw> ? = emptyList()
)