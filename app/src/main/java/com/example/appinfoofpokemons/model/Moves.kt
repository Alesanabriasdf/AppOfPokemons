package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class Moves(
    @SerializedName("move") val pokemonMove : Move
)
