package com.example.marsphotos.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

import com.example.marsphotos.R
import com.example.marsphotos.databinding.FragmentMainListBinding
import com.example.marsphotos.presentation.recycler.LoadPagingAdapter
import com.example.marsphotos.presentation.recycler.PhotoPagingAdapter
import com.example.marsphotos.presentation.viewModel.MainViewModel
import com.example.marsphotos.presentation.viewModel.MainViewModelFactory

@AndroidEntryPoint
class MainListFragment : Fragment() {

    private var _binding: FragmentMainListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private val mainViewModel: MainViewModel by viewModels { mainViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Создаём адаптер для работы со списком и присваиваемого списку
        val photoPagingAdapter = PhotoPagingAdapter { photo ->
            // Передаём лямбду перехода в новый фрагмент
            val urlPhoto = photo.imgSrc
            val action = MainListFragmentDirections.fromMainListFragmentToPhotoFragment(urlPhoto)
            findNavController().navigate(action)
        }
        binding.photoListView.adapter = photoPagingAdapter.withLoadStateFooter(LoadPagingAdapter())

        // Передаём данные из потока вью-модели в адаптер списка
        mainViewModel.pagedPhotosFlow.onEach {
            photoPagingAdapter.submitData(it)
        }.launchIn(lifecycleScope)

        // Обрабатываем состояния загрузки списка
        photoPagingAdapter.loadStateFlow.onEach {
            // Выводим индикатор при загрузке
            binding.swipeRefresh.isRefreshing = it.refresh == LoadState.Loading
            // Если возникла проблема при загрузке, то показываем сообщение об ошибке
            if (it.refresh is LoadState.Error) {
                val message = getString(R.string.error_message)
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }
        }.launchIn(lifecycleScope)

        // Обновляем список при запросе пользователя
        binding.swipeRefresh.setOnRefreshListener {
            photoPagingAdapter.refresh()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}