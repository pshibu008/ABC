package com.example.abc.presentation.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.abc.data.source.CustomItemDataSource
import com.example.abc.domain.repository.CustomItemRepository
import com.example.abc.domain.repository.CustomItemRepositoryImpl
import com.example.abc.domain.usecase.FilterItemsUseCase
import com.example.abc.domain.usecase.TopThreeFrequentCharactersUseCase
import com.example.abc.presentation.ui.components.MainContent
import com.example.abc.presentation.viewmodel.CustomItemViewModel
import com.example.abc.presentation.viewmodel.CustomItemViewModelFactory

class SecondActivity : ComponentActivity() {

    private lateinit var viewModel: CustomItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeViewModel()

        setContent {
            MainContent(viewModel)
        }

    }

    private fun initializeViewModel() {

        val filterItemsUseCase = FilterItemsUseCase()
        val topThreeFrequentCharactersUseCase = TopThreeFrequentCharactersUseCase()
        val dataSource = CustomItemDataSource()
        val repository = CustomItemRepositoryImpl(dataSource)

        val factory = CustomItemViewModelFactory(
            filterItemsUseCase,
            topThreeFrequentCharactersUseCase,
            repository
        )

        viewModel = ViewModelProvider(this, factory)[CustomItemViewModel::class.java]
    }
}




















