package com.example.abc.domain.usecase

import com.example.abc.domain.model.Item

class TopThreeFrequentCharactersUseCase {
    operator fun invoke(items: List<Item>): List<Pair<Char, Int>> {
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