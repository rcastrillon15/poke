package com.poke.domain.mapper

import com.poke.data.response.PokeResponse
import com.poke.domain.entity.Poke

fun PokeResponse.toPokeModel() = Poke(
    count = count,
    next = next,
    results = results.map {
        Poke.Result(
            name = it.name,
            url = it.url
        )
    }
)
