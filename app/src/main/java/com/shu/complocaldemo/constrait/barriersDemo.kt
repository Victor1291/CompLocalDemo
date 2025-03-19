package com.shu.complocaldemo.constrait

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun BarriersDemo(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.size(width = 400.dp, height = 250.dp)) {

        ConstraintLayout(modifier.size(width = 350.dp, height = 220.dp)) {

            val (button1, button2, button3) = createRefs()
            val barrier = createEndBarrier(button1, button2)

            MyButton(text = "Button1",
                Modifier
                    .width(100.dp)
                    .constrainAs(button1) {
                        top.linkTo(parent.top, margin = 30.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                    })

            MyButton(text = "Button2",
                Modifier
                    .width(160.dp)
                    .constrainAs(button2) {
                        top.linkTo(button1.bottom, margin = 20.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                    })

            MyButton(text = "Button3", Modifier.constrainAs(button3) {
                linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
                linkTo(button1.end, parent.end, startMargin = 30.dp, endMargin = 8.dp)
                start.linkTo(barrier, margin = 30.dp)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints

            })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BarrierPreview() {
    CompLocalDemoTheme {
        BarriersDemo()
    }
}