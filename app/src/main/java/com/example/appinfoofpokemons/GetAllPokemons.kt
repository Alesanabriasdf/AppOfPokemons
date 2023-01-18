package com.example.appinfoofpokemons

import com.example.appinfoofpokemons.model.PokemonRaw
import javax.inject.Inject

class GetAllPokemons @Inject constructor(private val repository: PokemonsRepository) {

    suspend fun getFromRepository(): List<PokemonRaw>{
        return  repository.getAllPokemons()
    }

}