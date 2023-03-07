package com.poke.domain.repository

import com.poke.common.NetworkMonitor
import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.source.remote.PokeRemoteDataSource
import com.poke.domain.mapper.toPokeModel
import com.poke.domain.model.PokeModel
import javax.inject.Inject

class PokeRepositoryImpl @Inject constructor(private val remoteDataSource: PokeRemoteDataSource) :
    PokeRepository {
    override suspend fun getPoke(): Either<ErrorFactory, PokeModel> {
        if (NetworkMonitor().isConnected()) {
            return when (val response = remoteDataSource.getPoke()) {
                is Either.Right -> {
                    Either.Right(response.r.toPokeModel())
                }
                is Either.Left -> {
                    Either.Left(response.l)
                }
            }
        } else {
            return  Either.Left(ErrorFactory(errorCode = 0))
        }
    }
}
