package com.shu.complocaldemo

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun MainScreen3(modifier: Modifier = Modifier) {

    Column(modifier, verticalArrangement = Arrangement.Center) {
        Row {
            Column {
                TextCell("1")
                TextCell("2")
                TextCell("3")
            }
            Column {
                TextCell("4")
                TextCell("5")
                TextCell("6")
            }
            Column {
                TextCell("7")
                TextCell("8")
            }
        }
        Row {
            TextCell("9")
            TextCell("10")
            TextCell("11")
        }

        Row(modifier = modifier.height(300.dp)) {

            TextCell("1", Modifier.align(Alignment.Top))

            TextCell("2", Modifier.align(Alignment.CenterVertically))

            TextCell("3", Modifier.align(Alignment.Bottom))

        }
    }
}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier) {

    val cellModifier = modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Black)

    Text(
        text = text,
        cellModifier.then(modifier),
        fontSize = 80.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextRow(modifier: Modifier = Modifier) {

    Column(modifier) {

        /*

     */
        Row {
            Text(
                text = "Large Text",
                modifier = Modifier.alignByBaseline(),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Small Text",
                modifier = Modifier.alignByBaseline(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row {
            Text(
                text = " Large2 Text\n\nMore2 Text ",
                // modifier = Modifier .alignBy(LastBaseline) ,
                modifier = Modifier.alignBy(FirstBaseline),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Small Text",
                Modifier.alignByBaseline(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Row {
            Text(
                text = "Large3 Text\n\nMore3 Text",

                Modifier.alignBy(FirstBaseline),

                fontSize = 40.sp,

                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Small Text",
                modifier = Modifier.paddingFrom(
                    alignmentLine = FirstBaseline, before = 63.dp, after = 0.dp
                ),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row {
            TextCell("1", Modifier.weight(weight = 0.2f, fill = true))
            TextCell("Wei", Modifier.weight(weight = 0.4f, fill = true))
            TextCell("3", Modifier.weight(weight = 0.3f, fill = true))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RowColumnPreview() {
    CompLocalDemoTheme {
        MainScreen3()
    }
}

@Preview(showBackground = true)
@Composable
fun RowColumnTextPreview() {
    CompLocalDemoTheme {
        TextRow()
    }
}

