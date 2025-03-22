package com.shu.complocaldemo.gestures

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable

fun MultiTouchDemo(modifier: Modifier = Modifier) {

    var scale by remember { mutableStateOf(1f) }

    var angle by remember { mutableFloatStateOf(0f) }

    var offset by remember { mutableStateOf(Offset.Zero) }

    val state = rememberTransformableState { scaleChange, offsetChange, rotationChange ->
        scale *= scaleChange
        angle += rotationChange
        offset += offsetChange
    }

    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {

        Box(
            Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = angle,
                    translationX = offset.x,
                    translationY = offset.y
                )
                .transformable(state = state)
                .background(Color.Blue)
                .size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MultiTouchPreview() {
    CompLocalDemoTheme {
        MultiTouchDemo()
    }
}