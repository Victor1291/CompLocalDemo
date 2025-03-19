package com.shu.complocaldemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowColumnDemo(modifier: Modifier = Modifier) {

    val items = (1..24).map {
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

    Column(
        modifier
            .width(300.dp)
    ) {

        FlowColumn(
            modifier
                .width(300.dp)
                .height(120.dp),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center
        ) {
            items.forEach { properties ->
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .width(30.dp)
                        .height(properties.height)
                        .clip(RoundedCornerShape(8.dp))
                        .background(properties.color)
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .width(300.dp)
                .height(10.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Black)
        )

        FlowColumn(
            modifier
                .width(300.dp)
                .height(120.dp),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center
        ) {
            items.forEachIndexed { index, properties ->

                var weight = 0.5f
                if (index % 2 == 0) {
                    weight = 2f
                } else if (index % 3 == 0) {
                    weight = 3f
                }

                Box(
                    modifier = Modifier
                        .weight(weight)
                        .padding(2.dp)
                        .width(30.dp)
                        .height(30.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(properties.color)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowColumnDemoPreview() {
    CompLocalDemoTheme {
        FlowColumnDemo()
    }
}
