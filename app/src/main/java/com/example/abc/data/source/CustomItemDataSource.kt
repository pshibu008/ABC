package com.example.abc.data.source

import com.example.abc.R
import com.example.abc.domain.model.CustomItem
import com.example.abc.domain.model.Item

class CustomItemDataSource {

    fun fetchCustomItems(): List<CustomItem> {
        return mutableListOf(
            CustomItem(R.drawable.ic_launcher_background, listOf<Item>(
                Item(
                "Lion",
                "This is a description",
                R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Tiger",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Rabbit",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Jackal",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Elephant",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Fox",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Cheetah",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Monkey",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),

            )),
            CustomItem(R.drawable.ic_launcher_foreground, listOf<Item>(
                Item(
                    "Apple",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Mango",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Banana",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Guava",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Grapes",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Pineapple",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),

                )),
            CustomItem(R.drawable.ic_launcher_background, listOf<Item>(
                Item(
                    "Mercury",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Venus",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Earth",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Mars",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Jupiter",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Saturn",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Uranus",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),
                Item(
                    "Neptune",
                    "This is a description",
                    R.drawable.ic_launcher_foreground
                ),

                ))
        )
    }
}