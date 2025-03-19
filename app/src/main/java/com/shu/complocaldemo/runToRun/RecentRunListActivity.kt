package com.shu.complocaldemo.runToRun

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.runforrun.ui.screens.home.components.Run

@Composable
fun RecentRunListActivity(
    modifier: Modifier = Modifier,
    runList: List<Run>,
    showRunDialog: (Run) -> Unit,
    paddingValues: PaddingValues
) {
    runList.forEachIndexed { _, run ->
        Column(
            modifier = modifier
        ) {
            RunningCard(
                run = run,
                modifier = Modifier
                    .clickable { showRunDialog(run) }
            )
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
    Spacer(modifier = Modifier.padding(paddingValues = paddingValues))
}