package com.example.marsphotos.presentation.recycler

import androidx.recyclerview.widget.DiffUtil

import com.example.marsphotos.data.dto.PhotoDto
import com.example.marsphotos.entity.Photo

// DiffUtil, сравнивающий старый и новый элементы
class PhotoDiffUtilCallback : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean = oldItem.id == newItem.id

    // Приводим элемент к дата-классу и сравниваем их
    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
        (oldItem as PhotoDto) == (newItem as PhotoDto)
}