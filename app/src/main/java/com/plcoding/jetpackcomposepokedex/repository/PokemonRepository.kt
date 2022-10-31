package com.plcoding.jetpackcomposepokedex.repository

import androidx.compose.ui.tooling.inspector.ParameterType
import com.plcoding.jetpackcomposepokedex.data.remote.PokemonApi
import com.plcoding.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.plcoding.jetpackcomposepokedex.data.remote.responses.PokemonLists
import com.plcoding.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

//Will be injected into ViewModel

@ActivityScoped //Will live as long as the activity does
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
){
    suspend fun getPokemonLists(limit: Int, offset: Int): Resource<PokemonLists> {
        val response = try {
            api.getPokemonLists(limit, offset)
        } catch(e: Exception) {
            return Resource.Error(message = "An error has occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            return Resource.Error(message = "An error has occured")
        }
        return Resource.Success(response)
    }
}