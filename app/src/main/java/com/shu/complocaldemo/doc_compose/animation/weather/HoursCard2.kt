package com.shu.complocaldemo.doc_compose.animation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun HoursCard2(
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
        val textMeasurer = rememberTextMeasurer()
        Text(
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
            /* .drawBehind {
                 drawPath(
                     path = pathLine,
                     color = Color.Green,
                     style = Stroke(
                         width = 6f,
                         cap = StrokeCap.Round,
                         join = StrokeJoin.Round
                     ),
                 )
                 */
            /* drawLine(
                                     color = Color.Green,
                                     start = Offset(0f, size.height / 2),
                                     end = Offset(size.width, size.height / 2),
                                     strokeWidth = 5.0f
                                 )*/
            /*
                            }*/
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    Color(
                        red = 0.28235295f,
                        green = 0.19215687f,
                        blue = 0.6156863f,
                        alpha = 1f
                    )
                )
                .drawBehind {
                    drawPath(
                        path = pathLine,
                        color = Color.Green,
                        style = Stroke(
                            width = 6f,
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round
                        ),
                    )
                  /*  drawLine(
                        color = Color.Green,
                        start = Offset(0f, size.height / 2),
                        end = Offset(size.width, size.height / 2),
                        strokeWidth = 5.0f
                    )*/
                })

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
fun HoursCard2Preview() {
    CompLocalDemoTheme {
        // HoursCard2()
    }
}
