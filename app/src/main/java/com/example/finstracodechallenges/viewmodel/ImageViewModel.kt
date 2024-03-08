package com.example.sampleproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finstracodechallenges.model.ImageResponse
import com.example.sampleproject.repositories.ImagesRepository
import kotlinx.coroutines.launch

class ImageViewModel:ViewModel() {
    private val repository = ImagesRepository()

    private val _randomImages = MutableLiveData<List<ImageResponse>>()
    val randomImages: LiveData<List<ImageResponse>> = _randomImages

    init {
        refreshImages()
    }
    
    fun refreshImages() {
        viewModelScope.launch {
            val response = repository.getRandomImages()
            _randomImages.postValue(response)
        }
    }
}