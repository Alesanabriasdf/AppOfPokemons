package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class Move(

    @SerializedName("name") val pokemonMove : String
)
