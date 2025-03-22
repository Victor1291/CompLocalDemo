package com.shu.complocaldemo.gestures

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import kotlin.math.roundToInt


@Composable
fun DragDemo(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize()) {
        var xOffset by remember { mutableStateOf(0f) }

        Box(
            modifier = Modifier
                .offset { IntOffset(xOffset.roundToInt(), 0) }
                .size(100.dp)
                .background(Color.Blue)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { distance ->
                        xOffset += distance
                    })
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DragPreview() {
    CompLocalDemoTheme {
        DragDemo()
    }
}
/*
В этом примере создаётся состояние для хранения текущего смещения по оси X и используется
в качестве координаты X для перетаскиваемого прямоугольника:

 var xOffset by remember { mutableStateOf(0f) }

Затем к блоку применяется модификатор draggable с параметром ориентации, установленным
на горизонтальное положение. Параметр состояния задается путем вызова Запомнить draggablestate()
 функция, замыкающая лямбда которой используется для получения текущего значения дельты и
  добавления его к состоянию xOffset. Это, в свою очередь, заставляет поле двигаться
   в направлении жеста перетаскивания
.draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { distance ->
                        xOffset += distance
                    })

                    В перетаскиваемый () Модификатор полезен только для поддержки жестов
                     перетаскивания в горизонтальной или вертикальной плоскости.
                      Для поддержки операций перетаскивания в нескольких направлениях
                       необходимо использовать функцию PointerInputScope detectDragGestures.

 */