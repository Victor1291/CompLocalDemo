package com.shu.complocaldemo.intrinsic

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun MyTextField(text: String, onTextChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onTextChange
    )
}