package com.poke.data.source.remote

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.response.PokeResponse
import retrofit2.Response

interface PokeRemoteDataSource {
    suspend fun getPoke(): Either<ErrorFactory, PokeResponse>
}
