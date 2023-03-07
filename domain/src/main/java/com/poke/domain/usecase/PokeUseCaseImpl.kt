package com.poke.domain.usecase

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.domain.model.PokeModel
import com.poke.domain.repository.PokeRepository
import javax.inject.Inject

class PokeUseCaseImpl @Inject constructor(private val repository: PokeRepository) : PokeUseCase {
    override suspend fun getPoke(): Either<ErrorFactory, PokeModel> = repository.getPoke()
}
