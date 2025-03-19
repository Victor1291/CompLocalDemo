package com.shu.complocaldemo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun SlotDemo(
    topContent: @Composable () -> Unit,
    middleContent: @Composable () -> Unit,
    bottomContent: @Composable () -> Unit
) {
    Column {
        topContent()
        middleContent()
        bottomContent()
    }
}

@Preview(showBackground = true)
@Composable
fun SlotDemoPreview() {
    CompLocalDemoTheme {
        SlotDemo(
            { Text("Top Text") },
            { ButtonDemo() },
            { Text("Bottom Text") }
        )
    }
}

@Composable
fun ButtonDemo() {
    Button(onClick = { }) {
        Text("Click Me")
    }
}