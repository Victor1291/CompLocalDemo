package com.shu.complocaldemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import kotlin.math.roundToInt


/*
чему я научился?
Научился делать кастомные modifier .
Какие случаи применения в демо?
1. Modifier.exampleLayout(x,y) смещение по координатам x,y от дефолтных значений 0,0
2.  Modifier.exampleFraction(0f) в модификаторе вычисляется смещение по x
 по формуле  val x = -(placeable.width * fraction).roundToInt() взависимости от ширины ,
  а у задан  функцией Column , которая даёт смещение по у.
3. Modifier.exampleBaseLine сдесь расматривается работа с BaseLine для composable функций
поддерживающих из применение. Примеры :
 */

@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .padding(1.dp)
            .size(width = 50.dp, height = 10.dp)
            .then(modifier)
    )
}

@Composable
fun LayoutModifierDemo(modifier: Modifier = Modifier) {

    Box(modifier = modifier.size(120.dp, 80.dp)) {
        ColorBox(
            Modifier
                .exampleLayout(90, 50)
                .background(Color.Blue)
        )

        Column {
            ColorBox(
                Modifier
                    .exampleFraction(0f)
                    .background(Color.Blue)
            )
            ColorBox(
                Modifier
                    .exampleFraction(0.25f)
                    .background(Color.Green)
            )
            ColorBox(
                Modifier
                    .exampleFraction(0.5f)
                    .background(Color.Yellow)
            )
            ColorBox(
                Modifier
                    .exampleFraction(0.25f)
                    .background(Color.Red)
            )
            ColorBox(
                Modifier
                    .exampleFraction(0.0f)
                    .background(Color.Magenta)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutModifierDemoPreview() {
    CompLocalDemoTheme {
        LayoutModifierDemo()
    }
}

fun Modifier.exampleLayout(
    x: Int,
    y: Int
) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x, y)
    }
}

/*
новое положение будет рассчитываться относительно координат по умолчанию,
 заданных родителем (которые будут равны 0, 0). Кроме того, модификатор
 теперь принимает параметр с плавающей точкой, представляющий положение
 линии вертикального выравнивания в процентах от ширины дочернего элемента
 */
fun Modifier.exampleFraction(
    fraction: Float
) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val x = -(placeable.width * fraction).roundToInt()
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x = x, y = 0)
    }
}


fun Modifier.exampleBaseLine(
    fraction: Float
) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    val firstBaseline = placeable[FirstBaseline]
    val lastBaseline = placeable[LastBaseline]

    if (placeable[FirstBaseline] == AlignmentLine.Unspecified) {

    // child passed to modifier does not support FirstBaseline alignment

    }
    val x = -(placeable.width * fraction).roundToInt()
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x = x, y = 0)
    }
}