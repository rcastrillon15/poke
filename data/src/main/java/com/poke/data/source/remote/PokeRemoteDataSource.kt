package com.poke.data.source.remote

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.response.PokeResponse
import com.poke.data.response.PokeSpecieResponse

interface PokeRemoteDataSource {
    suspend fun getPoke(limit:Int, offset:Int): Either<ErrorFactory, PokeResponse>
    suspend fun getPokemonSpecies(idPoke:Int): Either<ErrorFactory, PokeSpecieResponse>
}
