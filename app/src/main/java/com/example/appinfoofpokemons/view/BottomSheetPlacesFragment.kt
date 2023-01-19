package com.example.appinfoofpokemons.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.appinfoofpokemons.databinding.FragmentBottomSheetPlacesBinding
import com.example.appinfoofpokemons.viewmodel.ViewModelPokemon
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetPlacesFragment : BottomSheetDialogFragment() {

    private val viewModelPokemon: ViewModelPokemon by activityViewModels()

    private lateinit var binding: FragmentBottomSheetPlacesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBottomSheetPlacesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()

    }

    private fun setupUI() {
        viewModelPokemon.pokemonPlaces.observe(viewLifecycleOwner){
            if (it.isEmpty()){
                binding.textViewForPlaces.text = "no places for now..."
            } else{
                binding.textViewForPlaces.text = it
            }
        }
    }

}