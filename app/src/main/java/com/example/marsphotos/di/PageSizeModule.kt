package com.example.marsphotos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.example.marsphotos.data.MarsRoverApi

@Module
@InstallIn(SingletonComponent::class)
class PageSizeModule {

    // Возвращаем ссылку на компаньона API с параметрами
    @Provides
    fun provideMarsRoverApiCompanion(): MarsRoverApi.Companion = MarsRoverApi.Companion
}