package com.shu.complocaldemo.material3Demo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun OneLineListItem(
    text: String = "One line list item with 24x24 icon",
    icon: ImageVector = Icons.Filled.Favorite
) {
    Column {
        ListItem(
            headlineContent = { Text(text = text) },
            leadingContent = {
                Icon(
                    icon,
                    contentDescription = "Localized description",
                )
            }
        )
        HorizontalDivider()
    }
}

@Preview
@Composable
fun TwoLineListItem() {
    Column {
        ListItem(
            headlineContent = { Text("Two line list item with trailing") },
            supportingContent = { Text("Secondary text") },
            trailingContent = { Text("meta") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }
        )
        HorizontalDivider()
    }
}

@Preview
@Composable
fun ThreeLineListItemWithOverlineAndSupporting() {
    Column {
        ListItem(
            headlineContent = { Text("Three line list item") },
            overlineContent = { Text("OVERLINE") },
            supportingContent = { Text("Secondary text") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            },
            trailingContent = { Text("meta") }
        )
        HorizontalDivider()
    }
}

@Preview
@Composable
fun ThreeLineListItemWithExtendedSupporting() {
    Column {
        ListItem(
            headlineContent = { Text("Three line list item") },
            supportingContent = {
                Text("Secondary text that is long and perhaps goes onto another line")
            },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            },
            trailingContent = { Text("meta") }
        )
        HorizontalDivider()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HeaderSticky() {
    val phones = listOf(
        "Apple iPhone 12", "Google Pixel 4", "Google Pixel 6",
        "Samsung Galaxy 6s", "Apple iPhone 7", "OnePlus 7", "OnePlus 9 Pro",
        "Apple iPhone 13", "Samsung Galaxy Z Flip", "Google Pixel 4a",
        "Apple iPhone 8",
        "Apple2 iPhone 12", "Google2 Pixel 4", "Google2 Pixel 6",
        "Samsung2 Galaxy 6s", "Apple2 iPhone 7", "OnePlus2 7", "OnePlus2 9 Pro",
        "Apple2 iPhone 13", "Samsung2 Galaxy Z Flip", "Google2 Pixel 4a",
        "Apple2 iPhone2 8"
    )

    val groupedPhones = phones.groupBy { it.substringBefore(' ') }
    LazyColumn {
        groupedPhones.forEach { (manufacturer, models) ->
            stickyHeader {

                Text(
                    text = manufacturer,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.Gray)
                        .padding(5.dp)
                        .fillMaxWidth()
                )
            }

            items(models) { model ->
                OneLineListItem(model)
            }
        }
    }
}


