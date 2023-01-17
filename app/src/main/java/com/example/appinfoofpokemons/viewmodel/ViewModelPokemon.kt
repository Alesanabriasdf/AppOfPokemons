package com.example.appinfoofpokemons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appinfoofpokemons.GetAllPokemons
import com.example.appinfoofpokemons.model.PokemonRaw
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelPokemon @Inject constructor(private val getAllPokemons: GetAllPokemons) : ViewModel(){

    private val _listOfPokemons = MutableLiveData<List<PokemonRaw>>()
    val listOfPokemons: LiveData<List<PokemonRaw>> = _listOfPokemons

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getListOfPokemons(){
        viewModelScope.launch{
            _loading.postValue(true)
            try {
                _listOfPokemons.postValue(getAllPokemons.invoke())
            } catch (e: Exception){

            }
        }
    }





}