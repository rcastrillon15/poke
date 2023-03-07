package com.poke.mapper

import com.poke.domain.model.AbilityDetailModel
import com.poke.domain.model.AbilityModel
import com.poke.domain.model.PokeModel
import com.poke.state.AbilityDetailState
import com.poke.state.AbilityState
import com.poke.state.PokeState

fun PokeModel.toPokeState() = PokeState(
    id = id,
    name = name,
    height = height,
    weight = weight,
    abilities = abilities.map { it.toAbilityState() }
)

private fun AbilityModel.toAbilityState() = AbilityState(
    slot = slot,
    is_hidden = is_hidden,
    ability = ability.toAbilityDetailState()
)

private fun AbilityDetailModel.toAbilityDetailState() = AbilityDetailState(
    name = name,
    url = url
)
