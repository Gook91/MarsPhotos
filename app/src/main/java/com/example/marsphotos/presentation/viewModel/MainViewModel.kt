package com.example.marsphotos.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

import com.example.marsphotos.domain.GetPageSizeUseCase
import com.example.marsphotos.domain.GetPhotoPagingSourceUseCase
import com.example.marsphotos.entity.Photo
import java.lang.annotation.Inherited
import javax.inject.Inject

// Класс вью-модели
class MainViewModel @Inject constructor(
    private val getPhotoPagingSourceUseCase: GetPhotoPagingSourceUseCase,
    private val getPageSizeUseCase: GetPageSizeUseCase
) : ViewModel() {
    // Поток с загруженными фотографиями для Recycle view
    val pagedPhotosFlow: Flow<PagingData<Photo>> = Pager(
        PagingConfig(getPageSizeUseCase.execute())
    ) { getPhotoPagingSourceUseCase.execute() }
        .flow.cachedIn(viewModelScope)
}