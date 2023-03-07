package com.poke.data.source.remote

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.network.PokeService
import com.poke.data.response.PokeResponse
import javax.inject.Inject

class PokeRemoteDataSourceImpl @Inject constructor(private val service: PokeService) :
    PokeRemoteDataSource {
    override suspend fun getPoke(): Either<ErrorFactory, PokeResponse> =
        try {
            val response = service.getPoke()
            when {
                response.isSuccessful -> {
                    Either.Right(checkNotNull(response.body()))
                }
                else -> {
                    Either.Left(ErrorFactory(response.code()))
                }
            }
        } catch (exception: Exception) {
            Either.Left(ErrorFactory(errorCode = exception.hashCode()))
        }
}
