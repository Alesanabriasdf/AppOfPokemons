package com.example.appinfoofpokemons.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appinfoofpokemons.R
import com.example.appinfoofpokemons.model.Pokemon

class PokemonsAdapter (private val list: List<Pokemon>): RecyclerView.Adapter<PokemonsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsHolder {

        return PokemonsHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_for_each_pokemon, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonsHolder, position: Int) {
        holder.paintIt(list[position])
    }

    override fun getItemCount(): Int = list.size

}