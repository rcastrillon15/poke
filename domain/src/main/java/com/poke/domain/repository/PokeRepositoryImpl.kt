package com.poke.domain.repository

import com.poke.data.source.remote.PokeRemoteDataSource
import javax.inject.Inject

class PokeRepositoryImpl @Inject constructor(private val remoteDataSource: PokeRemoteDataSource) :
    PokeRepository {

}
