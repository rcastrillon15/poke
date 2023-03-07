package com.poke.domain.model

data class PokeModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<AbilityModel>
)

data class AbilityModel(
    val slot: Int,
    val is_hidden: Boolean,
    val ability: AbilityDetailModel
)

data class AbilityDetailModel(
    val name: String,
    val url: String
)