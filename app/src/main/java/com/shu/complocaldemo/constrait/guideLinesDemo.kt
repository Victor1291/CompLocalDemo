package com.shu.complocaldemo.constrait

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun GuideLinesDemo(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.size(width = 400.dp, height = 700.dp)) {

        ConstraintLayout(modifier.size(width = 400.dp, height = 700.dp)) {

            val (button1, button2, button3, button4, button5, button6) = createRefs()

            val guide = createGuidelineFromStart(fraction = .60f)

            MyButton(text = "Button1", Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 30.dp)
                end.linkTo(guide, margin = 30.dp)
            })

            MyButton(text = "Button2", Modifier.constrainAs(button2) {
                top.linkTo(button1.bottom, margin = 20.dp)
                start.linkTo(guide, margin = 40.dp)
            })

            MyButton(text = "Button3", Modifier.constrainAs(button3) {
                top.linkTo(button2.bottom, margin = 40.dp)
                end.linkTo(guide, margin = 20.dp)
            })

            //Новые
            val guideNew = createGuidelineFromStart(fraction = .60f)

            MyButton(text = "Button4", Modifier.constrainAs(button4) {
                top.linkTo(button3.bottom, margin = 0.dp)
                start.linkTo(guideNew, margin = 0.dp)
            })

            MyButton(text = "Button5", Modifier.constrainAs(button5) {
                top.linkTo(button4.bottom, margin = 0.dp)
                start.linkTo(guideNew, margin = 0.dp)
            })

            MyButton(text = "Button6", Modifier.constrainAs(button6) {
                top.linkTo(button5.bottom, margin = 0.dp)
                start.linkTo(guideNew, margin = 0.dp)
            })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GuideLinesPreview() {
    CompLocalDemoTheme {
        GuideLinesDemo()
    }
}