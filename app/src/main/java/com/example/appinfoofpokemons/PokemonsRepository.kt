package com.example.appinfoofpokemons

import com.example.appinfoofpokemons.database.PokemonDao
import com.example.appinfoofpokemons.model.PokemonDetail
import com.example.appinfoofpokemons.model.PokemonRaw
import com.example.appinfoofpokemons.model.changeToPokemonEntity
import com.example.appinfoofpokemons.model.changeToPokemonRaw
import javax.inject.Inject

class PokemonsRepository @Inject constructor(private val api: PokemonApiService, private val pokemonDao: PokemonDao){

    suspend fun getAllPokemons(): List<PokemonRaw>{
        val listFromDatabase = pokemonDao.getAllPokemon()
        if (listFromDatabase.isEmpty()){
            val listFromApi = api.getPokemons()
            pokemonDao.insertAllPokemon(listFromApi.map { it.changeToPokemonEntity() })
            return listFromApi
        } else{
            return listFromDatabase.map { it.changeToPokemonRaw() }
        }
    }

    suspend fun getDetailsOfPokemon(id:String): PokemonDetail{
        return api.getDetailOfPokemon(id)
    }
}