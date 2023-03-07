package com.poke.state

data class PokeState(
    val id: Int = 0,
    val name: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val abilities: List<AbilityState> = emptyList()
)

data class AbilityState(
    val slot: Int = 0,
    val is_hidden: Boolean = false,
    val ability: AbilityDetailState = AbilityDetailState()
)

data class AbilityDetailState(
    val name: String = "",
    val url: String = ""
)