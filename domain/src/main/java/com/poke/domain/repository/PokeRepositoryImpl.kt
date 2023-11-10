package com.poke.domain.repository

import com.poke.common.NetworkMonitor
import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.mapper.toEntity
import com.poke.data.source.local.PokeLocalDataSource
import com.poke.data.source.remote.PokeRemoteDataSource
import com.poke.domain.entity.Poke
import com.poke.domain.entity.PokeSpecie
import com.poke.domain.mapper.toModel
import javax.inject.Inject

class PokeRepositoryImpl @Inject constructor(private val remoteDataSource: PokeRemoteDataSource, private val local: PokeLocalDataSource) :
    PokeRepository {
    override suspend fun getPoke(limit: Int, offset: Int): Either<ErrorFactory, Poke> {
        return if (NetworkMonitor().isConnected()) {
            when (val response = remoteDataSource.getPoke(limit, offset)) {
                is Either.Right -> {
                    local.insert(response.r.toEntity())
                    Either.Right(response.r.toModel())
                }

                is Either.Left -> Either.Left(response.l)
            }
        } else {
            when (val response = local.getPokemons()) {
                is Either.Right -> Either.Right(response.r.toModel())
                is Either.Left -> Either.Left(response.l)
            }
        }
    }

    override suspend fun getPokemonSpecies(idPoke: Int): Either<ErrorFactory, PokeSpecie> {
        return if (NetworkMonitor().isConnected())
            when (val response = remoteDataSource.getPokemonSpecies(idPoke)) {
                is Either.Right -> Either.Right(response.r.toModel())
                is Either.Left -> Either.Left(response.l)
            }
        else Either.Left(ErrorFactory(errorCode = -2)) //TODO: Get real error code
    }
}
