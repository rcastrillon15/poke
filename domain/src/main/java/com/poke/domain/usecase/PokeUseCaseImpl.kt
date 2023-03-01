package com.poke.domain.usecase

import com.poke.domain.repository.PokeRepository
import javax.inject.Inject

class PokeUseCaseImpl @Inject constructor(private val repository: PokeRepository) : PokeUseCase {

}
