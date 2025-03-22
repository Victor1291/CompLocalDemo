package com.shu.complocaldemo.gestures


import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.LayoutModifierDemo
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun TapPressDemo(modifier: Modifier = Modifier) {

    var textState by remember { mutableStateOf("Waiting ....") }

    val tapHandler = { status: String ->
        textState = status
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            Modifier
                .padding(10.dp)
                .background(Color.Blue)
                .size(100.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = { tapHandler("onPress Detected") },
                        onDoubleTap = { tapHandler("onDoubleTap Detected") },
                        onLongPress = { tapHandler("onLongPress Detected") },
                        onTap = { tapHandler("onTap Detected") }
                    )
                }
        )
        Spacer(Modifier.height(10.dp))
        Text(textState)
    }
}

@Preview(showBackground = true)
@Composable
fun TapPressPreview() {
    CompLocalDemoTheme {
        TapPressDemo()
    }
}

/*
компонент TapPressDemo содержит два компонента Box и Text  в родительском компоненте Column.
строка отображаемая в Text основана на текущем состоянии textState.
Когда жест обнаруживается с помощью detectTapGestures
 */