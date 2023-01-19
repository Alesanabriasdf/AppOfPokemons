package com.example.appinfoofpokemons.model

import com.google.gson.annotations.SerializedName

data class GlobalPlacesDto (

    @SerializedName("location_area") val locationArea : LocationArea

        )