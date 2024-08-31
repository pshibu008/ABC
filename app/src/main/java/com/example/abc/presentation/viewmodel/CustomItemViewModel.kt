package com.example.abc.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abc.domain.model.CustomItem
import com.example.abc.domain.model.Item
import com.example.abc.domain.repository.CustomItemRepository
import com.example.abc.domain.usecase.FilterItemsUseCase
import com.example.abc.domain.usecase.TopThreeFrequentCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomItemViewModel(
    private val filterItemsUseCase: FilterItemsUseCase,
    private val topThreeFrequentCharactersUseCase: TopThreeFrequentCharactersUseCase,
    private val repository: CustomItemRepository
) : ViewModel() {

    private val _customItems = MutableStateFlow<List<CustomItem>>(emptyList())
    val customItems: StateFlow<List<CustomItem>> get() = _customItems

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val itemList: StateFlow<List<Item>> get() = _items

    init {
        fetchCustomItems()
    }

    private fun fetchCustomItems() {
        viewModelScope.launch {
            try {
                val items = repository.getCustomItems()
                _customItems.value = items
            } catch (e: Exception) {
                Log.d("Exception", e.message.toString())
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
