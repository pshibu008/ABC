package com.example.abc.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.abc.R

@Composable
fun BottomSheetContent(topCharacters: List<Pair<Char, Int>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen._16dp))
    ) {
        Text(
            text = "Top Characters",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen._8dp))
        )
        topCharacters.forEach { (character, count) ->
            Text(
                text = "$character: $count times",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}