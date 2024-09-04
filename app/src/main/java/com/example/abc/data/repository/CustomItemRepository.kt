package com.example.abc.data.repository

import com.example.abc.domain.model.CustomItem

interface CustomItemRepository {
    fun getCustomItems(): List<CustomItem>
}