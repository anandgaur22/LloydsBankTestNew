package com.anand.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("fixtures")
    suspend fun getFixtures(@Query("api_token") apiToken: String): ApiResponse
}