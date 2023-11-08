package com.poke.domain.usecase

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.domain.entity.Poke
import com.poke.domain.entity.PokeSpecie

interface PokeUseCase {
    suspend fun getPoke(limit:Int, offset:Int): Either<ErrorFactory, Poke>
    suspend fun getPokemonSpecies(idPoke:Int): Either<ErrorFactory, PokeSpecie>
}
