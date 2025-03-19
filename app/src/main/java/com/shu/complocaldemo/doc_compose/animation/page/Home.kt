package com.shu.complocaldemo.doc_compose.animation.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    openEasingDemo: () -> Unit,
    openValueAnimatorDemo: () -> Unit,
    materialDemo: () -> Unit,
    listItemDemo: () -> Unit,
    alertDemo: () -> Unit,
    composeDemo: () -> Unit,
    staggeredDemo: () -> Unit,
    pagerDemo: () -> Unit,
    drawerDemo: () -> Unit,
    hoursDemo: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Compose Animations Demo") },
            )
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            HomeContent(
                openEasingDemo = openEasingDemo,
                openValueAnimatorDemo = openValueAnimatorDemo,
                materialDemo = materialDemo,
                listItemDemo = listItemDemo,
                alertDemo = alertDemo,
                composeDemo = composeDemo,
                staggeredDemo = staggeredDemo,
                pagerDemo = pagerDemo,
                drawerDemo = drawerDemo,
                hoursDemo = hoursDemo,
            )
        }
    }
}

@Composable
private fun HomeContent(
    openEasingDemo: () -> Unit,
    openValueAnimatorDemo: () -> Unit,
    materialDemo: () -> Unit,
    listItemDemo: () -> Unit,
    alertDemo: () -> Unit,
    composeDemo: () -> Unit,
    staggeredDemo: () -> Unit,
    pagerDemo: () -> Unit,
    drawerDemo: () -> Unit,
    hoursDemo: () -> Unit,
) {
    val allDemos = listOf(
        "Easing" to openEasingDemo,
        "Value Animator" to openValueAnimatorDemo,
        "Material 3" to materialDemo,
        "ListItem" to listItemDemo,
        "AlertDialog" to alertDemo,
        "Compose Demo" to composeDemo,
        "Staggered Grid Demo" to staggeredDemo,
        "Pager Demo" to pagerDemo,
        "Drawer Demo" to drawerDemo,
        "Hours Demo" to hoursDemo,
            )

    LazyColumn {
        items(allDemos) { (name, callback) ->
            DemoLink(name = name, onClick = callback)
        }
    }
}

@Composable
private fun DemoLink(
    name: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null)
    }
}

@Composable
@Preview
fun DemoLinkPreview() {
    DemoLink("Hello World") {}
}
