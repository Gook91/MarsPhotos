package com.example.marsphotos.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState

import com.example.marsphotos.entity.Photo

// Класс постраничной загрузки фото для Recycler View
class PhotoPagingSource(
    private val repository: Repository
) : PagingSource<Int, Photo>() {
    // При обновлении начинаем заново с первой страницы
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int = FIRST_PAGE

    // Функция загрузки фотографий
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: FIRST_PAGE
        return try {
            // Получаем страницу с фотографиями и возвращаем её
            val photosFromPage = repository.getPhotos(page)
            LoadResult.Page(
                photosFromPage,
                null,
                if (photosFromPage.isEmpty()) null else page + 1
            )
        } catch (t: Throwable) {
            // При ошибке выводим её в лог и возвращаем её
            Log.e(LOG_TAG, "Error in load paging source $t", t)
            LoadResult.Error(t)
        }
    }

    companion object {
        private const val LOG_TAG = "LoggedErrors"

        // Параметры для загрузки берём из компаньона API, чтобы они хранились в одном месте
        private const val FIRST_PAGE = MarsRoverApi.FIRST_PAGE
    }
}