package com.poke.domain.repository

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.domain.entity.Poke
import com.poke.domain.entity.PokeSpecie

interface PokeRepository {
    suspend fun getPoke(limit:Int, offset:Int): Either<ErrorFactory, Poke>
    suspend fun getPokemonSpecies(idPoke:Int): Either<ErrorFactory, PokeSpecie>
}
