package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class Skill(
    @SerializedName("name") val pokemonNameSkill: String
)
