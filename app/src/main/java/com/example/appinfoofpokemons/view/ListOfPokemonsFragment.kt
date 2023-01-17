package com.example.appinfoofpokemons.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.appinfoofpokemons.R
import com.example.appinfoofpokemons.databinding.FragmentListOfPokemonsBinding

class ListOfPokemonsFragment : Fragment(R.layout.fragment_list_of_pokemons) {

    private lateinit var binding: FragmentListOfPokemonsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListOfPokemonsBinding.bind(view)

        binding.rvForAllIngredients.adapter = PokemonsAdapter(emptyList())

    }

}