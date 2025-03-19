package com.shu.complocaldemo

import android.widget.ScrollView
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GraphicDemo(
     state: ScrollState = rememberScrollState()
) {

    val months: List<String> = listOf(
        "NONE",
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December",
    )
    Column() {
        Row(
            modifier = Modifier
                .background(Color.Black)
                .width(700.dp)
                .horizontalScroll(state)
        ) {
            WeeksColumn()
            WorkColumn()
        }
        ItogGraphic(workerOne = "workerOne", workerTwo = "workerTwo")
    }
}


@Composable
fun CellGraphic(text: String, modifier: Modifier = Modifier) {

    val color1: Int =
        android.graphics.Color.argb(255, 133, 204, 99)
    val color2: Int =
        android.graphics.Color.argb(255, 255, 253, 218)

    val cellModifier = modifier
        .padding(2.dp)
        .width(120.dp)
        .height(80.dp)
        //.border(width = 1.dp, color = Color.Black)
    Column(
        modifier = cellModifier.then(modifier).drawBehind {
            drawRoundRect(
                Color(0xFFBBAAEE),
                cornerRadius = CornerRadius(10.dp.toPx())
            )
        }
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                drawRoundRect(
                    Brush.linearGradient(colors = listOf(Color(color1), Color(color2))),
                    cornerRadius = CornerRadius(10.dp.toPx())
                )
            }
            ,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )
    }
}

@Composable
fun ItogGraphic(workerOne: String, workerTwo: String,modifier: Modifier = Modifier) {

    val color1: Int =
        android.graphics.Color.argb(255, 133, 204, 99)
    val color2: Int =
        android.graphics.Color.argb(255, 255, 253, 218)

    val cellModifier = modifier
        .padding(2.dp)
        .width(114.dp)
        .wrapContentHeight()
    //.border(width = 1.dp, color = Color.Black)
    Column(
        modifier = cellModifier.then(modifier.background(Color.White)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = workerOne,
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.linearGradient(colors = listOf(Color(color1), Color(color2)))),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )
        Text(
            text = workerTwo,
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.linearGradient(colors = listOf(Color(color1), Color(color2)))),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )
    }
}

@Composable
fun WorkGraphic(
    modifier: Modifier = Modifier,
    day: String,
    workerOne: String,
    workerTwo: String,
) {

    val color1: Int =
        android.graphics.Color.argb(255, 133, 204, 99)
    val color2: Int =
        android.graphics.Color.argb(255, 255, 253, 218)

    val cellModifier = modifier
        .padding(2.dp)
        .width(120.dp)
        .height(80.dp)
       // .border(width = 1.dp, color = Color.Black)

    Column(
        modifier = cellModifier.then(modifier).drawBehind {
            drawRoundRect(
                Color(0xFFBBAAEE),
                cornerRadius = CornerRadius(10.dp.toPx())
            )
        }
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawRoundRect(
                        Brush.linearGradient(colors = listOf(Color(color1), Color(color2))),
                        cornerRadius = CornerRadius(10.dp.toPx())
                    )
                },
            text = day,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = workerOne,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = workerTwo,
            fontSize = 16.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun WeeksColumn(modifier: Modifier = Modifier) {
    val weeks = listOf(
        "Воскресенье",
        "Понедельник",
        "Вторник",
        "Среда",
        "Четверг",
        "Пятница",
        "Суббота",
    )

    Column {
        for (week in weeks) {
            CellGraphic(text = week)
        }
    }
}

@Composable
fun WorkColumn(modifier: Modifier = Modifier) {
    val days = listOf(
        null,
        null,
        null,
        1,
        2,
        3,
        4,
        5,
        6,
        null,
        8,
        9,
        10,
        null,
        12,
        13,
        null,
        15,
        16,
        17,
        null,
        19,
        20,
        null,
        22,
        23,
        24,
        null,
        26,
        27,
        null,
        29,
        30,
        31,
        null,
        null
    )
    Row() {
        for (columnCount in 0..32 step 7)
            Column() {
                repeat(7) { day ->
                    if (days[columnCount + day] != null) {
                        WorkGraphic(
                            day = days[columnCount + day].toString(),
                            workerOne = "workerOne",
                            workerTwo = "workerTwo"
                        )
                    } else {
                        CellGraphic("")
                    }
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun RGraphicsPreview() {
    CompLocalDemoTheme {
        GraphicDemo()
    }
}