package com.example.appinfoofpokemons.service

class AppConstants {

    companion object{
        const val BASE_URL = "https://pokeapi.co/api/v2/"
        const val END_POINT_LIST_POKEMONS = "pokemon?limit=151&offset=0"
        const val END_POINT_POKEMON_DETAIL = "pokemon/{id}/"
    }

}