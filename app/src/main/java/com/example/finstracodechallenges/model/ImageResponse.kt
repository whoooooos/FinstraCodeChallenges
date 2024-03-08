package com.example.finstracodechallenges.model

data class ImageResponse(
    val alt_description: String? = null,
    val urls: Urls = Urls(),
    val user: User,
    val likes: Int? = 0
) {
    data class Urls(
        val regular: String = ""
    )
    data class User(
        val name: String = ""
    )
}
