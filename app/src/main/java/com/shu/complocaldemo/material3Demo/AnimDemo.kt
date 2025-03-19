/*
package com.shu.complocaldemo.material3Demo

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.SwipeMode
import androidx.constraintlayout.compose.SwipeMode.Companion.spring
import com.shu.complocaldemo.doc_compose.animation.shapes.Ball
import com.shu.complocaldemo.doc_compose.animation.shapes.Triangle
import kotlinx.coroutines.delay

@Composable
fun BallScaleIndicator() {
    // Creates the infinite transition
    val infiniteTransition = rememberInfiniteTransition(label = "")

    // Animate from 0f to 1f
    val animationProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800)
        ), label = ""
    )

    Ball(
        modifier = Modifier
            .scale(animationProgress)
            .alpha(1 - animationProgress),
    )
}

@Composable
fun BallPulseSyncIndicator() {
    val animationValues = (1..3).map { index ->
        var animatedValue by remember { mutableFloatStateOf(0f) }

        LaunchedEffect(key1 = Unit) {
            // Delaying using Coroutines
            delay(70L * index)

            animate(
                initialValue = 0f,
                targetValue = 12f,
                animationSpec = infiniteRepeatable(
                    // Remove delay property
                    animation = tween(durationMillis = 300),
                    repeatMode = RepeatMode.Reverse,
                )
            ) { value, _ -> animatedValue = value }
        }

        animatedValue
    }

    Row {
        animationValues.forEach { animatedValue ->
            Ball(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .offset(y = animatedValue.dp),
            )
        }
    }
}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun animateValues(
    values: List<Float>,
    animationSpec: AnimationSpec<Float> = spring(),
): State<Float> {
    // 1. Create the groups zipping with next entry
    val groups by rememberUpdatedState(newValue = values.zipWithNext())

    // 2. Start the state with the first value
    val state = remember { mutableFloatStateOf(values.first()) }

    LaunchedEffect(key1 = groups) {
        val (_, setValue) = state

        // Start the animation from 0 to groups quantity
        animate(
            initialValue = 0f,
            targetValue = groups.size.toFloat(),
            animationSpec = animationSpec,
        ) { frame, _ ->
            // Get which group is being evaluated
            val integerPart = frame.toInt()
            val (initialValue, finalValue) = groups[frame.toInt()]

            // Get the current "position" from the group animation
            val decimalPart = frame - integerPart

            // Calculate the progress between the initial and final value
            setValue(
                initialValue + (finalValue - initialValue) * decimalPart
            )
        }
    }

    return state
}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun TriangleSkewSpinIndicator() {
    val animationSpec = infiniteRepeatable<Float>(
        animation = tween(
            durationMillis = 2500,
            easing = LinearEasing,
        )
    )
    val xRotation by animateValues(
        values = listOf(0f, 180f, 180f, 0f, 0f),
        animationSpec = animationSpec
    )
    val yRotation by animateValues(
        values = listOf(0f, 0f, 180f, 180f, 0f),
        animationSpec = animationSpec
    )

    Triangle(
        modifier = Modifier.graphicsLayer(
            rotationX = xRotation,
            rotationY = yRotation,
        )
    )
}*/
