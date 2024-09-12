package com.example.abc.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.abc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(searchQuery: MutableState<String>) {
    TextField(
        value = searchQuery.value,
        onValueChange = { newQuery ->
            searchQuery.value = newQuery
        },
        placeholder = { Text("Search...") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen._16dp), vertical = dimensionResource(id = R.dimen._8dp))
            .background(Color.White, shape = RoundedCornerShape(dimensionResource(id = R.dimen._16dp)))
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen._16dp)))
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen._16dp))
            ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search icon",
                tint = Color.Gray
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen._16dp))
    )
}

