package com.poke.domain.usecase

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.domain.entity.Poke

interface PokeUseCase {
    suspend fun getPoke(): Either<ErrorFactory, Poke>
}
