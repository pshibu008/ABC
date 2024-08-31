package com.example.abc.domain.repository

import com.example.abc.domain.model.CustomItem

interface CustomItemRepository {
    fun getCustomItems(): List<CustomItem>
}