package com.shu.complocaldemo.doc_compose.animation.page

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.Material3Item


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3Page(goBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Easing functions") },
                navigationIcon = {
                    IconButton(onClick = goBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                }
            )
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            Material3Content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Material3Content() {
    var isShowDialog by remember { mutableStateOf(false) }
    var textDialog by remember { mutableStateOf("New Message") }
    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        item {
            Material3Item("Material3", isShowDialogClick =
            { isShow, textNew ->
                textDialog = textNew
                isShowDialog = isShow
            })
        }

    }
    if (isShowDialog) {
        BasicAlertDialog(onDismissRequest = { isShowDialog = false }) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(
                    Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = textDialog,
                        modifier = Modifier.verticalScroll(ScrollState(0))
                    )
                }
            }
        }
    }
}



