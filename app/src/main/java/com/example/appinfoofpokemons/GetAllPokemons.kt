package com.example.appinfoofpokemons

import com.example.appinfoofpokemons.model.PokemonDetail
import com.example.appinfoofpokemons.model.PokemonRaw
import javax.inject.Inject

class GetAllPokemons @Inject constructor(private val repository: PokemonsRepository) {

    suspend fun getFromRepository(): List<PokemonRaw>{
        return  repository.getAllPokemons()
    }

    suspend fun getDetailOfPokemon(id: String):PokemonDetail{
        return repository.getDetailsOfPokemon(id)
    }

}