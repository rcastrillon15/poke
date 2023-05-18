package com.poke.data.response

data class PokeResponse(
    val count: Int,
    val next: String,
    val results: List<Result>
){
    data class Result(
        val name: String,
        val url: String
    )
}
