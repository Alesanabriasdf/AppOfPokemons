package com.example.appinfoofpokemons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appinfoofpokemons.GetAllPokemons
import com.example.appinfoofpokemons.model.PokemonDetail
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

    private val _pokemonDetail = MutableLiveData<PokemonDetail>()
    val pokemonDetail: LiveData<PokemonDetail> = _pokemonDetail

    private val _showError = MutableLiveData<Boolean>()
    val showError: LiveData<Boolean> = _showError

    fun getListOfPokemons(){
        viewModelScope.launch{
            _loading.postValue(true)
            try {
                _listOfPokemons.postValue(getAllPokemons.getFromRepository())
                _loading.postValue(false)
                //retirar loading
            } catch (e: Exception){
                _showError.postValue(true)
                //mostrar alguna pantalla de error
            }
        }
    }

    fun getDetailsOfPokemon(id: String){
        viewModelScope.launch{
            _loading.postValue(true)
            try {
                _pokemonDetail.postValue(getAllPokemons.getDetailOfPokemon(id))
                _loading.postValue(false)
                //retirar loading
            } catch (e: Exception){
                _showError.postValue(true)
                //mostrar alguna pantalla de error
            }
        }
    }

}