package com.example.abc.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abc.data.repository.CustomItemRepository
import com.example.abc.domain.usecase.FilterItemsUseCase
import com.example.abc.domain.usecase.TopThreeFrequentCharactersUseCase

class CustomItemViewModelFactory(
    private val filterItemsUseCase: FilterItemsUseCase,
    private val topThreeFrequentCharactersUseCase: TopThreeFrequentCharactersUseCase,
    private val repository: CustomItemRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CustomItemViewModel(filterItemsUseCase, topThreeFrequentCharactersUseCase, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

