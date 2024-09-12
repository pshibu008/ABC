package com.example.abc.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.abc.domain.model.CustomItem
import com.example.abc.presentation.ui.state.UiState
import com.example.abc.presentation.ui.ui.theme.ABCTheme
import com.example.abc.presentation.viewmodel.CustomItemViewModel

@Composable
fun MainContent(viewModel: CustomItemViewModel) {
    ABCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val customItemsState by viewModel.customItemsState.collectAsState()
            val currentPage = remember { mutableIntStateOf(0) }

            when (customItemsState) {
                is UiState.Loading -> LoadingView()
                is UiState.Error -> ErrorView((customItemsState as UiState.Error).message)
                is UiState.Success -> {
                    val customItems = (customItemsState as UiState.Success).data
                    if (customItems.isNotEmpty()) {
                        HorizontalPagerScreen(viewModel, currentPage)
                    }
                }
            }
        }
    }
}


