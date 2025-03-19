package com.shu.complocaldemo.doc_compose.animation.weather

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import kotlin.math.roundToInt

@Composable
fun HoursCard3(
    weather: NewWeather,
) {

    val pathLine: Path = Path()


    drawRandomInPath(pathLine, 180.0, 200.0, weather)




    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        modifier = Modifier
            .width(60.dp)
            .height(200.dp)
            .background(
                Color(
                    red = 0.28235295f,
                    green = 0.19215687f,
                    blue = 0.6156863f,
                    alpha = 1f
                )
            )
        //  .padding(start = 4.dp, top = 8.dp, end = 4.dp, bottom = 8.dp)
    ) {

      /*  Text(
            text = "+ ${weather.current} ",// hours.time?.takeLast(5) ?: "no data", //"12 AM",
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = (-0.5).sp,
            lineHeight = 20.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .width(50.dp)
                .padding(top = 8.dp)
                .alpha(1f),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
        )*/
        // We can disable implicit caching since we will cache in DrawWithCache
        val textMeasurer = rememberTextMeasurer(cacheSize = 0)
        // Apply the current text style from theme, otherwise TextStyle.Default will be used.
        val materialTextStyle = LocalTextStyle.current
        val sizeSquare = 10f
        val square = Path().apply {
            lineTo(sizeSquare, 0f)
            lineTo(sizeSquare, 30f)
            lineTo(0f, 30f)
            close()
        }

        // Animate color repeatedly
      //  val infiniteTransition = rememberInfiniteTransition(label = "ColorAnimation")
      /*  val color by infiniteTransition.animateColor(
            initialValue = Color.White,
            targetValue = Color.Blue,
            animationSpec = infiniteRepeatable(tween(1000)), label = "ColorAnimation"
        )*/
     //   val textMeasurer = rememberTextMeasurer()
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .height(40.dp)
                .drawWithCache {
                    // Text layout will be measured just once until the size of the drawing area or
                    // materialTextStyle changes.
                    val textLayoutResult = textMeasurer.measure(
                        text = "+ ${weather.current}",
                        style = materialTextStyle,
                        constraints = Constraints.fixed(
                            width = size.width.roundToInt() ,//(size.width / 2).roundToInt(),
                            height = size.height.roundToInt()
                        ),
                       // overflow = TextOverflow.Ellipsis
                    )
                    // color changes will only invalidate draw phase
                    onDrawWithContent {
                        drawText(
                            textLayoutResult,
                            color = Color.White,
                            topLeft = Offset(
                                (size.width - textLayoutResult.size.width) / 2 + 30f,
                                (weather.startY - textLayoutResult.size.height) / 2 ,
                            )
                        )
                      /*  drawCircle(color,10f,center = Offset(
                            (size.width - textLayoutResult.size.width / 4),
                            (weather.startY - textLayoutResult.size.height) / 2 - 10f ,
                        ))*/
                        drawContent()
                        drawLine(
                            color = Color.Green,
                            start = Offset(0f, weather.startY),
                            end = Offset(size.width, weather.endY),
                            strokeWidth = 5.0f,
                            // pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,20f))
                        )
                        drawLine(
                            color = Color.Green,
                            start = Offset(0f, weather.startY),
                            end = Offset(size.width, weather.endY),
                            strokeWidth = 5.0f,
                           // pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,20f))
                            pathEffect = PathEffect.stampedPathEffect(
                                shape = square,
                                style = StampedPathEffectStyle.Rotate,
                                phase = 0f,
                                advance = 30f
                            )
                        )
                        drawLine(
                            color = Color.Green,
                            start = Offset(0f, weather.startY + 30f),
                            end = Offset(size.width, weather.endY + 30f) ,
                            strokeWidth = 5.0f,
                            // pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,20f))
                        )
                    }
                }
        ) {
          //  drawText(textMeasurer, "+ ${weather.current}", topLeft = Offset(40f, weather.startY - 60f), style = TextStyle(color = Color.White))

        }



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.background(
                Color(
                    red = 0.28235295f,
                    green = 0.19215687f,
                    blue = 0.6156863f,
                    alpha = 1f
                )
            )
        ) {

            Text(
                text = "@", // if (it >= 0) "+$it°" else "$it°", //"19°",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                textDecoration = TextDecoration.None,
                letterSpacing = 0.3799999952316284.sp,
                lineHeight = 16.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .alpha(1f),
                color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
            )
            /* AsyncImage(
                 modifier = Modifier
                     .fillMaxWidth()
                     .height(32.dp),
                 model = ImageRequest.Builder(context = LocalContext.current)
                     .data("https:${hours.condition?.icon}")
                     .build(),
                 contentDescription = "icon"
             )*/

            Text(
                text = "11,1 km/h",
                textAlign = TextAlign.Center,
                fontSize = 11.sp,
                textDecoration = TextDecoration.None,
                letterSpacing = (-0.07800000160932541).sp,
                lineHeight = 18.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(1f),
                color = Color(
                    red = 0.2509804f,
                    green = 0.79607844f,
                    blue = 0.84705883f,
                    alpha = 1f
                ),
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
            )

            Text(
                text = "11:00", // if (it >= 0) "+$it°" else "$it°", //"19°",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                textDecoration = TextDecoration.None,
                letterSpacing = 0.3799999952316284.sp,
                lineHeight = 16.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .alpha(1f),
                color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
            )
        }
    }
}


private fun drawRandomInPath(
    path: Path,
    canvasWidth: Double,
    canvasHeight: Double,
    weather: NewWeather,
) {
    path.moveTo(
        0f,
        weather.startY
    )


    path.lineTo(
        canvasWidth.toFloat(),
        weather.endY

    )


}


@Preview(showBackground = true)
@Composable
fun HoursCard3Preview() {
    CompLocalDemoTheme {
        // HoursCard2()
    }
}
