package com.example.appinfoofpokemons.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appinfoofpokemons.databinding.ViewForEachPokemonBinding
import com.example.appinfoofpokemons.model.Pokemon

class PokemonsHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ViewForEachPokemonBinding.bind(view)

    fun paintIt(pokemon: Pokemon) {

        with(binding) {
            textViewType.text = "Type: ${pokemon.type}"
            textViewEvolution.text = "Evolution: ${pokemon.evolution}"
            textViewAttack.text = "Attack: ${pokemon.attack}"
            textViewSkill.text= "Skill: ${pokemon.skill}"
            textViewPlace.text = "Place: ${pokemon.place}"
        }
    }
}