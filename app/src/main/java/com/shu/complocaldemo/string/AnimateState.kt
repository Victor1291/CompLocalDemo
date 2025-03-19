package com.shu.complocaldemo.string

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme


enum class ContentState { Foo, Bar, Baz }

@Composable
fun Foo(click: () -> Unit) {
    Box(
        Modifier
            .size(200.dp)
            .background(Color(0xffffdb00))
    ) {
        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { click() }) {
            Text(text = "next")
        }
    }
}

@Composable
fun Bar(click: () -> Unit) {
    Box(
        Modifier
            .size(40.dp)
            .background(Color(0xffff8100))) {
        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { click() }) {
            Text(text = "next")
        }
    }
}

@Composable
fun Baz(click: () -> Unit) {
    Box(
        Modifier
            .size(80.dp, 20.dp)
            .background(Color(0xffff4400))) {
        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { click() }) {
            Text(text = "next")
        }
    }
}

@Composable
fun AnimatState() {
    var contentState: ContentState by remember { mutableStateOf(ContentState.Foo) }


    AnimatedContent(contentState, label = "") {
        when (it) {
// Specifies the mapping between a given ContentState and a composable function.
            ContentState.Foo -> Foo(click = {contentState = ContentState.Bar })
            ContentState.Bar -> Bar(click = {contentState = ContentState.Baz })
            ContentState.Baz -> Baz(click = {contentState = ContentState.Foo })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatStatePreview() {
    CompLocalDemoTheme {
        AnimatState()
    }
}
