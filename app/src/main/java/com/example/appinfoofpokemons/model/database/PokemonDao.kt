package com.example.appinfoofpokemons.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon_list_table")
    suspend fun getAllPokemon(): List<PokemonListEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllPokemon(listOfAllPokemon: List<PokemonListEntity>)

}