package com.example.appinfoofpokemons.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_list_table")
data class PokemonListEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int=0,
    @ColumnInfo(name = "name") val pokemonName: String,
    @ColumnInfo(name = "url") val pokemonUrl: String
)