package com.example.appinfoofpokemons

import com.example.appinfoofpokemons.model.*
import com.example.appinfoofpokemons.service.PokemonService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PokemonApiService @Inject constructor(private val api: PokemonService){

    suspend fun getPokemons(): List<PokemonRaw>{
        return withContext(Dispatchers.IO){
            val call:Response<GlobalDto> = api.getPokemonList()

            call.body()?.listOfPokemons!!
        }
    }

    suspend fun getDetailOfPokemon(id:String): PokemonDetail{
        return withContext(Dispatchers.IO){
            val call:Response<PokemonDetailDto> = api.getDetailOfPokemon("pokemon/$id/")

            var types = ""
            var evolutions = ""
            var attacks = ""
            var abilities = ""

            call.body()?.pokemonTypes?.forEach {
                if (it.pokemonType.pokemonTypeFinal.isNotEmpty()){
                    types += "${it.pokemonType.pokemonTypeFinal} "
                }
            }
            call.body()?.pokemonEvolutions?.forEach {
                if (it.pokemonEvolution.isNotEmpty()){
                    evolutions += "${it.pokemonEvolution} "
                }
            }
            call.body()?.pokemonMoves?.forEach {
                if (it.pokemonMove.pokemonMove.isNotEmpty()){
                    attacks += "${it.pokemonMove.pokemonMove}, "
                }
            }

            call.body()?.pokemonSkills?.forEach {
                if (it.pokemonSkill.pokemonNameSkill.isNotEmpty()){
                    abilities += "${it.pokemonSkill.pokemonNameSkill}, "
                }
            }

            val pokemonDetail = PokemonDetail( types,evolutions,attacks,abilities)

            pokemonDetail
        }
    }

    suspend fun getPlacesOfThisPokemon(id:String):String{
        return withContext(Dispatchers.IO){
            val call:Response<List<GlobalPlacesDto>> = api.getPlacesOfThisPokemon("pokemon/$id/encounters")

            var places = ""

            call.body()?.forEach {
                if (it.locationArea.locationArea.isNotBlank()){
                    places += "${it.locationArea.locationArea}, "
                }
            }

            places
        }
    }
}