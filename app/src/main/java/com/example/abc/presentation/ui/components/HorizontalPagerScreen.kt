package com.example.abc.presentation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ModalBottomSheetLayout
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.abc.R
import com.example.abc.domain.model.CustomItem
import com.example.abc.domain.model.Item
import com.example.abc.util.CustomItemUtils
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun HorizontalPagerScreen(customItems: List<CustomItem>, currentPage: MutableState<Int>) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { customItems.size }
    )
    val scrollState = rememberLazyListState()

    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    val currentItems = customItems.getOrNull(currentPage.value)?.list ?: emptyList()

    UpdateCurrentPage(pagerState, currentPage)

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            BottomSheetContent(items = currentItems)
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            PagerWithListAndSearchView(customItems, currentPage, pagerState, scrollState)

            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        if (bottomSheetState.isVisible) {
                            bottomSheetState.hide()
                        } else {
                            bottomSheetState.show()
                        }
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.stats),
                    contentDescription = "Status",
                    modifier = Modifier.size(24.dp)
                )
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

@Composable
fun BottomSheetContent(items: List<Item>) {
    val topCharacters = CustomItemUtils.topThreeFrequentCharactersFromTitles(items)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Top Characters",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        topCharacters.forEach { (character, count) ->
            Text(
                text = "$character: $count times",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}



