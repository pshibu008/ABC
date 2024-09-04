package com.example.abc.presentation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.abc.R
import com.example.abc.domain.model.CustomItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun ContentWithPagerAndFAB(
    customItems: List<CustomItem>,
    currentPage: MutableState<Int>,
    pagerState: PagerState,
    scrollState: LazyListState,
    bottomSheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope
) {
    Box(modifier = Modifier.fillMaxSize()) {
        PagerWithListAndSearchView(
            customItems = customItems,
            currentPage = currentPage,
            pagerState = pagerState,
            scrollState = scrollState
        )

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
                .padding(dimensionResource(id = R.dimen._16dp))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.stats),
                contentDescription = "Status",
                modifier = Modifier.size(dimensionResource(id = R.dimen._24dp))
            )
        }
    }
}