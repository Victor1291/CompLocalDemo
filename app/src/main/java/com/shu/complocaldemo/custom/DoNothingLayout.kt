package com.shu.complocaldemo.custom


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun DoNothingLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        //Затем детей измеряют, и эти измерения сопоставляют со списком размещаемых объектов:
        val placeables = measurables.map { measurable ->
            // Measure each children
            measurable.measure(constraints)
        }
        //вызывается и получает максимальные значения высоты и ширины, разрешённые родителем.
        layout(constraints.maxWidth, constraints.maxHeight) {
            //перебирает каждого дочернего элемента
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = 0)
            }
        }
    }
}
/*
Пользовательский компонуемый макет также может быть разработан
для приёма дополнительных параметров, которые затем можно использовать
при вычислении свойств дочернего макета.
measurables - содержит все дочерние элементы, содержащиеся в содержимом,
constraints - содержит максимальные и минимальные значения
ширины и высоты, допустимые для дочерних элементов:
 */