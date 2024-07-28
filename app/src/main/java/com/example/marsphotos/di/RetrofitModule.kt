package com.example.marsphotos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import com.example.marsphotos.data.MarsRoverApi

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    // Создаём объект Retrofit и возвращаем экземпляр API
    @Provides
    fun provideMarsRoverApi(): MarsRoverApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MarsRoverApi::class.java)
    }

    companion object {
        private const val BASE_URL = "https://api.nasa.gov"
    }
}