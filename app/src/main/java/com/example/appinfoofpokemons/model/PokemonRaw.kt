package com.example.appinfoofpokemons.model

import com.example.appinfoofpokemons.database.PokemonListEntity
import com.google.gson.annotations.SerializedName

data class PokemonRaw(

    @SerializedName("name") val pokemonName: String,
    @SerializedName("url") val pokemonUrl: String
)

fun PokemonListEntity.changeToPokemonRaw() = PokemonRaw(pokemonName = pokemonName, pokemonUrl = pokemonUrl)

fun PokemonRaw.changeToPokemonEntity() = PokemonListEntity(pokemonName = pokemonName, pokemonUrl = pokemonUrl)