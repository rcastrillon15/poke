package com.poke.domain.entity

data class Poke(
    val count: Int,
    val next: String,
    val results: List<Result>
){
    data class Result(
        val id:Int,
        val name: String,
        val url: String
    )
}
