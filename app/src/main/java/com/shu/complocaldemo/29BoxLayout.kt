package com.shu.complocaldemo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun TextCellBox(text: String, modifier: Modifier = Modifier, fontSize: Int = 150, shape: Shape) {

    val cellModifier = Modifier
        .padding(4.dp)
        .clip(shape)
        .background(Color.Blue)
        .border(width = 1.dp, color = Color.Green, shape = shape)
        .padding(end = 10.dp)
        .border(width = 10.dp, color = Color.Black, shape = shape)
    Box(
        cellModifier.then(modifier),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text, Modifier.padding(start = 14.dp,top = 14.dp),
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black
        )

        Text(
            text = text, Modifier,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Green
        )
    }
}

@Composable
fun BoxLayout(modifier: Modifier = Modifier) {

    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = modifier.size(400.dp, 600.dp).background(Color.Black)
    ) {
        val height = 180.dp
        val width = 180.dp
        TextCellBox(
            "1",
            Modifier
                .size(width = width, height = height)
                .align(Alignment.CenterStart),
            shape = CircleShape
        )
        TextCellBox("2", Modifier.size(width = width, height = height), shape = RectangleShape)
        TextCellBox(
            "3",
            Modifier
                .size(width = width, height = height)
                .align(Alignment.BottomCenter),
            shape = CutCornerShape(20.dp)
        )
    }

    Box(modifier = modifier.size(height = 90.dp, width = 300.dp).background(Color.Green)) {

        Text("TopStart", Modifier.align(Alignment.TopStart))
        Text("TopCenter", Modifier.align(Alignment.TopCenter))
        Text("TopEnd", Modifier.align(Alignment.TopEnd))
        Text("CenterStart", Modifier.align(Alignment.CenterStart))

        Text("Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
        Text("BottomStart", Modifier.align(Alignment.BottomStart))
        Text("BottomCenter", Modifier.align(Alignment.BottomCenter))
        Text("BottomEnd", Modifier.align(Alignment.BottomEnd))
    }


}


@Preview(showBackground = true)
@Composable
fun BoxLayoutDemoPreview() {
    CompLocalDemoTheme {
        BoxLayout()
    }
}