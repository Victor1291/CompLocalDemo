package com.shu.complocaldemo.constrait

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme


@Composable
fun ConstraintChain(modifier: Modifier = Modifier) {

    ConstraintLayout(modifier.size(width = 600.dp, height = 100.dp)) {

        val (button1, button2, button3) = createRefs()

        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.Spread)

        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            centerVerticallyTo(parent)
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        })
        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            centerVerticallyTo(parent)
        })
    }
}

/*
a chain may be arranged using Packed, Spread, or SpreadInside styles
 */

@Preview(showBackground = true)
@Composable
fun ConstraintChainPreview() {
    CompLocalDemoTheme {
        ConstraintChain()
    }
}