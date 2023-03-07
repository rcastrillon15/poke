package com.poke.data.response

data class PokeResponse(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<AbilityResponse>
)

data class AbilityResponse(
    val slot: Int,
    val is_hidden: Boolean,
    val ability: AbilityDetailResponse
)

data class AbilityDetailResponse(
    val name: String,
    val url: String
)
