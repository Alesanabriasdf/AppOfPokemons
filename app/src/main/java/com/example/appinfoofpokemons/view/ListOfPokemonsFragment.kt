package com.example.appinfoofpokemons.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appinfoofpokemons.R
import com.example.appinfoofpokemons.databinding.FragmentListOfPokemonsBinding
import com.example.appinfoofpokemons.viewmodel.ViewModelPokemon
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListOfPokemonsFragment : Fragment(R.layout.fragment_list_of_pokemons) {

    private lateinit var binding: FragmentListOfPokemonsBinding

    private val viewModelPokemon: ViewModelPokemon by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListOfPokemonsBinding.bind(view)

        viewModelPokemon.getListOfPokemons()

        viewModelPokemon.listOfPokemons.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()){
                binding.rvForAllPokemons.adapter = PokemonsAdapter(it)
            }
        }
    }

}