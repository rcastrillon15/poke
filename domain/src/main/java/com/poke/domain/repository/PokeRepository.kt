package com.poke.domain.repository

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.domain.model.PokeModel

interface PokeRepository {
    suspend fun getPoke(): Either<ErrorFactory, PokeModel>
}
