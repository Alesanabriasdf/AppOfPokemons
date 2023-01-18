package com.example.appinfoofpokemons

import com.example.appinfoofpokemons.model.PokemonRaw
import javax.inject.Inject

class PokemonsRepository @Inject constructor(private val api: PokemonApiService){

    suspend fun getAllPokemons(): List<PokemonRaw>{
        return api.getPokemons()
    }
}