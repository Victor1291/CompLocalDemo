package com.shu.complocaldemo.cube

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import kotlin.math.absoluteValue
import kotlin.random.Random

fun randomColor(): Color = Color(
    red = Random.nextFloat(),
    green = Random.nextFloat(),
    blue = Random.nextFloat(),
    alpha = 1f
)

@Composable
fun CubePager() {
    val pagerState = rememberPagerState(pageCount = { 13 })
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState,
        beyondViewportPageCount = 2
    ) {
        val color = remember { randomColor() }

        Box(
            Modifier
                .animateCube(it, pagerState)
                .fillMaxSize()
                .background(color)
        )
    }
}

fun Modifier.animateCube(page: Int, pagerState: PagerState) = graphicsLayer {
    cameraDistance = 28f
    val pageOffset = pagerState.getOffsetDistanceInPages(page)
    alpha = when {
        pageOffset < -1f -> 0f
        pageOffset <= 0 -> {
            rotationY = -90f * pageOffset.absoluteValue
            transformOrigin = TransformOrigin(pivotFractionX = 1f, pivotFractionY = 0.5f)
            1f
        }

        pageOffset <= 1 -> {
            rotationY = 90f * pageOffset.absoluteValue
            transformOrigin = TransformOrigin(0f, 0.5f)
            1f
        }

        else -> 0f
    }
}