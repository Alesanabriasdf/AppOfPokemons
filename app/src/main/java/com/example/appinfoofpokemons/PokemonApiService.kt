package com.example.appinfoofpokemons

import com.example.appinfoofpokemons.model.GlobalDto
import com.example.appinfoofpokemons.service.PokemonService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PokemonApiService @Inject constructor(private val api: PokemonService){

    suspend fun getPokemons(): GlobalDto{
        return withContext(Dispatchers.IO){
            val call:Response<GlobalDto> = api.getPokemonList()

            call.body()!!
        }
    }
}