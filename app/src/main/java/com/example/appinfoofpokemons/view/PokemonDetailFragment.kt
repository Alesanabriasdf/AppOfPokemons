package com.example.appinfoofpokemons.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appinfoofpokemons.R
import com.example.appinfoofpokemons.databinding.FragmentPokemonDetailBinding
import com.example.appinfoofpokemons.viewmodel.ViewModelPokemon
import com.squareup.picasso.Picasso


class PokemonDetailFragment: Fragment(R.layout.fragment_pokemon_detail),
    PopupMenu.OnMenuItemClickListener {

    private lateinit var binding: FragmentPokemonDetailBinding

    private val viewModelPokemon: ViewModelPokemon by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPokemonDetailBinding.bind(view)

        setupUI()

        setPopUpMenu()

    }

    private fun setPopUpMenu() {
        binding.imageViewPokemon.setOnClickListener {
            val menu = PopupMenu(requireContext(),binding.imageViewPokemon)
            menu.setOnMenuItemClickListener(this)
            menu.menuInflater.inflate(R.menu.menu_pop_up, menu.menu)
            menu.show()
        }
    }

    private fun setupUI() {

        val id = arguments?.getString("id")

        viewModelPokemon.getDetailsOfPokemon(id!!)

        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png").into(binding.imageViewPokemon)

        viewModelPokemon.pokemonDetail.observe(viewLifecycleOwner){
            with(binding){
                textViewType.text= "Type: ${it.type}"
                textViewEvolution.text= "Evolution ${it.evolution}"
                textViewAttack.text= "Attack: ${it.attack}"
                textViewSkills.text = "Skill: ${it.skill}"
                //textViewPlaces
            }
        }
    }

    override fun onMenuItemClick(p0: MenuItem): Boolean {

        val id = arguments?.getString("id")

        when(p0.itemId){
            R.id.findIt ->{
                BottomSheetPlacesFragment().show(childFragmentManager,"show bottom sheet")
                viewModelPokemon.getPlacesPokemon(id!!)
                return true
            }
            R.id.close ->{
                return false
            }
        }
        return false
    }
}