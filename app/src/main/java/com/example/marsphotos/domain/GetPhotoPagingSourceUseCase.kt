package com.example.marsphotos.domain

import javax.inject.Inject

import com.example.marsphotos.data.PhotoPagingSource

// UseCase, возвращающий новый экземпляр PhotosPagingSource для Recycler View
// При каждом обновлении Pager требует новый объект Paging Source, поэтому при создании получаем фабрику
class GetPhotoPagingSourceUseCase @Inject constructor(
    private val photoPagingSourceFactory: () -> PhotoPagingSource
) {
    fun execute(): PhotoPagingSource = photoPagingSourceFactory()
}