package com.example.abc.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.abc.R
import com.example.abc.domain.model.Item

@Composable
fun CustomItemContainer(item: Item) {
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .padding(dimensionResource(id = R.dimen._12dp))
    ) {
        CustomItemCard(item = item)
    }
}

@Composable
fun CustomItemCard(item: Item) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray, shape = RoundedCornerShape(dimensionResource(id = R.dimen._8dp)))
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.padding(dimensionResource(id = R.dimen._8dp)),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen._12dp))
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(dimensionResource(id = R.dimen._48dp))
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen._8dp), end = dimensionResource(id = R.dimen._4dp))
                    .fillMaxWidth()
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
