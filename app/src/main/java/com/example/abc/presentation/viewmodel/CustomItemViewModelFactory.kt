package com.example.abc.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abc.domain.repository.CustomItemRepository

class CustomItemViewModelFactory(private val repository: CustomItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CustomItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
