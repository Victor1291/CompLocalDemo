package com.shu.complocaldemo.constrait

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun ConstraintScreen(modifier: Modifier = Modifier) {

    ConstraintLayout(modifier.size(width = 200.dp, height = 200.dp)) {
        val (button1, button2, button3) = createRefs()
      /*  MyButton(
            text = "Button1",
            Modifier.constrainAs(button1) {
               // start.linkTo(parent.start, margin = 30.dp)
              *//*  top.linkTo(parent.top, margin = 60.dp)
                *//**//*Можно кратко
                start.linkTo(parent.start)
                end.linkTo(parent.end)*//**//*
                linkTo(parent.start, parent.end)
*//*
                //Центровка
                centerVerticallyTo(parent)
                centerHorizontallyTo(parent)
            })*/

/*
Наиболее распространенной формой ограничения является ограничение между одной стороной
компонуемого элемента и одной стороной родительского ConstraintLayout или другого
 компонуемого элемента. Ограничения такого типа объявляются внутри Ограничения()
  завершающий лямбда-код через вызовы linkTo() функция. Существуют разные способы вызова
  linkTo() в зависимости от характера создаваемых ограничений. Например, следующий
  код привязывает верхние и нижние края компонента Text к верхним и нижним краям
  родительского экземпляра ConstraintLayout с отступом 16dp:

Text("Hello", modifier = Modifier.constrainAs(text1) {

top.linkTo(parent.top, margin = 16.dp)

bottom.linkTo(parent.bottom, margin = 16.dp)

})

  В linkTo() В качестве параметров функции также можно передать несколько ограничений.

  Text("Hello", modifier = Modifier.constrainAs(mytext) {

linkTo(parent.top, parent.bottom, bias = 0.8f)

linkTo(button1.end, button2.start)

})
 */

        MyButton(text = "Button1", Modifier.constrainAs(button1)

        {
            centerHorizontallyTo(parent)
            top.linkTo(parent.top)
            bottom.linkTo(button2.top)
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2)
        {
            centerHorizontallyTo(parent)
            top.linkTo(button1.bottom)
            bottom.linkTo(parent.bottom)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintPreview() {
    CompLocalDemoTheme {
        ConstraintScreen()
    }
}