package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class Types(

    @SerializedName("type") val pokemonType : Type

)
