package com.shu.complocaldemo

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun ModifierScreen(modifier: Modifier = Modifier) {

    val myModifier = modifier
        .border(width = 2.dp, color = Color.Black)
        .padding(all = 10.dp)
    val secondModifier = Modifier.height(100.dp)

    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Hello Compose",
            modifier = myModifier.then(secondModifier),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        CustomImage(R.drawable.vacation,
            Modifier
                .padding(16.dp)
                .width(270.dp)
                .border(width = 2.dp, color = Color.Black)
                .clip(shape = RoundedCornerShape(30.dp))
            )
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierPreview() {
    CompLocalDemoTheme {
        ModifierScreen()
    }
}

/*
The following is a selection of some of the more commonly used functions:

• background - Draws a solid colored shape behind the composable.
Рисует сплошную цветную фигуру за составным элементом.

• clickable - Specifies a handler to be called when the composable is clicked. Also causes a ripple effect when the click is performed.
Указывает обработчик, который будет вызываться при нажатии на элемент. Также вызывает эффект ряби при нажатии.

• clip - Clips the composable content to a specified shape.
Обрезает составное содержимое до заданной формы.

• fillMaxHeight - The composable will be sized to fit the maximum height permitted by its parent.
Размер компонуемого элемента будет соответствовать максимальной высоте, разрешённой его родителем.

• fillMaxSize - The composable will be sized to fit the maximum height and width permitted by its parent.
Размер компонуемого элемента будет соответствовать максимальной высоте и ширине, разрешенным его родителем.

• fillMaxWidth - The composable will be sized to fit the maximum width permitted by its parent.
Размер компонуемого элемента будет соответствовать максимальной ширине, допустимой для родительского элемента.

• layout - Used when implementing custom layout behavior, a topic covered in the chapter entitled “Building Custom Layouts” .
Используется при реализации пользовательского поведения макета, тема которого рассматривается в главе под названием “Создание пользовательских макетов” .

• offset - Positions the composable the specified distance from its current position along the x and y-axis.
Располагает элемент на заданном расстоянии от его текущего положения по осям x и y.

• padding - Adds space around a composable. Parameters can be used to apply spacing to all four sides or to specify different padding for each side.
Добавляет пространство вокруг составного элемента. Параметры могут использоваться для применения отступов ко всем четырём сторонам или для указания разных отступов для каждой стороны.

• rotate - Rotates the composable on its center point by a specified number of degrees.
Поворачивает объект в его центральной точке на заданное количество градусов.

• scale - Increase or reduce the size of the composable by the specified scale factor.
Увеличьте или уменьшите размер композиции на заданный коэффициент масштабирования.

• scrollable - Enables scrolling for a composable that extends beyond the viewable area of the layout in which it is contained.
Включает прокрутку для элемента, который выходит за пределы видимой области макета, в котором он содержится.

• size - Used to specify the height and width of a composable. In the absence of a size setting, the composable will be sized to accommodate its content (referred to as wrapping ).
 <&#0;000p height="3pt" width="0pt" align="left"> 26.7 Combining modifiers
Используется для указания высоты и ширины компонуемого элемента.
При отсутствии настройки размера компонуемый элемент будет иметь размер, необходимый для размещения его содержимого (так называемый обертывание ).
 <&#0;000p высота="3pt" ширина="0pt"

 */
