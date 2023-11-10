package com.poke.data.mapper

import com.poke.data.db.PokeEntity
import com.poke.data.response.PokeResponse

fun PokeResponse.toEntity() = PokeEntity(
    count = count,
    next = next,
    results = results.map { PokeEntity.Result(
        name = it.name,
        url = it.url
    ) }
)