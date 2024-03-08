package com.example.finstracodechallenges.api

import com.example.finstracodechallenges.model.ImageResponse
import retrofit2.Response

class ApiClient(
    private val imagesService: ImagesService
) {
    suspend fun getRandomImages(): Response<List<ImageResponse>> {
        return imagesService.getRandomImages()
    }
}