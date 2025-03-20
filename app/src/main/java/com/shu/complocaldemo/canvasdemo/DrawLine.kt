package com.shu.complocaldemo.canvasdemo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.shu.complocaldemo.R
import kotlin.math.PI

@Preview
@Composable
fun DrawLine() {

    Canvas(modifier = Modifier.size(300.dp)) {

        val height = size.height
        val width = size.width

        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = width, y = height),
            color = Color.Blue,
            strokeWidth = 16.0f
        )
    }

}

@Preview
@Composable
fun DrawLinePathEffect() {

    Canvas(modifier = Modifier.size(300.dp)) {

        val height = size.height
        val width = size.width

        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = width, y = height),
            color = Color.Blue,
            strokeWidth = 16.0f,
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(30f, 10f, 10f, 10f), phase = 0f
            )
        )
    }
}

@Preview
@Composable
fun DrawRectDemo() {

    Canvas(modifier = Modifier.size(300.dp)) {

        val size = Size(600f, 250f)

        drawRect(
            color = Color.Blue,
            size = size
        )
    }
}

@Preview
@Composable
fun DrawRectPx() {

    Canvas(modifier = Modifier.size(300.dp)) {

        val size = Size(200.dp.toPx(), 100.dp.toPx())

        drawRect(
            color = Color.Blue,
            size = size
        )
    }
}

@Preview
@Composable
fun DrawRectSize() {

    Canvas(modifier = Modifier.size(300.dp)) {

        // val size = Size(200.dp.toPx(), 100.dp.toPx())

        drawRect(
            color = Color.Blue,
            size = size / 2f
        )
    }
}

@Preview
@Composable
fun DrawRectTopLeft() {

    Canvas(modifier = Modifier.size(300.dp)) {

        drawRect(
            color = Color.Blue,
            topLeft = Offset(x = 350f, y = 300f),
            size = size / 2f
        )
    }
}

@Composable
fun DrawRectInset() {
    Canvas(modifier = Modifier.size(300.dp)) {

        inset(100f, 200f) {

            drawRect(
                color = Color.Blue,
                size = size / 2f
            )
        }
    }
}

@Preview
@Composable
fun DrawRectCorner() {
    Canvas(modifier = Modifier.size(300.dp)) {

        val size = Size(
            width = 280.dp.toPx(),
            height = 200.dp.toPx()
        )
        drawRoundRect(
            color = Color.Blue,
            size = size,
            topLeft = Offset(20f, 20f),
            style = Stroke(width = 8.dp.toPx()),
            cornerRadius = CornerRadius(
                x = 30.dp.toPx(),
                y = 30.dp.toPx()
            )
        )
    }
}


@Preview
@Composable
fun DrawRect() {

    Canvas(modifier = Modifier.size(300.dp)) {

        rotate(45f) {
            drawRect(
                color = Color.Blue,
                topLeft = Offset(200f, 200f),
                size = size / 2f
            )
        }
    }
}

@Preview
@Composable
fun DrawCircle() {
    Canvas(modifier = Modifier.size(300.dp)) {

        drawCircle(
            color = Color.Blue,
            center = center,
            radius = 120.dp.toPx()
        )
    }
}


@Preview
@Composable
fun DrawOval() {

    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawOval(
            color = Color.Blue,
            topLeft = Offset(x = 25.dp.toPx(), y = 90.dp.toPx()),
            size = Size(
                width = canvasWidth - 50.dp.toPx(),
                height = canvasHeight / 2 - 50.dp.toPx()
            ),
            style = Stroke(width = 12.dp.toPx())
        )
    }
}

@Preview
@Composable
fun GradientFill() {

    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasSize = size
        val colorList: List<Color> = listOf(
            Color.Red, Color.Blue,
            Color.Magenta, Color.Yellow, Color.Green, Color.Cyan
        )
        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )
        drawRect(
            brush = brush,
            size = canvasSize
        )
    }
}

@Preview
@Composable
fun RadialFill() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val radius = 150.dp.toPx()
        val colorList: List<Color> = listOf(
            Color.Red, Color.Blue,
            Color.Magenta, Color.Yellow, Color.Green, Color.Cyan
        )

        val brush = Brush.radialGradient(
            colors = colorList,
            center = center,
            radius = radius,
            tileMode = TileMode.Repeated
        )

        drawCircle(
            brush = brush,
            center = center,
            radius = radius
        )
    }
}

@Preview
@Composable
fun ShadowCircle() {

    Canvas(modifier = Modifier.size(300.dp)) {
        val radius = 150.dp.toPx()
        val colorList: List<Color> =
            listOf(Color.Blue, Color.Black)
        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )

        drawCircle(
            brush = brush,
            radius = radius
        )
    }
}


@Preview
@Composable
fun DrawArc() {

    Canvas(modifier = Modifier.size(300.dp)) {
        drawArc(
            Color.Blue,
            startAngle = 20f,
            sweepAngle = 90f,
            useCenter = true,
            size = Size(250.dp.toPx(), 250.dp.toPx())
        )
    }
}

@Preview
@Composable
fun DrawPath() {

    Canvas(modifier = Modifier.size(300.dp)) {


        val path = Path().apply {
            moveTo(0f, 0f)
            // quadraticBezierTo(50.dp.toPx(), 200.dp.toPx(),
            quadraticTo(
                50.dp.toPx(), 200.dp.toPx(),
                300.dp.toPx(), 300.dp.toPx()
            )

            lineTo(270.dp.toPx(), 100.dp.toPx())
            // quadraticBezierTo(60.dp.toPx(), 80.dp.toPx(), 0f, 0f)
            quadraticTo(60.dp.toPx(), 80.dp.toPx(), 0f, 0f)
            close()
        }

        drawPath(
            path = path,
            Color.Blue,
        )
    }
}

@Preview
@Composable
fun DrawPoints() {

    Canvas(modifier = Modifier.size(300.dp)) {
        val height = size.height
        val width = size.width
        val points = mutableListOf<Offset>()
        for (x in 0..size.width.toInt()) {
            val y = (kotlin.math.sin(x * (2f * PI / width))
                    * (height / 2) + (height / 2)).toFloat()
            points.add(Offset(x.toFloat(), y))
        }

        drawPoints(
            points = points,
            strokeWidth = 3f,
            pointMode = PointMode.Points,
            color = Color.Blue
        )
    }
}

@Preview
@Composable
fun DrawImage() {

    val image = ImageBitmap.imageResource(id = R.drawable.vacation)

    Canvas(
        modifier = Modifier
            .size(360.dp, 270.dp)
    ) {
        drawImage(
            image = image,
            topLeft = Offset(x = 0f, y = 0f),
            colorFilter = ColorFilter.tint(
                color = Color(0xADFFAA2E),
                blendMode = BlendMode.ColorBurn
            )
        )
    }
}

@Preview
@Composable
fun DrawText() {

    val colorList: List<Color> = listOf(
        Color.Black,
        Color.Blue, Color.Yellow, Color.Red, Color.Green, Color.Magenta
    )
    val textMeasurer = rememberTextMeasurer()
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 60.sp,
                fontWeight = FontWeight.ExtraBold,
                brush = Brush.verticalGradient(colors = colorList)
            )
        ) {
            append("Text Drawing")
        }
    }
    Canvas(modifier = Modifier.size(300.dp)) {
        drawText(textMeasurer, annotatedText)
    }
}

@Preview
@Composable
fun DrawText2() {

    val colorList: List<Color> = listOf(
        Color.Black,
        Color.Blue, Color.Yellow, Color.Red, Color.Green, Color.Magenta
    )
    val textMeasurer = rememberTextMeasurer()
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 60.sp,
                fontWeight = FontWeight.ExtraBold,
                brush = Brush.verticalGradient(colors = colorList)
            )
        ) {
            append("Text Drawing")
        }
    }
    Canvas(modifier = Modifier.size(300.dp)) {

        val dimensions = textMeasurer.measure(annotatedText)

        drawRect(
            brush = Brush.horizontalGradient(colors = colorList),
            size = dimensions.size.toSize()
        )
        drawText(textMeasurer, annotatedText)
    }
}
