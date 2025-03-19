package com.shu.complocaldemo.doc_compose.animation.page

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.R
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import kotlinx.coroutines.launch
import coil.compose.rememberAsyncImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItemPage(goBack: () -> Unit) {

    val itemArray: Array<String> = stringArrayResource(R.array.car_array)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("LazyList Demo") },
                navigationIcon = {
                    IconButton(onClick = goBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                }
            )
        },
    ) { innerPadding ->
        ListItemContent(
            itemArray = itemArray as Array<out String>,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ListItemContent(itemArray: Array<out String>, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val displayButton =
        remember { derivedStateOf { listState.firstVisibleItemIndex > 5 } }
    val context = LocalContext.current
    val groupedItems = itemArray.groupBy { it.substringBefore(' ') }

    val onListItemClick = { text: String ->

        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }

    Box(modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 50.dp)
        ) {
            groupedItems.forEach { (manufacturer, models) ->

                stickyHeader {
                    Text(
                        text = manufacturer,
                        color = Color.White,
                        modifier = Modifier
                            .background(Color.Gray)
                            .padding(5.dp)
                            .fillMaxWidth()
                    )
                }

                items(models) { model ->
                    MyListItem(item = model, onItemClick = onListItemClick)
                }
            }
        }

        AnimatedVisibility(
            visible = displayButton.value,
            Modifier.align(Alignment.BottomCenter)
        ) {

            OutlinedButton(
                onClick = {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                },
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.DarkGray
                ),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Top")
            }
        }
    }
}

@Composable
fun MyListItem(item: String, onItemClick: (String) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick(item) },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ImageLoader(item)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = item,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ImageLoader(item: String) {
    val url =
        "https://www.ebookfrenzy.com/book_examples/car_logos/" + item.substringBefore(" ") + "_logo.png"

    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = "car image",
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(75.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    val itemArray: Array<String> = arrayOf(
        "Cadillac Eldorado",
        "Ford Fairlane", "Plymouth Fury"
    )

    CompLocalDemoTheme {
        ListItemContent(itemArray = itemArray)
    }
}
