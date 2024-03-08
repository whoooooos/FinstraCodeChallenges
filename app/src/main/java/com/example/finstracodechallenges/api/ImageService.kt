package com.example.finstracodechallenges.api

import com.example.finstracodechallenges.model.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImagesService {
    @Headers("Authorization: Client-ID " + ApiUtilities.API_KEY)
    @GET("/photos/random")
    suspend fun getRandomImages(
        @Query("count") count: Int = 30,
    ): Response<List<ImageResponse>>
}

