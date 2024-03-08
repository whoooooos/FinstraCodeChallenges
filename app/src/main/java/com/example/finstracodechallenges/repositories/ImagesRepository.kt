package com.example.sampleproject.repositories

import com.example.finstracodechallenges.api.NetworkLayer
import com.example.finstracodechallenges.model.ImageResponse


class ImagesRepository {
    suspend fun getRandomImages(): List<ImageResponse>? {
        val request = NetworkLayer.apiClient.getRandomImages()

        if (request.isSuccessful) {
            return request.body()!!
        }

        return null
    }
}