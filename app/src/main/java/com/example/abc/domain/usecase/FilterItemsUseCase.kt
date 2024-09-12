package com.example.abc.domain.usecase

import com.example.abc.domain.model.Item

class FilterItemsUseCase {
    operator fun invoke(fullItemList: List<Item>, query: String?): List<Item> {
        return if (query.isNullOrEmpty()) {
            fullItemList
        } else {
            fullItemList.filter { it.title.contains(query, ignoreCase = true) }
        }
    }
}