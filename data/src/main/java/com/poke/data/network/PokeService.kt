package com.poke.data.network

import com.poke.common.Constants.METHOD_GET
import com.poke.data.response.PokeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    @GET(METHOD_GET)
    suspend fun getPoke(@Query("limit") limit: Int = 150):Response<PokeResponse>
}