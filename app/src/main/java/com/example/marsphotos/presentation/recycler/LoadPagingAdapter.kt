package com.example.marsphotos.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

import com.example.marsphotos.databinding.ItemLoadBinding

// Адаптер, отображающий прогресс-бар загрузки
class LoadPagingAdapter: LoadStateAdapter<LoadViewHolder>() {
    override fun onBindViewHolder(holder: LoadViewHolder, loadState: LoadState) = Unit

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadViewHolder {
        val binding = ItemLoadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadViewHolder(binding)
    }
}