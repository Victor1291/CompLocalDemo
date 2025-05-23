package com.shu.complocaldemo.doc_compose.animation.animator.utils

import androidx.compose.ui.geometry.Size

operator fun Size.minus(other: Size): Size = Size(
    width = this.width - other.width,
    height = this.height - other.height
)

operator fun Size.plus(other: Size): Size = Size(
    width = this.width + other.width,
    height = this.height + other.height
)
