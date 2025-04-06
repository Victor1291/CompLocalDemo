package com.shu.complocaldemo.circle

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun AnimationCircle(
    color: Color = Color.Green,
    radiusEnd: Float = 300f
) {
    val transition = rememberInfiniteTransition(label = "")
    val floatAnim by transition.animateFloat(
        initialValue = 10f,
        targetValue = radiusEnd,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse), label = ""
    )
    Canvas(modifier = Modifier.padding(16.dp)) {
        val centerOffset = Offset(10f, 10f)
        drawCircle(
            color = color.copy(alpha = 0.2f),
            radius = floatAnim,
            center = centerOffset,
        )
        drawCircle(
            color = color.copy(alpha = 0.2f),
            radius = floatAnim / 2,
            center = centerOffset,
        )
        drawCircle(
            color = color.copy(alpha = 0.4f),
            radius = floatAnim / 4,
            center = centerOffset,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CirclePreview() {
    CompLocalDemoTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimationCircle()
           // AnimationArc()
        }
    }
}