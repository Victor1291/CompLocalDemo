package com.shu.complocaldemo.material3Demo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CanvasSample() {
    Canvas(modifier = Modifier.size(100.dp)) {
        drawRect(Color.Magenta)
        inset(10.0f) {
            drawLine(
                color = Color.Red,
                start = Offset.Zero,
                end = Offset(size.width, size.height),
                strokeWidth = 5.0f
            )
        }
    }
}

@Preview
@Composable
fun CanvasPieChartSample() {
    Canvas(
        contentDescription = "Pie chart: 80% apples, 20% bananas (localized string)",
        modifier = Modifier.size(300.dp)
    ) {
        // Apples (80%)
        drawCircle(
            color = Color.Red,
            radius = size.width / 2
        )

        // Bananas (20%)
        drawArc(
            color = Color.Yellow,
            startAngle = 0f,
            sweepAngle = 360f * 0.20f,
            useCenter = true,
            topLeft = Offset(0f, (size.height - size.width) / 2f),
            size = Size(size.width, size.width)
        )
    }
}
