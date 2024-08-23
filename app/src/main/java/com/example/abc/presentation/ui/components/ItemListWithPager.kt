package com.example.abc.presentation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.abc.domain.model.CustomItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemListWithPager(
    customItems: List<CustomItem>,
    currentPage: MutableState<Int>,
    pagerState: PagerState,
    scrollState: LazyListState,
    searchQuery: MutableState<String>
) {
    val filteredItems = remember(customItems, currentPage.value, searchQuery.value) {
        customItems[currentPage.value].list.filter {
            it.title.contains(searchQuery.value, ignoreCase = true)
        }
    }

    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            PagerWithIndicator(customItems, pagerState)
        }

        stickyHeader {
            StickySearchView(scrollState, searchQuery)
        }

        items(filteredItems) { subItem ->
            CustomItemContainer(subItem)
        }
    }
}



