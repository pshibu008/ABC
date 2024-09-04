package com.example.abc.presentation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ModalBottomSheetLayout
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ModalBottomSheetValue
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.example.abc.domain.model.CustomItem
import com.example.abc.presentation.ui.state.UiState
import com.example.abc.presentation.viewmodel.CustomItemViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun HorizontalPagerScreen(viewModel: CustomItemViewModel, currentPage: MutableState<Int>) {
    val customItemsState by viewModel.customItemsState.collectAsState()
    val scrollState = rememberLazyListState()
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        when (customItemsState) {
            is UiState.Loading -> LoadingView()
            is UiState.Error -> ErrorView((customItemsState as UiState.Error).message)
            is UiState.Success -> {
                val customItems = (customItemsState as UiState.Success).data
                val pagerStateWithItems = rememberPagerState(
                    initialPage = 0,
                    pageCount = { customItems.size }
                )

                val currentItems = customItems.getOrNull(currentPage.value)?.list ?: emptyList()
                val topCharacters = viewModel.getTopThreeFrequentCharacters(currentItems)

                UpdateCurrentPage(pagerStateWithItems, currentPage)

                ModalBottomSheetLayout(
                    sheetState = bottomSheetState,
                    sheetContent = { BottomSheetContent(topCharacters) }
                ) {
                    ContentWithPagerAndFAB(
                        customItems = customItems,
                        currentPage = currentPage,
                        pagerState = pagerStateWithItems,
                        scrollState = scrollState,
                        bottomSheetState = bottomSheetState,
                        coroutineScope = coroutineScope
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerWithListAndSearchView(
    customItems: List<CustomItem>,
    currentPage: MutableState<Int>,
    pagerState: PagerState,
    scrollState: LazyListState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val searchQuery = remember { mutableStateOf("") }
        ItemListWithPager(customItems, currentPage, pagerState, scrollState, searchQuery)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UpdateCurrentPage(pagerState: PagerState, currentPage: MutableState<Int>) {
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            currentPage.value = page
        }
    }
}





