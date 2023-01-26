package com.example.appinfoofpokemons

import com.example.appinfoofpokemons.domain.PokemonApiService
import com.example.appinfoofpokemons.model.PokemonRaw
import com.example.appinfoofpokemons.model.database.PokemonDao
import com.example.appinfoofpokemons.service.PokemonsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class PokemonsRepositoryTest {

    @RelaxedMockK
    private lateinit var api: PokemonApiService

    @RelaxedMockK
    private lateinit var pokemonDao: PokemonDao

    private lateinit var repository: PokemonsRepository


    @Before
    fun setupTest(){
        MockKAnnotations.init(this)
        repository = PokemonsRepository(api, pokemonDao)
    }

    @Test
    fun listEmptyInDatabase()= runBlocking{
        //given
        coEvery { pokemonDao.getAllPokemon() } returns emptyList()
        coEvery { api.getPokemons() } returns listOf(PokemonRaw("pikachu","asd"))
        //then
        val list1 = repository.getAllPokemons()
        //when
        assert(list1.isNotEmpty())
    }



}