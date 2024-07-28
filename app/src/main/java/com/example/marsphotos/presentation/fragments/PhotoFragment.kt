package com.example.marsphotos.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.example.marsphotos.R

// Класс фрагменты, выводящего фотографию: для уменьшения кода у него отключен binding
class PhotoFragment : Fragment() {
    // Получаем стартовые аргументы
    private val args: PhotoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Берём полученный URL и с помощью Glide загружаем его в Image View
        val photoUrl = args.photoUrl
        val photoView: ImageView = view.findViewById(R.id.photo_view)
        Glide.with(requireContext())
            .load(photoUrl)
            .into(photoView)
    }


}