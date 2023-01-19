package com.example.appinfoofpokemons.service

import com.example.appinfoofpokemons.model.GlobalDto
import com.example.appinfoofpokemons.model.GlobalPlacesDto
import com.example.appinfoofpokemons.model.PokemonDetailDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonService {
    @GET(AppConstants.END_POINT_LIST_POKEMONS)
    suspend fun getPokemonList(): Response<GlobalDto>

    @GET
    suspend fun getDetailOfPokemon(@Url urlById:String): Response<PokemonDetailDto>

    @GET
    suspend fun getPlacesOfThisPokemon(@Url urlByIdToGetPlaces: String): Response<List<GlobalPlacesDto>>
}