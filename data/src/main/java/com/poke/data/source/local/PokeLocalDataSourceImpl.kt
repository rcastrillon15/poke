package com.poke.data.source.local

import com.poke.common.helper.Either
import com.poke.common.helper.ErrorFactory
import com.poke.data.db.PokeEntity
import com.poke.data.db.PokeLocalQuery
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokeLocalDataSourceImpl @Inject constructor(private val db: PokeLocalQuery) :
    PokeLocalDataSource {
    override suspend fun getPokemons(): Either<ErrorFactory, PokeEntity> =
        try {
            val response = withContext(Dispatchers.IO) { db.select() }
            when {
                response != null -> Either.Right(response)
                else -> Either.Left(ErrorFactory(errorCode = -2))
            }
        } catch (exception: Exception) {
            Either.Left(ErrorFactory())
        }

    override suspend fun insert(entity: PokeEntity) {
        db.insert(entity)
    }
}
