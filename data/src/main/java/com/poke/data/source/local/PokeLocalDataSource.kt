package com.poke.data.source.local

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.db.PokeEntity

interface PokeLocalDataSource {
    suspend fun getPokemons(): Either<ErrorFactory, PokeEntity>

    suspend fun insert(entity: PokeEntity)
}