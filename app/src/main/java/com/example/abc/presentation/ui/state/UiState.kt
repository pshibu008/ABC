package com.example.abc.presentation.ui.state

import com.example.abc.domain.model.CustomItem

sealed class UiState {
    data object Loading : UiState()
    data class Success(val data: List<CustomItem>) : UiState()
    data class Error(val message: String) : UiState()
}