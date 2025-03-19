package com.shu.complocaldemo.intrinsic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IntrinsicMaxDemo(modifier: Modifier = Modifier) {

    var textState by remember { mutableStateOf("") }

    val onTextChange = { text: String ->
        textState = text
    }
    Column(
        modifier
            .width(200.dp)
            .padding(5.dp)) {

        Column(Modifier.width(IntrinsicSize.Max)) {

            Text(
                modifier = Modifier
                    .padding(start = 4.dp),
                text = textState
            )
            Box(
                Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(androidx.compose.ui.graphics.Color.Blue)
            )
        }
        MyTextField(text = textState, onTextChange = onTextChange)
    }
}