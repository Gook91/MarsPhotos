package com.example.marsphotos.domain

import javax.inject.Inject

import com.example.marsphotos.data.MarsRoverApi

// UseCase, возвращающий количество фотографий на странице
class GetPageSizeUseCase @Inject constructor(
    private val marsRoverApiCompanion: MarsRoverApi.Companion
) {
    fun execute(): Int = marsRoverApiCompanion.PAGE_SIZE
}