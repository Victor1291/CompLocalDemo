package com.shu.complocaldemo.doc_compose.animation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun ListHours(
    listWeather: List<NewWeather> = listOf(
        NewWeather(10, 60f, 70f),
        NewWeather(9, 70f, 80f),
        NewWeather(8, 80f, 90f),
        NewWeather(7, 90f, 80f),
        NewWeather(10, 80f, 70f),
        NewWeather(11, 70f, 60f),
        NewWeather(12, 60f, 40f),
        NewWeather(14, 40f, 20f),
        NewWeather(20, 20f, 10f),
        NewWeather(21, 10f, 0f),
        NewWeather(20, 0f, 10f),
        NewWeather(20, 10f, 20f),
        NewWeather(14, 20f, 30f),
    )
) {

    LazyRow(
        contentPadding = PaddingValues(2.dp),
        modifier = Modifier.
            padding(8.dp)
            .background(color = Color.White)
            .clip(
                RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
            ),
    ) {

        items(listWeather,
            key = { cat -> cat.hashCode() }
        ) { weather ->

            HoursCard(
                weather = weather,
               )
        }
    }
}


fun newlist(): List<NewWeather> {
    val list = mutableListOf<NewWeather>()
    for (number in 20 downTo 0) {
        list.add(NewWeather(number, number.toFloat(),number.toFloat()))
    }
    return list
}

@Preview(showBackground = true)
@Composable
fun ListHoursPreview() {
    CompLocalDemoTheme {
        ListHours()
    }
}