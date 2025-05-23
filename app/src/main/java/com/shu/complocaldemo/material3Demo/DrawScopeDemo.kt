package com.shu.complocaldemo.material3Demo

/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.R
import com.shu.complocaldemo.TitleImage

/**
 * Sample showing how to use CanvasScope to issue drawing commands into
 * a given canvas as well as providing transformations to the drawing environment
 */
@Preview
@Composable
fun DrawScopeSample() {
    // Sample showing how to use the DrawScope receiver scope to issue
    // drawing commands
    Canvas(Modifier.size(120.dp)) {
        drawRect(color = Color.Gray) // Draw grey background
        // Inset content by 10 pixels on the left/right sides and 12 by the
        // top/bottom
        inset(10.0f, 12.0f) {
            val quadrantSize = size / 2.0f

            // Draw a rectangle within the inset bounds
            drawRect(
                size = quadrantSize,
                color = Color.Red
            )

            rotate(45.0f) {
                drawRect(size = quadrantSize, color = Color.Blue)
            }
        }
    }
}

@Preview
@Composable
fun DrawScopeBatchedTransformSample() {
    Canvas(Modifier.size(120.dp)) { // CanvasScope
        inset(20.0f) {
            // Use withTransform to batch multiple transformations for 1 or more drawing calls
            // that are to be drawn.
            // This is more efficient than issuing nested translation, rotation and scaling
            // calls as the internal state is saved once before and after instead of multiple
            // times between each transformation if done individually
            withTransform({
                translate(10.0f, 12.0f)
                rotate(45.0f, center)
                scale(2.0f, 0.5f)
            }) {
                drawRect(Color.Cyan)
                drawCircle(Color.Blue)
            }
            drawRect(Color.Red, alpha = 0.25f)
        }
    }
}

@Preview
@Composable
fun DrawScopeOvalBrushSample() {
    Canvas(Modifier.size(120.dp)) {
        drawOval(
            brush = Brush.linearGradient(listOf(Color.Red, Color.Blue)),
            topLeft = Offset(10f, 10f),
            size = Size(size.width - 20f, size.height - 20f)
        )
    }
}

@Preview
@Composable
fun DrawScopeOvalColorSample() {
    Canvas(Modifier.size(120.dp)) {
        drawOval(
            color = Color.Cyan,
            topLeft = Offset(10f, 10f),
            size = Size(size.width - 20f, size.height - 20f)
        )
    }
}

@Preview
@Composable
fun DrawScopeRetargetingSample() {
    Box(modifier = Modifier.size(120.dp)
        .drawWithCache {
            // Example that shows how to redirect rendering to an Android Picture and then
            // draw the picture into the original destination
            // Note:
            // Canvas#drawPicture is supported with hardware acceleration on Android API 23+
            // Check https://developer.android.com/topic/performance/hardware-accel#drawing-support
            // for details of which drawing operations are supported with hardware acceleration
            val picture = android.graphics.Picture()
            val width = this.size.width.toInt()
            val height = this.size.height.toInt()
            onDrawWithContent {
                val pictureCanvas =
                    androidx.compose.ui.graphics.Canvas(picture.beginRecording(width, height))
                draw(this, this.layoutDirection, pictureCanvas, this.size) {
                    this@onDrawWithContent.drawContent()
                }
                picture.endRecording()

                drawIntoCanvas { canvas -> canvas.nativeCanvas.drawPicture(picture) }
            }
        })
}
