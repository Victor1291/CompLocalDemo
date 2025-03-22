package com.shu.complocaldemo.gestures

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import kotlin.math.roundToInt


@Composable

fun PointerInputDrag(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize()) {
        var xOffset by remember { mutableFloatStateOf(0f) }
        var yOffset by remember { mutableFloatStateOf(0f) }

        Box(
            Modifier
                .offset { IntOffset(xOffset.roundToInt(), yOffset.roundToInt()) }
                .background(Color.Blue)
                .size(100.dp)
                .pointerInput(Unit) {
                    detectDragGestures { _, distance ->
                        xOffset += distance.x
                        yOffset += distance.y
                    }
                })
    }
}

@Preview(showBackground = true)
@Composable
fun PointerInputPreview() {
    CompLocalDemoTheme {
        PointerInputDrag()
    }
}