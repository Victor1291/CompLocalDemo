package com.shu.complocaldemo.doc_compose.animation.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import kotlin.random.Random

data class BoxProperties(
    val color: Color,
    val width: Dp
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaggeredPage(goBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Easing functions") },
                navigationIcon = {
                    IconButton(onClick = goBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                }
            )
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            StaggeredVertical()
        }
    }
}

@Composable
private fun StaggeredPageContent(modifier: Modifier = Modifier) {
    val items = (1..50).map {
        BoxProperties(
            width = Random.nextInt(50, 200).dp,
            color = Color(
                Random.nextInt(255),
                Random.nextInt(255),
                Random.nextInt(255),
                255
            )
        )
    }

    LazyHorizontalStaggeredGrid(
        rows = StaggeredGridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalItemSpacing = 8.dp,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { values ->
            GridItem(properties = values)
        }
    }
}

@Composable
private fun StaggeredVertical(modifier: Modifier = Modifier) {

    val items = (1..50).map {
        BoxProperties(
            width = Random.nextInt(50, 200).dp,
            color = Color(
                Random.nextInt(255),
                Random.nextInt(255),
                Random.nextInt(255),
                255
            )
        )
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp,
    ) {
        items(items) { values ->
            GridItemVertical(properties = values)
        }
    }
}

@Composable
fun GridItem(properties: BoxProperties) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .width(properties.width)
            .clip(RoundedCornerShape(10.dp))
            .background(properties.color)
    )
}

@Composable
fun GridItemVertical(properties: BoxProperties) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(properties.width)
            .clip(RoundedCornerShape(10.dp))
            .background(properties.color)
    )
}

@Preview(
    showBackground = true,
    device = "spec:parent=pixel_5,orientation=landscape"
)
@Composable
fun StaggeredPreview() {
    CompLocalDemoTheme {
        StaggeredPageContent()
    }
}

@Preview(
    showBackground = true,
    //device = "spec:parent=pixel_5,orientation=landscape"
)
@Composable
fun StaggeredVerticalPreview() {
    CompLocalDemoTheme {
        StaggeredVertical()
    }
}
