package com.example.appinfoofpokemons.service

import com.example.appinfoofpokemons.model.GlobalDto
import retrofit2.Response
import retrofit2.http.GET

interface PokemonService {
    @GET(AppConstants.END_POINT_LIST_POKEMONS)
    suspend fun getPokemonList(): Response<GlobalDto>
}