package com.shu.complocaldemo.doc_compose.animation.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shu.complocaldemo.gestures.MultiTouchDemo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiTouchPage(goBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MultiTouch") },
                navigationIcon = {
                    IconButton(onClick = goBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                }
            )
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            ComposePageContent()
        }
    }
}

@Composable
private fun ComposePageContent() {
    MultiTouchDemo()
}


