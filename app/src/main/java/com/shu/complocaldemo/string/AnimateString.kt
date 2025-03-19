package com.shu.complocaldemo.string

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme


@Composable
fun AnimateString() {
    var visible by remember { mutableStateOf(true) }

    Box {
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(
// Start the slide from 40 (pixels) above where the content is supposed to go, to
// produce a parallax effect
                initialOffsetY = { -40 }) + expandVertically(expandFrom = Alignment.Top) + scaleIn(
// Animate scale from 0f to 1f using the top center as the pivot point.
                transformOrigin = TransformOrigin(0.5f, 0f)
            ) + fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(targetScale = 1.2f)
        ) {
            // Content that needs to appear/ disappear goes here:
            Text(
                "Content to appear/ disappear",
                Modifier
                    .fillMaxWidth()
                    .requiredHeight(200.dp)
            )
        }

        AnimatedVisibility(
            visible = !visible,
            enter = slideInVertically(
// Start the slide from 40 (pixels) above where the content is supposed to go, to
// produce a parallax effect
                initialOffsetY = { -40 }) + expandVertically(expandFrom = Alignment.Bottom) + scaleIn(
// Animate scale from 0f to 1f using the top center as the pivot point.
                transformOrigin = TransformOrigin(0f, 0.5f)
            ) + fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(targetScale = 1.2f)
        ) {
            // Content that needs to appear/ disappear goes here:
            Text(
                "Content to appear/ disappear",
                Modifier
                    .fillMaxWidth()
                    .requiredHeight(100.dp)
            )
        }


        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { visible = !visible }) {
            Text(text = "change")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AnimateStringPreview() {
    CompLocalDemoTheme {
        AnimateString()
    }
}