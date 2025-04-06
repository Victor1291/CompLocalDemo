package com.shu.complocaldemo.gallery

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


private val DefaultItemSpace = Arrangement.spacedBy(4.dp)

/**
 * A composable function that creates a floating action menu.
 *
 * @param modifier The modifier to be applied to the layout.
 * @param content The composable content to be displayed within the menu.
 */
@Composable
@NonRestartableComposable
fun FloatingActionMenu(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.background, // (elevation = 2.dp),
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    content: @Composable RowScope.() -> Unit
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        content = {
            Row(
                horizontalArrangement = DefaultItemSpace,
                verticalAlignment = Alignment.CenterVertically,
                content = content,
                modifier = Modifier
                    .scale(0.85f)
                    .background(color, CircleShape)
                    .shadow(12.dp, shape = CircleShape)
                    .border(
                        0.5.dp,
                        MaterialTheme.colorScheme.background,
                        CircleShape
                    ) //(elevation = 4.dp)
                    .then(modifier)
                    .animateContentSize(),
            )
        }
    )
}