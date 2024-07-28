package com.example.marsphotos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.example.marsphotos.data.PhotoPagingSource
import com.example.marsphotos.data.Repository

@Module
@InstallIn(SingletonComponent::class)
class PagingSourceFactoryModule {

    // Возвращаем фабрику PhotoPagingSource
    @Provides
    fun providePhotoPagingSource(repository: Repository): (() -> PhotoPagingSource) =
        { PhotoPagingSource(repository) }
}