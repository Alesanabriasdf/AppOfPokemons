package com.example.appinfoofpokemons.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appinfoofpokemons.databinding.ViewForEachPokemonBinding
import com.example.appinfoofpokemons.model.PokemonRaw

class PokemonsHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ViewForEachPokemonBinding.bind(view)

    fun paintIt(pokemon: PokemonRaw) {

        with(binding) {
            textViewType.text = "Name: ${pokemon.pokemonName}"
        }
    }
}