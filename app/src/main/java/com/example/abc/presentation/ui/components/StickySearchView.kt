package com.example.abc.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.abc.R
import kotlin.math.roundToInt

@Composable
fun StickySearchView(scrollState: LazyListState, searchQuery: MutableState<String>) {

    val stickyHeightPx = with(LocalDensity.current) { dimensionResource(id = R.dimen._56dp).toPx() }

    val scrollOffset by remember {
        derivedStateOf {
            val firstVisibleItemIndex = scrollState.firstVisibleItemIndex
            val firstVisibleItemScrollOffset = scrollState.firstVisibleItemScrollOffset
            if (firstVisibleItemIndex == 0) {
                -firstVisibleItemScrollOffset.toFloat().coerceAtMost(stickyHeightPx)
            } else {
                0f
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .offset { IntOffset(0, scrollOffset.roundToInt()) }
            .zIndex(1f)
            .padding(horizontal = dimensionResource(id = R.dimen._16dp))
    ) {
        SearchField(searchQuery)
    }
}






