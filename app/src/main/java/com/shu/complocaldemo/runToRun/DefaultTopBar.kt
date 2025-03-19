package com.shu.complocaldemo.runToRun

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import com.shu.complocaldemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    modifier: Modifier = Modifier,
    title: String,
    navigateUp: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = title,)
        },
        navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.ic_baseline_play_circle),
                    contentDescription = null
                )
            }
        }
    )
}