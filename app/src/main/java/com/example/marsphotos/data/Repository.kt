package com.example.marsphotos.data

import kotlinx.coroutines.delay
import javax.inject.Inject

import com.example.marsphotos.entity.Photo

// Хранилище данных
class Repository @Inject constructor(
    private val marsRoverApi: MarsRoverApi
) {
    // Получение страницы с фотографиями
    suspend fun getPhotos(page: Int): List<Photo> {
        delay(2_000) // Задержка для проверки элементов, активных при загрузке
        return marsRoverApi.getPhotos(page).photos
    }
}