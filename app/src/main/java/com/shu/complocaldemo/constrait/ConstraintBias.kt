package com.shu.complocaldemo.constrait

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme


//35.6
@Composable
fun ConstraintBias(modifier: Modifier = Modifier) {

    ConstraintLayout(modifier.size(width = 200.dp, height = 200.dp)) {
        val (button1, button2, button3, button4) = createRefs()

        //При предварительном просмотре кнопка 1 будет расположена на 75% ширины родительского элемента
        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            linkTo(parent.top, parent.bottom , bias = 0.75f)
            linkTo(parent.start, parent.end , bias = 0.75f )
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2) {
            top.linkTo(parent.top, margin = 5.dp)
            linkTo(parent.start, parent.end)
        })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            top.linkTo(parent.top, margin = 40.dp)
            linkTo(parent.start, parent.end, endMargin = 30.dp, bias = 1.0f)
        })

        MyButton(text = "Button4", Modifier.constrainAs(button4) {
            top.linkTo(parent.top, margin = 80.dp)
            linkTo(parent.start, parent.end , startMargin = 30.dp, endMargin = 50.dp )
        })
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintBiasPreview() {
    CompLocalDemoTheme {
        ConstraintBias()
    }
}

/*
Этот отступ также сохранится, если ширина родительского элемента уменьшится (например,
 при повороте устройства из альбомной ориентации в портретную) или если компонент слева,
  к которому привязана кнопка 1, увеличится в размере.

Даже без настройки смещения поля будут влиять на позиционирование компонента.
Например, следующий код устанавливает поля разной ширины для начальных и конечных ограничений кнопки1:
Button4
 */