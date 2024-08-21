package com.example.abc.util

import com.example.abc.domain.model.Item

object CustomItemUtils {

    fun filterList(fullItemList: List<Item>, query: String?): List<Item> {
        return if (query.isNullOrEmpty()) {
            fullItemList
        } else {
            fullItemList.filter { it.title.contains(query, ignoreCase = true) }
        }
    }

    fun topThreeFrequentCharactersFromTitles(items: List<Item>): List<Pair<Char, Int>> {
        return items.asSequence()
            .flatMap { it.title.asSequence() }
            .filter { it.isLetter() }
            .groupingBy { it.lowercaseChar() }
            .eachCount()
            .entries
            .sortedByDescending { it.value }
            .take(3)
            .map { it.toPair() }
    }
}
