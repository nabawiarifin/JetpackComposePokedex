package com.plcoding.jetpackcomposepokedex.data.remote

import com.plcoding.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.plcoding.jetpackcomposepokedex.data.remote.responses.PokemonLists
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    // Load Pokemons in one page
    @GET("pokemon")
    suspend fun getPokemonLists(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonLists //Return list of pokemons

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon //Return pokemon

}