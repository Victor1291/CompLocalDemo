package com.shu.complocaldemo

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource


@Composable

fun CustomImage(image: Int,modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(image),
        contentDescription = null
    )
}