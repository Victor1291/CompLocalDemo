package com.shu.complocaldemo.gestures

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.R
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme


@Composable

fun ScrollModifiers(modifier: Modifier = Modifier) {

    val image = ImageBitmap.imageResource(id = R.drawable.vacation)

    Box(
        modifier = modifier
            .size(150.dp)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
    ) {
        Canvas(
            modifier = Modifier
                .size(360.dp, 270.dp)
        ) {
            drawImage(
                image = image,
                topLeft = Offset(
                    x = 0f,
                    y = 0f
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun  ScrollModifiersPreview() {
    CompLocalDemoTheme {
        ScrollModifiers()
    }
}