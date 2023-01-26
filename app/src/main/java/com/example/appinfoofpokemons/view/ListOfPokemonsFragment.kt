package com.example.appinfoofpokemons.view

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appinfoofpokemons.R
import com.example.appinfoofpokemons.databinding.FragmentListOfPokemonsBinding
import com.example.appinfoofpokemons.model.PokemonRaw
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

        filterListByName()

        setList()

    }

    private fun setList() {
        viewModelPokemon.listOfPokemons.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()){
                binding.rvForAllPokemons.adapter = PokemonsAdapter(it)
            }
        }
    }

    private fun filterListByName(){
        binding.editTextSearch.addTextChangedListener { name ->

            val newList = mutableListOf<PokemonRaw>()
            viewModelPokemon.listOfPokemons.observe(viewLifecycleOwner){ listOfAllPokemons ->

                if (!name.isNullOrEmpty()){
                    listOfAllPokemons.forEach {

                        if (it.pokemonName.lowercase().contains(name.toString().lowercase())){
                            newList.add(it)
                        }
                        binding.rvForAllPokemons.adapter = PokemonsAdapter(newList)
                        if (newList.isEmpty()){
                            binding.tvNoInfo.text="No encontramos pokemons con ese nombre..."
                        } else {
                            binding.tvNoInfo.text=""
                        }
                    }
                } else {
                    binding.tvNoInfo.text=""
                    binding.rvForAllPokemons.adapter= PokemonsAdapter(listOfAllPokemons)
                }
            }
        }
    }
}