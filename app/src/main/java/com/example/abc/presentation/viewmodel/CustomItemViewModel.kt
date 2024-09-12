package com.example.abc.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abc.domain.model.Item
import com.example.abc.domain.repository.CustomItemRepository
import com.example.abc.domain.usecase.FilterItemsUseCase
import com.example.abc.domain.usecase.TopThreeFrequentCharactersUseCase
import com.example.abc.presentation.ui.state.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomItemViewModel(
    private val filterItemsUseCase: FilterItemsUseCase,
    private val topThreeFrequentCharactersUseCase: TopThreeFrequentCharactersUseCase,
    private val repository: CustomItemRepository
) : ViewModel() {

    private val _customItemsState = MutableStateFlow<UiState>(UiState.Loading)
    val customItemsState: StateFlow<UiState> get() = _customItemsState

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val itemList: StateFlow<List<Item>> get() = _items

    init {
        fetchCustomItems()
    }

    private fun fetchCustomItems() {
        viewModelScope.launch {
            _customItemsState.value = UiState.Loading
            delay(2000)
            try {
                val items = repository.getCustomItems()
                _customItemsState.value = UiState.Success(items)
            } catch (e: Exception) {
                _customItemsState.value = UiState.Error(e.message.toString())
            }
        }
    }

    fun filterItems(itemList: List<Item>, query: String?) {
        _items.value = filterItemsUseCase(itemList, query)
    }

    fun getTopThreeFrequentCharacters(itemList: List<Item>): List<Pair<Char, Int>> {
        return topThreeFrequentCharactersUseCase(itemList)
    }
}
