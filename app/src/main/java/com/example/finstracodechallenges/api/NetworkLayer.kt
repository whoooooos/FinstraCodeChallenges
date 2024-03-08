package com.example.finstracodechallenges.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(ApiUtilities.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    val imagesService: ImagesService by lazy {
        retrofit.create(ImagesService::class.java)
    }
    val apiClient = ApiClient(imagesService)
}