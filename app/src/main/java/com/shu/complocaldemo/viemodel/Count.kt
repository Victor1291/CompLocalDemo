package com.shu.complocaldemo.viemodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    model: CountVieModel = viewModel()
) {
    MainScreen(model.customerCount) { model.increaseCount() }
}

@Composable
fun MainScreen(count: Int, addCount: () -> Unit = {}) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            "Total customers = $count",
            Modifier.padding(10.dp)
        )
        Button(onClick = addCount) {
            Text(text = "Add a Customer")
        }
    }
}