package com.shu.complocaldemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowDemo(modifier: Modifier = Modifier) {

    val items = (1..12).map {
        ItemProperties(
            width = Random.nextInt(20, 100).dp,
            height = Random.nextInt(10, 40).dp,
            color = Color(
                Random.nextInt(255),
                Random.nextInt(255),
                Random.nextInt(255),
                255
            )
        )
    }

    Column {

        FlowRow(modifier.width(300.dp)) {

            items.forEach { properties ->
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .width(properties.width)
                        .height(30.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(properties.color)
                )
            }
        }

        Spacer(modifier = Modifier.width(20.dp))

        FlowRow(
            modifier.width(300.dp),
            horizontalArrangement = Arrangement.End
        ) {
            items.forEach { properties ->
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .width(properties.width)
                        .height(30.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(properties.color)
                )
            }
        }

        FlowRow(
            modifier.width(300.dp),
            horizontalArrangement = Arrangement.End
        ) {
            items.forEach { properties ->
                Box(modifier = Modifier
                    .padding(2.dp)
                    .width(properties.width)
                    .height( properties.height )
                    .clip(RoundedCornerShape(8.dp))
                    .background(properties.color)
                )
            }
        }

        FlowRow(
            modifier.width(300.dp),
            horizontalArrangement = Arrangement.End
        ) {
            items.forEach { properties ->
                Box(modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(2.dp)
                    .width(properties.width)
                    .height(properties.height)
                    .clip(RoundedCornerShape(8.dp))
                    .background(properties.color)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowRowDemoPreview() {
    CompLocalDemoTheme {
        FlowRowDemo()
    }
}
