package com.poke.data.network

import com.poke.common.Constants.METHOD_GET_POKEMON
import com.poke.common.Constants.METHOD_GET_POKEMON_SPECIES
import com.poke.data.response.PokeResponse
import com.poke.data.response.PokeSpecieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeService {
    @GET(METHOD_GET_POKEMON)
    suspend fun getPoke(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokeResponse>

    @GET("$METHOD_GET_POKEMON_SPECIES{idPoke}")
    suspend fun getPokemonSpecies(
        @Path("idPoke") idPoke: Int
    ): Response<PokeSpecieResponse>
}
