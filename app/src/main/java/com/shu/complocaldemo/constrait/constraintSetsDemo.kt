package com.shu.complocaldemo.constrait

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun ConstraintSetsDemo(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.size(width = 400.dp, height = 250.dp)) {

        val constraints = myConstraintSet(margin = 8.dp)

        ConstraintLayout(constraints, modifier.size(width = 200.dp, height = 200.dp)) {
            MyButton(
                text = "Button1",
                Modifier
                    .size(200.dp)
                    .layoutId("button1")
            )

        }
    }
}

private fun myConstraintSet(margin: Dp): ConstraintSet {

    return ConstraintSet {
        val button1 = createRefFor("button1")
        constrain(button1) {
            linkTo(
                parent.top, parent.bottom, topMargin = margin,
                bottomMargin = margin
            )
            linkTo(
                parent.start, parent.end, startMargin = margin,
                endMargin = margin
            )
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintSetsPreview() {
    CompLocalDemoTheme {
        ConstraintSetsDemo()
    }
}