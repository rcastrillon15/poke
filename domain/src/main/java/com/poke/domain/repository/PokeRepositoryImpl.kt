package com.poke.domain.repository

import com.poke.common.NetworkMonitor
import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.source.remote.PokeRemoteDataSource
import com.poke.domain.entity.Poke
import com.poke.domain.entity.PokeSpecie
import com.poke.domain.mapper.toModel
import javax.inject.Inject

class PokeRepositoryImpl @Inject constructor(private val remoteDataSource: PokeRemoteDataSource) :
    PokeRepository {
    override suspend fun getPoke(limit: Int, offset: Int): Either<ErrorFactory, Poke> {
        return if (NetworkMonitor().isConnected())
            when (val response = remoteDataSource.getPoke(limit = limit, offset = offset)) {
                is Either.Right -> Either.Right(response.r.toModel())
                is Either.Left -> Either.Left(response.l)
            }
        else Either.Left(ErrorFactory(errorCode = 0))
    }

    override suspend fun getPokemonSpecies(idPoke: Int): Either<ErrorFactory, PokeSpecie> {
        return if (NetworkMonitor().isConnected())
            when (val response = remoteDataSource.getPokemonSpecies(idPoke)) {
                is Either.Right -> Either.Right(response.r.toModel())
                is Either.Left -> Either.Left(response.l)
            }
        else Either.Left(ErrorFactory(errorCode = 0))
    }
}
