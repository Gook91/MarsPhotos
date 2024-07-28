package com.example.marsphotos.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.bumptech.glide.Glide

import com.example.marsphotos.R
import com.example.marsphotos.databinding.ItemPhotoBinding
import com.example.marsphotos.entity.Photo

// Класс адаптера для вывода списка фотографий
class PhotoPagingAdapter(
    val onClickItem: (Photo) -> Unit
) : PagingDataAdapter<Photo, PhotoViewHolder>(
    PhotoDiffUtilCallback()
) {
    // Заполняем элемент значениями из сущности фотографии
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        // Получаем сущность и обрабатываем её, если она не пустая
        val item = getItem(position)
        item?.apply {
            val context = holder.itemView.context
            with(holder.binding) {

                // Заполняем элементы
                roverName.text = context.getString(R.string.rover_name, rover.name)
                cameraName.text = context.getString(R.string.camera_name, camera.fullName)
                solNumber.text = context.getString(R.string.sol_number, sol)
                datePhoto.text = context.getString(R.string.date_photo, earthDate)
                Glide.with(context)
                    .load(item.imgSrc)
                    .into(pictureView)

                // Присваиваем обработчик нажатий из конструктора
                root.setOnClickListener { onClickItem(item) }
            }
        }
    }

    // Возвращаем новый холдер
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context))
        return PhotoViewHolder(binding)
    }
}