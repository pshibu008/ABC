package com.example.abc.data

import com.example.abc.domain.repository.CustomItemRepository
import com.example.abc.data.source.CustomItemDataSource
import com.example.abc.domain.model.CustomItem

class CustomItemRepositoryImpl(private val dataSource: CustomItemDataSource) :
    CustomItemRepository {
    override fun getCustomItems(): List<CustomItem> {
        return dataSource.fetchCustomItems()
    }
}