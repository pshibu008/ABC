package com.example.abc.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.abc.presentation.ui.ui.theme.ABCTheme
import com.example.abc.presentation.viewmodel.CustomItemViewModel

@Composable
fun MainContent(viewModel: CustomItemViewModel) {
    ABCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val customItems by viewModel.customItems.observeAsState(emptyList())
            val currentPage = remember { mutableIntStateOf(0) }

            if (customItems.isNotEmpty()) {
                HorizontalPagerScreen(customItems, currentPage)
            }
        }
    }
}
