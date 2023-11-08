package com.poke.data.source.remote

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.network.PokeService
import com.poke.data.response.PokeResponse
import com.poke.data.response.PokeSpecieResponse
import javax.inject.Inject

class PokeRemoteDataSourceImpl @Inject constructor(private val service: PokeService) :
    PokeRemoteDataSource {
    override suspend fun getPoke(limit:Int, offset:Int): Either<ErrorFactory, PokeResponse> =
        try {
            val response = service.getPoke(limit = limit, offset = offset)
            when {
                response.isSuccessful -> Either.Right(checkNotNull(response.body()))
                else -> Either.Left(ErrorFactory(response.code()))
            }
        } catch (exception: Exception) {
            Either.Left(ErrorFactory(errorCode = exception.hashCode()))
        }

    override suspend fun getPokemonSpecies(idPoke: Int): Either<ErrorFactory, PokeSpecieResponse> =
        try {
            val response = service.getPokemonSpecies(idPoke)
            when {
                response.isSuccessful -> Either.Right(checkNotNull(response.body()))
                else -> Either.Left(ErrorFactory(response.code()))
            }
        } catch (exception: Exception) {
            Either.Left(ErrorFactory(errorCode = exception.hashCode()))
        }
}
