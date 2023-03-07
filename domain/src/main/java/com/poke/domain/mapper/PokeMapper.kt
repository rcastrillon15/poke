package com.poke.domain.mapper

import com.poke.data.response.AbilityDetailResponse
import com.poke.data.response.AbilityResponse
import com.poke.data.response.PokeResponse
import com.poke.domain.model.AbilityDetailModel
import com.poke.domain.model.AbilityModel
import com.poke.domain.model.PokeModel

fun PokeResponse.toPokeModel() = PokeModel(
    id = id,
    name = name,
    height = height,
    weight = weight,
    abilities = abilities.map { it.toAbilityModel() }
)

private fun AbilityResponse.toAbilityModel() = AbilityModel(
    slot = slot,
    is_hidden = is_hidden,
    ability = ability.toAbilityDetailModel()
)

private fun AbilityDetailResponse.toAbilityDetailModel() = AbilityDetailModel(
    name = name,
    url = url
)