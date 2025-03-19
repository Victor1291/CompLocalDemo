package com.shu.complocaldemo.doc_compose

object ConstrDemo {

    val sample = "\n" + """
        
    """.trimIndent() + "\n"

    val constraintChain = "\n" + """
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
    """.trimIndent() + "\n"

    val guideLinesDemo = "\n" + """
        @Composable
        fun GuideLinesDemo(modifier: Modifier = Modifier) {
            ConstraintLayout(modifier.size(width = 400.dp, height = 250.dp)) {

                ConstraintLayout(modifier.size(width = 400.dp, height = 350.dp)) {

                    val (button1, button2, button3) = createRefs()

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
                }
            }
        }
    """.trimIndent() + "\n"

    val barriersDemo = "\n" + """
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
    """.trimIndent() + "\n"

    val constraintSetsDemo = "\n" + """
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
    """.trimIndent() + "\n"

    val intrinsicMaxDemo = "\n" + """
@Composable
fun IntrinsicMaxDemo(modifier: Modifier = Modifier) {

    var textState by remember { mutableStateOf("") }

    val onTextChange = { text: String ->
        textState = text
    }
    Column(
        modifier
            .width(200.dp)
            .padding(5.dp)) {

        Column(Modifier.width(IntrinsicSize.Max)) {

            Text(
                modifier = Modifier
                    .padding(start = 4.dp),
                text = textState
            )
            Box(
                Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(androidx.compose.ui.graphics.Color.Blue)
            )
        }
        MyTextField(text = textState, onTextChange = onTextChange)
    }
}
    """.trimIndent() + "\n"

    val intrinsicMinDemo = "\n" + """
       @Composable
fun IntrinsicMinDemo(modifier: Modifier = Modifier) {

    var textState by remember { mutableStateOf("") }

    val onTextChange = { text: String ->
        textState = text
    }
    Column(
        modifier
            .width(200.dp)
            .padding(5.dp)) {

        Column(Modifier.width(IntrinsicSize.Min)) {

            Text(
                modifier = Modifier
                    .padding(start = 4.dp),
                text = textState
            )
            Box(
                Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(androidx.compose.ui.graphics.Color.Blue)
            )
        }
        MyTextField(text = textState, onTextChange = onTextChange)
    }
}
    """.trimIndent() + "\n"

}