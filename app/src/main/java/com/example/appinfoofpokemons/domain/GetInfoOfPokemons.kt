package com.example.appinfoofpokemons.domain

import com.example.appinfoofpokemons.service.PokemonsRepository
import com.example.appinfoofpokemons.model.PokemonDetail
import com.example.appinfoofpokemons.model.PokemonRaw
import javax.inject.Inject

class GetInfoOfPokemons @Inject constructor(private val repository: PokemonsRepository) {

    suspend fun getFromRepository(): List<PokemonRaw>{
        return  repository.getAllPokemons()
    }

    suspend fun getDetailOfPokemon(id: String):PokemonDetail{
        return repository.getDetailsOfPokemon(id)
    }

    suspend fun getPlacesOfThisPokemon(id:String): String{
        return repository.getPlacesOfThisPokemon(id)
    }

}