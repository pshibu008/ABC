package com.example.abc.data.source

import com.example.abc.R
import com.example.abc.domain.model.CustomItem
import com.example.abc.domain.model.Item

class CustomItemDataSource {

    fun fetchCustomItems(): List<CustomItem> {
        return mutableListOf(
            CustomItem(R.drawable.animals, listOf<Item>(
                Item(
                "Rabbit",
                "This is a description",
                R.drawable.rabbit
                ),
                Item(
                    "Pigeon",
                    "This is a description",
                    R.drawable.pigeon
                ),
                Item(
                    "Squirrel",
                    "This is a description",
                    R.drawable.squirrel
                ),
                Item(
                    "Tiger",
                    "This is a description",
                    R.drawable.tiger
                ),
                Item(
                    "Whale",
                    "This is a description",
                    R.drawable.whale
                ),
                Item(
                    "Swan",
                    "This is a description",
                    R.drawable.swan
                ),
                Item(
                    "Sparrow",
                    "This is a description",
                    R.drawable.sparrow
                ),
                Item(
                    "Snake",
                    "This is a description",
                    R.drawable.rattlesnake
                ),
                Item(
                    "Peacock",
                    "This is a description",
                    R.drawable.peacock
                ),
                Item(
                    "Panda",
                    "This is a description",
                    R.drawable.panda
                ),

            )),
            CustomItem(R.drawable.fruits, listOf<Item>(
                Item(
                    "Apricot",
                    "This is a description",
                    R.drawable.apricot
                ),
                Item(
                    "Avocado",
                    "This is a description",
                    R.drawable.avocado
                ),
                Item(
                    "Banana",
                    "This is a description",
                    R.drawable.banana
                ),
                Item(
                    "Cherry",
                    "This is a description",
                    R.drawable.cherry
                ),
                Item(
                    "Limes",
                    "This is a description",
                    R.drawable.limes
                ),
                Item(
                    "Pomegranate",
                    "This is a description",
                    R.drawable.pomegranate
                ),
                Item(
                    "Orange",
                    "This is a description",
                    R.drawable.orange
                ),
                Item(
                    "Raspberry",
                    "This is a description",
                    R.drawable.raspberry
                ),
                Item(
                    "Mango",
                    "This is a description",
                    R.drawable.mango
                ),

                )),
            CustomItem(R.drawable.planet, listOf<Item>(
                Item(
                    "Mercury",
                    "This is a description",
                    R.drawable.mercury
                ),
                Item(
                    "Venus",
                    "This is a description",
                    R.drawable.venus
                ),
                Item(
                    "Earth",
                    "This is a description",
                    R.drawable.earth
                ),
                Item(
                    "Mars",
                    "This is a description",
                    R.drawable.mars
                ),
                Item(
                    "Jupiter",
                    "This is a description",
                    R.drawable.jupiter
                ),
                Item(
                    "Saturn",
                    "This is a description",
                    R.drawable.saturn
                ),
                Item(
                    "Uranus",
                    "This is a description",
                    R.drawable.uranus
                ),
                Item(
                    "Neptune",
                    "This is a description",
                    R.drawable.neptune
                ),
                Item(
                    "Pluto",
                    "This is a description",
                    R.drawable.pluto
                ),

                ))
        )
    }
}