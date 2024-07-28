package com.example.marsphotos.data

import com.example.marsphotos.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

import com.example.marsphotos.data.dto.PhotosListDto

// API для получения фотографий марсохода
interface MarsRoverApi {
    @GET("/mars-photos/api/v1/rovers/perseverance/photos?sol=72")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): PhotosListDto

    companion object {
        // Константы параметров API сервера
        const val FIRST_PAGE = 1
        const val PAGE_SIZE = 25

        // Ключ для отправки запроса
        private const val API_KEY = BuildConfig.API_KEY
    }
}