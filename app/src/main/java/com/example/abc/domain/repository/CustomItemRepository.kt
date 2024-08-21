package com.example.abc.domain.repository

import com.example.abc.data.source.CustomItemDataSource
import com.example.abc.domain.model.CustomItem

class CustomItemRepository(private val dataSource: CustomItemDataSource) {
    fun getCustomItems(): List<CustomItem> {
        return dataSource.fetchCustomItems()
    }
}