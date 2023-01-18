package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class Skills(
    @SerializedName("ability") val pokemonSkill: Skill
)