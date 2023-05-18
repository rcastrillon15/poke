package com.poke.state

data class PokeState(
    val count: Int = 0,
    val next: String = "",
    val results: List<Result> = listOf()
) {
    data class Result(
        val name: String = "",
        val url: String = ""
    )
}
