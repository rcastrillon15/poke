package com.poke.domain.usecase

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.domain.model.PokeModel

interface PokeUseCase {
    suspend fun getPoke(): Either<ErrorFactory, PokeModel>
}
