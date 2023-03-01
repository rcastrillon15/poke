package com.poke.data.source.remote

import com.poke.data.network.PokeService
import javax.inject.Inject

class PokeRemoteDataSourceImpl @Inject constructor(private val service: PokeService) :
    PokeRemoteDataSource {
}
