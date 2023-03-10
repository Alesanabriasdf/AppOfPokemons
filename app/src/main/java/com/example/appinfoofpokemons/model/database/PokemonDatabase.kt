package com.example.appinfoofpokemons.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PokemonListEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun getPokemonDao(): PokemonDao
}