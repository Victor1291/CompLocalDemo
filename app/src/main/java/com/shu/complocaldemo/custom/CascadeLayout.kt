package com.shu.complocaldemo.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun CascadeLayout(
    modifier: Modifier = Modifier,
    spacing: Int = 0,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        var indent = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            var yCoord = 0
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            placeables.forEach { placeable ->
                placeable.placeRelative(x = indent, y = yCoord)
                indent += placeable.width + spacing
                yCoord += placeable.height + spacing
            }
        }
    }
}

@Composable
fun CascadeScreen(modifier: Modifier = Modifier) {

    Box(modifier.fillMaxWidth().height(300.dp)) {
        CascadeLayout(spacing = 20) {
            Box(modifier = Modifier
                .size(60.dp)
                .background(Color.Blue))
            Box(modifier = Modifier
                .size(80.dp, 40.dp)
                .background(Color.Red))
            Box(modifier = Modifier
                .size(90.dp, 100.dp)
                .background(Color.Cyan))
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Magenta))
            Box(modifier = Modifier
                .size(70.dp)
                .background(Color.Green))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxLayoutDemoPreview() {
    CompLocalDemoTheme {
        CascadeScreen()
    }
}