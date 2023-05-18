package com.poke.mapper

import com.poke.domain.entity.Poke
import com.poke.state.PokeState

fun Poke.toPokeState() = PokeState(
    count = count,
    next = next,
    results = results.map {
        PokeState.Result(
            name = it.name,
            url = it.url
        )
    }
)
