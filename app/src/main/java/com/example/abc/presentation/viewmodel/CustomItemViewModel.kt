package com.example.abc.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abc.domain.model.CustomItem
import com.example.abc.domain.repository.CustomItemRepository
import kotlinx.coroutines.launch

class CustomItemViewModel(private val repository: CustomItemRepository) : ViewModel() {
    private val _customItems = MutableLiveData<List<CustomItem>>()
    val customItems: LiveData<List<CustomItem>> get() = _customItems

    fun fetchCustomItems() {
        viewModelScope.launch {
            try {
                val items = repository.getCustomItems()
                _customItems.value = items
            } catch (e: Exception) {
                Log.d("Exception", e.printStackTrace().toString())
            }
        }
    }
}