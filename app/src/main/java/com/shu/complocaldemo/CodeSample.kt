package com.shu.complocaldemo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.doc_compose.ConstrDemo
import com.shu.complocaldemo.doc_compose.ConstrDemo.constraintChain

object CodeSample {

    val blue = Color.Blue
    val red = Color.Red
    val magenta = Color.Magenta
    val green = Color.Green
    val gray = Color.Gray
    val black = Color.Black
    val size = 14.sp


    val modifierDemo =
        """
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
    """.trimIndent()


    val stateDemo =
        """
            @Composable
        fun MainScreen(modifier: Modifier = Modifier) {

            var linearSelected by remember { mutableStateOf(true) }
            var imageSelected by remember { mutableStateOf(true) }

            val onLinearClick = { value: Boolean ->
                linearSelected = value
            }

            val onTitleClick = { value: Boolean ->
                imageSelected = value
            }
            
            ScreenContent(
                linearSelected = linearSelected,
                imageSelected = imageSelected,
                onLinearClick = onLinearClick,
                onTitleClick = onTitleClick,
                titleContent = {
                    if (imageSelected) {
                        TitleImage(drawing = R.drawable.baseline_cloud_download_24)
                    } else {
                        Text(
                            "Downloading",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(30.dp)
                        )
                    }
                },
                progressContent = {
                    if (linearSelected) {
                        LinearProgressIndicator(Modifier.height(40.dp))
                    } else {
                        CircularProgressIndicator(
                            Modifier.size(200.dp),
                            strokeWidth = 18.dp
                        )
                    }
                })
        }
    """.trimIndent()


    val stringDemo =
        """
            @Composable
    fun MainScreen2(modifier: Modifier = Modifier) {

        Column(modifier.fillMaxWidth()) {
            SpanString()
            ParaString()
            BrushStyle()
            BrushStyle2()
            BrushStyle3()
        }

    }
    
     """.trimIndent()


    val spanString =
        """
            @Composable
    fun SpanString() {

        Text(
            buildAnnotatedString {

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                ) {
                    append("T")
                }
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("his")

                }
                append(" is ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Blue
                    )
                ) {
                    append("great!")
                }
            }
        )
    }
""".trimIndent()


    val paraString =
        """
            @Composable
    fun ParaString() {
        Text(
            buildAnnotatedString {
                append("\nThis is some text that doesn't have any style applied to it.\n")
                withStyle(
                    style = ParagraphStyle(
                        lineHeight = 30.sp,
                        textIndent = TextIndent(
                            firstLine = 60.sp,
                            restLine = 25.sp
                        ),
                    )
                ) {
                    append("This is some text that is indented more on the first lines than the rest of the lines. It also has an increased line height.\n")
                }
                withStyle(style = ParagraphStyle(textAlign = TextAlign.End)) {
                    append("\nThis is some text that is right aligned.")
                }
            })
    }
""".trimIndent()


    val brushStyle =
        """
            @Composable
    fun BrushStyle() {

        val colorList: List<Color> = listOf(
            Color.Red, Color.Blue,
            Color.Magenta, Color.Yellow, Color.Green, Color.Red
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 70.sp,
                        brush = Brush.linearGradient(colors = colorList),
                        baselineShift = BaselineShift.Subscript,
                        textDecoration = TextDecoration.Underline,
                        textGeometricTransform = TextGeometricTransform(0.6f,-0.7f),
                        shadow = Shadow(
                            Color.Gray.copy(alpha = 0.5f),
                            Offset(10f, 10f),
                            blurRadius = 10f
                        ),
                       // pushStyle(ParagraphStyle(textAlign = TextAlign.End))
                    ),
                ) {
                    append("COMPOSE!")
                }
            },
            textAlign = TextAlign.Center
        )
    }
""".trimIndent()


    val brushStyle2 =
        """
            @Composable
    fun BrushStyle2() {

        val colorList: List<Color> = listOf(
            Color.Red, Color.Blue,
            Color.Magenta, Color.Yellow, Color.Green, Color.Red
        )

        val stringStyle: AnnotatedString = AnnotatedString("COMPOSE")
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 70.sp,
                        brush = Brush.linearGradient(colors = colorList),
                        baselineShift = BaselineShift.Subscript,
                        textDecoration = TextDecoration.Underline,
                        shadow = Shadow(
                            Color.Gray.copy(alpha = 0.5f),
                            Offset(10f, 10f),
                            blurRadius = 10f
                        ),
                        // pushStyle(ParagraphStyle(textAlign = TextAlign.End))
                    ),
                ) {
                    append("COMPOSE!")
                }
            },
            textAlign = TextAlign.Center
        )
    }
""".trimIndent()


    val brushStyle3 =
        """
            @Composable
    fun BrushStyle3() {

        val colorList: List<Color> = listOf(
            Color.Red, Color.Blue,
            Color.Magenta, Color.Magenta, Color.Blue, Color.Red
        )

        val stringStyle: AnnotatedString = AnnotatedString(
            text = "SUPER COMPOSE!",
            spanStyle = SpanStyle(
                fontWeight = FontWeight.Thin,
                fontSize = 70.sp,
                brush = Brush.linearGradient(colors = colorList),
                baselineShift = BaselineShift.Subscript,
                textDecoration = TextDecoration.Underline,
                shadow = Shadow(
                    Color.Black.copy(alpha = 1f),
                    Offset(10f, 10f),
                    blurRadius = 10f
                ),
            ),
            paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center,
                lineHeight = 80.sp,
                lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Proportional,
                    LineHeightStyle.Trim.Both),
                textIndent = TextIndent(
                firstLine = 10.sp,
                restLine = 5.sp
            ),)
            )
        Text(
            text = stringStyle
        )
    }
""".trimIndent()


    val rowColumnCode =
        """
            @Composable
        fun MainScreen3(modifier: Modifier = Modifier) {

            Column(modifier, verticalArrangement = Arrangement.Center) {
                Row {
                    Column {
                        TextCell("1")
                        TextCell("2")
                        TextCell("3")
                    }
                    Column {
                        TextCell("4")
                        TextCell("5")
                        TextCell("6")
                    }
                    Column {
                        TextCell("7")
                        TextCell("8")
                    }
                }
                Row {
                    TextCell("9")
                    TextCell("10")
                    TextCell("11")
                }

                Row(modifier = modifier.height(300.dp)) {

                    TextCell("1", Modifier.align(Alignment.Top))

                    TextCell("2", Modifier.align(Alignment.CenterVertically))

                    TextCell("3", Modifier.align(Alignment.Bottom))

                }
            }
        }
    """.trimIndent()


    val textCell =
        """
            @Composable
    fun TextCell(text: String, modifier: Modifier = Modifier) {

        val cellModifier = modifier
            .padding(4.dp)
            .size(100.dp, 100.dp)
            .border(width = 4.dp, color = Color.Black)

        Text(
            text = text,
            cellModifier.then(modifier),
            fontSize = 80.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
""".trimIndent()


    val textRow =
        """
            @Composable
        fun TextRow(modifier: Modifier = Modifier) {

            Column(modifier) {
      
                Row {
                    Text(
                        text = "Large Text",
                        modifier = Modifier.alignByBaseline(),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Small Text",
                        modifier = Modifier.alignByBaseline(),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row {
                    Text(
                        text = " Large2 Text\n\nMore2 Text ",
                        // modifier = Modifier .alignBy(LastBaseline) ,
                        modifier = Modifier.alignBy(FirstBaseline),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Small Text",
                        Modifier.alignByBaseline(),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Row {
                    Text(
                        text = "Large3 Text\n\nMore3 Text",
                        Modifier.alignBy(FirstBaseline),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Small Text",
                        modifier = Modifier.paddingFrom(
                            alignmentLine = FirstBaseline, before = 63.dp, after = 0.dp
                        ),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row {
                    TextCell("1", Modifier.weight(weight = 0.2f, fill = true))
                    TextCell("Wei", Modifier.weight(weight = 0.4f, fill = true))
                    TextCell("3", Modifier.weight(weight = 0.3f, fill = true))
                }
            }
        }
    """.trimIndent()


    val boxLayout =
        """
            @Composable
        fun BoxLayout(modifier: Modifier = Modifier) {

            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = modifier.size(400.dp, 600.dp).background(Color.Black)
            ) {
                val height = 180.dp
                val width = 180.dp
                TextCellBox(
                    "1",
                    Modifier
                        .size(width = width, height = height)
                        .align(Alignment.CenterStart),
                    shape = CircleShape
                )
                TextCellBox("2", Modifier.size(width = width, height = height), shape = RectangleShape)
                TextCellBox(
                    "3",
                    Modifier
                        .size(width = width, height = height)
                        .align(Alignment.BottomCenter),
                    shape = CutCornerShape(20.dp)
                )
            }

            Box(modifier = modifier.size(height = 90.dp, width = 300.dp).background(Color.Green)) {

                Text("TopStart", Modifier.align(Alignment.TopStart))
                Text("TopCenter", Modifier.align(Alignment.TopCenter))
                Text("TopEnd", Modifier.align(Alignment.TopEnd))
                Text("CenterStart", Modifier.align(Alignment.CenterStart))

                Text("Center", Modifier.align(Alignment.Center))
                Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
                Text("BottomStart", Modifier.align(Alignment.BottomStart))
                Text("BottomCenter", Modifier.align(Alignment.BottomCenter))
                Text("BottomEnd", Modifier.align(Alignment.BottomEnd))
            }
        }
    """.trimIndent()


    val textCellBox =
        """
            @Composable
        fun TextCellBox(text: String, modifier: Modifier = Modifier, fontSize: Int = 150, shape: Shape) {

            val cellModifier = Modifier
                .padding(4.dp)
                .clip(shape)
                .background(Color.Blue)
                .border(width = 1.dp, color = Color.Green, shape = shape)
                .padding(end = 10.dp)
                .border(width = 10.dp, color = Color.Black, shape = shape)
            Box(
                cellModifier.then(modifier),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = text, Modifier.padding(start = 14.dp,top = 14.dp),
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Text(
                    text = text, Modifier,
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Green
                )
            }
        }
    """.trimIndent()


    val flowRowDemo =
        """
        @OptIn(ExperimentalLayoutApi::class)
        @Composable
        fun FlowRowDemo(modifier: Modifier = Modifier) {

            val items = (1..12).map {
                ItemProperties(
                    width = Random.nextInt(20, 100).dp,
                    height = Random.nextInt(10, 40).dp,
                    color = Color(
                        Random.nextInt(255),
                        Random.nextInt(255),
                        Random.nextInt(255),
                        255
                    )
                )
            }

            Column {

                FlowRow(modifier.width(300.dp)) {

                    items.forEach { properties ->
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .width(properties.width)
                                .height(30.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(properties.color)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(20.dp))

                FlowRow(
                    modifier.width(300.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    items.forEach { properties ->
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .width(properties.width)
                                .height(30.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(properties.color)
                        )
                    }
                }

                FlowRow(
                    modifier.width(300.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    items.forEach { properties ->
                        Box(modifier = Modifier
                            .padding(2.dp)
                            .width(properties.width)
                            .height( properties.height )
                            .clip(RoundedCornerShape(8.dp))
                            .background(properties.color)
                        )
                    }
                }

                FlowRow(
                    modifier.width(300.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    items.forEach { properties ->
                        Box(modifier = Modifier
                            .align(Alignment.Bottom)
                            .padding(2.dp)
                            .width(properties.width)
                            .height(properties.height)
                            .clip(RoundedCornerShape(8.dp))
                            .background(properties.color)
                        )
                    }
                }
            }
        }
    """.trimIndent()


    val flowColumnDemo =
        """
            @Composable
        @OptIn(ExperimentalLayoutApi::class)
        fun FlowColumnDemo(modifier: Modifier = Modifier) {

            val items = (1..24).map {
                ItemProperties(
                    width = Random.nextInt(20, 100).dp,
                    height = Random.nextInt(10, 40).dp,
                    color = Color(
                        Random.nextInt(255),
                        Random.nextInt(255),
                        Random.nextInt(255),
                        255
                    )
                )
            }

            Column(
                modifier
                    .width(300.dp)
            ) {

                FlowColumn(
                    modifier
                        .width(300.dp)
                        .height(120.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.Center
                ) {
                    items.forEach { properties ->
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .width(30.dp)
                                .height(properties.height)
                                .clip(RoundedCornerShape(8.dp))
                                .background(properties.color)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                        .width(300.dp)
                        .height(10.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Black)
                )

                FlowColumn(
                    modifier
                        .width(300.dp)
                        .height(120.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.Center
                ) {
                    items.forEachIndexed { index, properties ->

                        var weight = 0.5f
                        if (index % 2 == 0) {
                            weight = 2f
                        } else if (index % 3 == 0) {
                            weight = 3f
                        }

                        Box(
                            modifier = Modifier
                                .weight(weight)
                                .padding(2.dp)
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(properties.color)
                        )
                    }
                }
            }
        }
    """.trimIndent()


    val layoutModifierDemo =
        """
            @Composable
        fun ColorBox(modifier: Modifier = Modifier) {
            Box(
                Modifier
                    .padding(1.dp)
                    .size(width = 50.dp, height = 10.dp)
                    .then(modifier)
            )
        }

        @Composable
        fun LayoutModifierDemo(modifier: Modifier = Modifier) {

            Box(modifier = modifier.size(120.dp, 80.dp)) {
                ColorBox(
                    Modifier
                        .exampleLayout(90, 50)
                        .background(Color.Blue)
                )

                Column {
                    ColorBox(
                        Modifier
                            .exampleFraction(0f)
                            .background(Color.Blue)
                    )
                    ColorBox(
                        Modifier
                            .exampleFraction(0.25f)
                            .background(Color.Green)
                    )
                    ColorBox(
                        Modifier
                            .exampleFraction(0.5f)
                            .background(Color.Yellow)
                    )
                    ColorBox(
                        Modifier
                            .exampleFraction(0.25f)
                            .background(Color.Red)
                    )
                    ColorBox(
                        Modifier
                            .exampleFraction(0.0f)
                            .background(Color.Magenta)
                    )
                }
            }
        }
    """.trimIndent()

    val beatles = """
        @Composable
        fun Beatles() {
            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                val (imageMain, play, previous, next, text1, text2, artist, name) = createRefs()
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f)
                        .constrainAs(imageMain) {
                            centerHorizontallyTo(parent)
                            linkTo(parent.top, parent.bottom , bias = 0.35f)
                        },
                    painter = painterResource(id = R.drawable.abbey_road),
                    contentDescription = "image"
                )
                Image(
                    modifier = Modifier
                        .size(width = 80.dp, height = 80.dp)
                        .constrainAs(play) {
                            centerHorizontallyTo(parent)
                            top.linkTo(imageMain.bottom)
                            bottom.linkTo(text1.top)
                        },
                    painter = painterResource(id = R.drawable.ic_baseline_play_circle),
                    contentDescription = "image"
                )
                Image(
                    modifier = Modifier
                        .size(width = 80.dp, height = 80.dp)
                        .constrainAs(previous) {
                            top.linkTo(play.top)
                            bottom.linkTo(play.bottom)
                            end.linkTo(play.start, margin = 20.dp)
                        },
                    painter = painterResource(id = R.drawable.ic_baseline_skip_previous),
                    contentDescription = "image"
                )
                Image(
                    modifier = Modifier
                        .size(width = 80.dp, height = 80.dp)
                        .constrainAs(next) {
                            top.linkTo(play.top)
                            bottom.linkTo(play.bottom)
                            start.linkTo(play.end, margin = 20.dp)
                        },
                    painter = painterResource(id = R.drawable.ic_baseline_skip_next),
                    contentDescription = "image"
                )

                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .constrainAs(text1) {
                            centerHorizontallyTo(parent)
                            top.linkTo(play.bottom)
                            bottom.linkTo(artist.top)
                        },
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                //    brush = Brush.linearGradient(colors = colorList),
                                baselineShift = BaselineShift.Subscript,
                                textDecoration = TextDecoration.Underline,
                                // pushStyle(ParagraphStyle(textAlign = TextAlign.End))
                            ),
                        ) {
                            append("Исполнитель")
                        }
                    },
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .constrainAs(artist) {
                            centerHorizontallyTo(parent)
                            top.linkTo(text1.bottom)
                            bottom.linkTo(text2.top)
                        },
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = Color.Red,
                                //    brush = Brush.linearGradient(colors = colorList),
                                baselineShift = BaselineShift.Subscript,
                                // textDecoration = TextDecoration.Underline,
                                // pushStyle(ParagraphStyle(textAlign = TextAlign.End))
                            ),
                        ) {
                            append("The Beatles")
                        }
                    },
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .constrainAs(text2) {
                            centerHorizontallyTo(parent)
                            top.linkTo(artist.bottom)
                            bottom.linkTo(name.top)
                        },
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                //    brush = Brush.linearGradient(colors = colorList),
                                baselineShift = BaselineShift.Subscript,
                                textDecoration = TextDecoration.Underline,
                                // pushStyle(ParagraphStyle(textAlign = TextAlign.End))
                            ),
                        ) {
                            append("Название композиции")
                        }
                    },
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .constrainAs(name) {
                            centerHorizontallyTo(parent)
                            top.linkTo(text2.bottom)
                            bottom.linkTo(parent.bottom)
                        },
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = Color.Red,
                                //    brush = Brush.linearGradient(colors = colorList),
                                baselineShift = BaselineShift.Subscript,
                                // textDecoration = TextDecoration.Underline,
                                // pushStyle(ParagraphStyle(textAlign = TextAlign.End))
                            ),
                        ) {
                            append("Jude love is Yesterday!")
                        }
                    },
                    textAlign = TextAlign.Center
                )

            }
        }
    """.trimIndent()


    val modifierExtension =
        """
            @Composable
        fun Modifier.exampleLayout(
            x: Int,
            y: Int
        ) = layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            layout(placeable.width, placeable.height) {
                placeable.placeRelative(x, y)
            }
        }

        /*
        новое положение будет рассчитываться относительно координат по умолчанию,
         заданных родителем (которые будут равны 0, 0). Кроме того, модификатор
         теперь принимает параметр с плавающей точкой, представляющий положение
         линии вертикального выравнивания в процентах от ширины дочернего элемента
         */
        fun Modifier.exampleFraction(
            fraction: Float
        ) = layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            val x = -(placeable.width * fraction).roundToInt()
            layout(placeable.width, placeable.height) {
                placeable.placeRelative(x = x, y = 0)
            }
        }


        fun Modifier.exampleBaseLine(
            fraction: Float
        ) = layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)

            val firstBaseline = placeable[FirstBaseline]
            val lastBaseline = placeable[LastBaseline]

            if (placeable[FirstBaseline] == AlignmentLine.Unspecified) {

            // child passed to modifier does not support FirstBaseline alignment

            }
            val x = -(placeable.width * fraction).roundToInt()
            layout(placeable.width, placeable.height) {
                placeable.placeRelative(x = x, y = 0)
            }
        }
    """.trimIndent()


    val cascadeScreen =
        """
       @Composable
fun CascadeScreen(modifier: Modifier = Modifier) {

    Box(modifier.fillMaxWidth().height(300.dp)) {
        CascadeLayout(spacing = 20) {
            Box(modifier = Modifier
                .size(60.dp)
                .background(Color.Blue))
            Box(modifier = Modifier
                .size(80.dp, 40.dp)
                .background(Color.Red))
            Box(modifier = Modifier
                .size(90.dp, 100.dp)
                .background(Color.Cyan))
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Magenta))
            Box(modifier = Modifier
                .size(70.dp)
                .background(Color.Green))
        }
    }
}
    """.trimIndent()


    val cascadeLayout =
        """
            @Composable
        fun CascadeLayout(
            modifier: Modifier = Modifier,
            spacing: Int = 0,
            content: @Composable () -> Unit
        ) {
            Layout(
                modifier = modifier,
                content = content
            ) { measurables, constraints ->
                var indent = 0
                layout(constraints.maxWidth, constraints.maxHeight) {
                    var yCoord = 0
                    val placeables = measurables.map { measurable ->
                        measurable.measure(constraints)
                    }
                    placeables.forEach { placeable ->
                        placeable.placeRelative(x = indent, y = yCoord)
                        indent += placeable.width + spacing
                        yCoord += placeable.height + spacing
                    }
                }
            }
        }
    """.trimIndent()

    val constraintsBias = """
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
    """.trimIndent()


    @Composable
    fun colorFun(
        text: String,
        isShowDialogClick: (Boolean, String) -> Unit,
    ): AnnotatedString {
        var textA = AnnotatedString("")
        val regexFun = """^fun""".toRegex()
        val regexComposable = """@""".toRegex()
        val regexClass = """(\w+)\Q(\E""".toRegex()
        val regexExt = """^\Q.\E([\w\s]+)""".toRegex()
        val regexExt2 = """(\w+)\Q.\E([\w\s]+)""".toRegex()
        val lines = text.lines()
        lines.forEachIndexed { index, s ->
            when {
                s.contains(regexComposable) -> textA += annotated(s, green)
                s.contains(regexFun) -> {
                    //  println("$index   This is fun ---$s---")
                    //textA += annotated("fun ", red)
                    var nameFun = ""
                    var bodyFun = ""
                    var isName = false
                    var isTelo = false
                    s.forEachIndexed { index, c ->
                        if (c == '(') {
                            isName = false
                            isTelo = true
                        }
                        if (isName) {
                            nameFun += c
                        }
                        if (isTelo) {
                            bodyFun += c
                        }
                        if (c == ' ' && index < 4) isName = true
                    }
                    //println(" Name of Fun $nameFun  with body $bodyFun")
                    textA += buildAnnotatedString {
                        withStyle(style = SpanStyle(color = red, fontSize = size)) {
                            append("fun ")
                        }
                        withStyle(style = SpanStyle(color = blue, fontSize = size)) {
                            append(nameFun)
                        }
                        withStyle(style = SpanStyle(color = black, fontSize = size)) {
                            append(bodyFun)
                        }
                    }
                }

                s.contains(regexExt) -> {
                    var nameFun = ""
                    var bodyFun = ""
                    var isName = true
                    var isTelo = false
                    s.forEachIndexed { index, c ->
                        if (c == '(') {
                            isName = false
                            isTelo = true
                        }
                        if (isName) {
                            nameFun += c
                        }
                        if (isTelo) {
                            bodyFun += c
                        }
                    }
                    textA += buildAnnotatedString {
                        withStyle(
                            style = ParagraphStyle(
                                lineBreak = LineBreak.Simple,
                                lineHeight = 14.sp,
                                textMotion = TextMotion.Animated
                            )
                        ) {
                            withStyle(style = SpanStyle(color = gray, fontSize = size)) {
                                append(nameFun)
                            }
                            withStyle(style = SpanStyle(color = black, fontSize = size)) {
                                append(bodyFun)
                            }
                        }
                    }
                }

                s.contains(regexExt2) -> {
                    var nameFun = ""
                    var bodyFun1 = ""
                    var bodyFun2 = ""
                    val listTriple = mutableListOf(Triple("", "", ""))
                    var isName = false
                    // Вначале сохраняем в тело 1
                    var isTelo1 = true
                    var isTelo2 = false
                    var isScobka = false
                    s.forEachIndexed { index, c ->
                        //Если точка начинаем выделять функцию.
                        if (c == '.') {
                            if (nameFun.isNotEmpty()) {
                                listTriple.add(Triple(bodyFun1, nameFun, bodyFun2))
                                nameFun = ""
                                bodyFun1 = ""
                                bodyFun2 = ""
                            }
                            isName = true
                            isTelo1 = false
                            isTelo2 = false
                        }
                        if ((c == '(' && isName) || (c == ' ' && isName)) {
                            // Если ( или пробел сохраняем тело 2
                            isName = false
                            isTelo1 = false
                            isTelo2 = true
                        }
                        if ((c == ')' && isTelo2) || (c == ' ' && isTelo2)) {
                            //если скобка закрылась
                            isName = false
                            isTelo1 = false
                            isTelo2 = true
                        }
                        if (c == ')' && isName) {
                            isName = false
                            isTelo1 = false
                            isTelo2 = true
                        }
                        if (isName) {
                            nameFun += c
                        }
                        if (isTelo1) {
                            bodyFun1 += c
                        }
                        if (isTelo2) {
                            bodyFun2 += c
                        }
                    }
                    listTriple.add(Triple(bodyFun1, nameFun, bodyFun2))
                    textA += buildAnnotatedString {
                        var isShow by remember { mutableStateOf(false) }
                        withStyle(
                            style = ParagraphStyle(
                                lineBreak = LineBreak.Simple,
                                lineHeight = 14.sp,
                                textMotion = TextMotion.Animated
                            )
                        ) {
                            listTriple.forEach { triple ->
                                withStyle(style = SpanStyle(color = black, fontSize = size)) {
                                    append(triple.first)
                                }
                                withLink(
                                    link = LinkAnnotation.Clickable(
                                        tag = triple.second,
                                        styles = TextLinkStyles(
                                            style = SpanStyle(
                                                color = red,
                                                fontSize = size
                                            ),
                                            focusedStyle = SpanStyle(
                                                color = blue,
                                                background = black,
                                                fontSize = 20.sp
                                            ),
                                            hoveredStyle = SpanStyle(
                                                color = Color.White,
                                                background = Color.Black,
                                                fontSize = 20.sp
                                            ),
                                            pressedStyle = SpanStyle(
                                                color = black,
                                                background = red,
                                                fontSize = 10.sp
                                            )
                                        ),
                                        linkInteractionListener = {
                                            isShow = !isShow
                                            isShowDialogClick(
                                                isShow,
                                                when {
                                                    triple.second.contains("""size""".toRegex()) -> sizeI
                                                    triple.second.contains("""dp""".toRegex()) -> dpI
                                                    triple.second.contains("""sp""".toRegex()) -> spI
                                                    triple.second.contains("""map""".toRegex()) -> mapI
                                                    triple.second.contains("""padding""".toRegex()) -> paddingI
                                                    triple.second.contains("""width""".toRegex()) -> widthI
                                                    triple.second.contains("""height""".toRegex()) -> heightI
                                                    triple.second.contains("""clip""".toRegex()) -> clipI
                                                    triple.second.contains("""background""".toRegex()) -> backgroundI
                                                    triple.second.contains("""End""".toRegex()) -> endI
                                                    triple.second.contains("""align""".toRegex()) -> alignI
                                                    triple.second.contains("""forEach""".toRegex()) -> forEachI
                                                    triple.second.contains("""linkTo""".toRegex()) -> linkToI
                                                    triple.second.contains("""constrainAs""".toRegex()) -> constrainAsI
                                                    else -> " Новая Информация по клику [$nameFun] "
                                                }
                                            )
                                        }
                                    )
                                ) {
                                    append(triple.second)
                                }
                                /*  if (isShow) {
                                      withStyle(style = SpanStyle(color = black, fontSize = size)) {
                                          when {
                                              triple.second.contains("""size""".toRegex()) -> append(
                                                  sizeI
                                              )

                                              triple.second.contains("""dp""".toRegex()) -> append(dpI)
                                              triple.second.contains("""map""".toRegex()) -> append(
                                                  mapI
                                              )

                                              else -> append(" Новая Информация по клику [$nameFun] ")
                                          }
                                      }
                                  }*/
                                withStyle(style = SpanStyle(color = black, fontSize = size)) {
                                    append(triple.third)
                                }
                            }
                        }
                    }
                }

                s.contains(regexClass) -> {
                    var nameFun = ""
                    var bodyFun = ""
                    var isName = true
                    var isTelo = false
                    s.forEachIndexed { index, c ->
                        if (c == '(') {
                            isName = false
                            isTelo = true
                        }
                        if (isName) {
                            nameFun += c
                        }
                        if (isTelo) {
                            bodyFun += c
                        }
                    }
                    textA += buildAnnotatedString {
                        var isShow by remember { mutableStateOf(false) }
                        withStyle(
                            style = ParagraphStyle(
                                lineBreak = LineBreak.Simple,
                                lineHeight = 14.sp,
                                textMotion = TextMotion.Animated
                            )
                        ) {
                            withLink(
                                link = LinkAnnotation.Clickable(
                                    tag = nameFun,
                                    styles = TextLinkStyles(
                                        style = SpanStyle(
                                            color = magenta,
                                            fontSize = size
                                        ),
                                        focusedStyle = SpanStyle(
                                            color = blue,
                                            background = black,
                                            fontSize = 20.sp
                                        ),
                                        hoveredStyle = SpanStyle(
                                            color = Color.White,
                                            background = Color.Black,
                                            fontSize = 20.sp
                                        ),
                                        pressedStyle = SpanStyle(
                                            color = black,
                                            background = red,
                                            fontSize = 10.sp
                                        )
                                    ),
                                    linkInteractionListener = {
                                        isShow = !isShow
                                        isShowDialogClick(
                                            isShow,
                                            when {
                                                nameFun.contains("""Box""".toRegex()) -> box
                                                nameFun.contains("""Layout""".toRegex()) -> layout2
                                                nameFun.contains("""Column""".toRegex()) -> column
                                                nameFun.contains("""Text""".toRegex()) -> textI
                                                nameFun.contains("""Card""".toRegex()) -> cardI
                                                nameFun.contains("""Dialog""".toRegex()) -> dialogI
                                                nameFun.contains("""FlowRow""".toRegex()) -> flowRowI
                                                nameFun.contains("""Row""".toRegex()) -> rowI
                                                nameFun.contains("""constrainAs""".toRegex()) -> constrainAsI
                                                else -> " Новая Информация по клику [$nameFun] "
                                            }
                                        )
                                    }
                                )
                            ) {
                                append(nameFun)
                            }
                            /* if (isShow) {
                                 withStyle(style = SpanStyle(color = black, fontSize = size)) {
                                     when {
                                         nameFun.contains("""Box""".toRegex()) -> append(box)
                                         nameFun.contains("""Layout""".toRegex()) -> append(layout2)
                                         else -> append(" Новая Информация по клику [$nameFun] ")
                                     }
                                 }
                             }*/

                            withStyle(style = SpanStyle(color = black, fontSize = size)) {
                                append(bodyFun)
                            }
                        }
                    }
                }

                else -> textA += annotated(s, black)
            }
        }
        return textA
    }

    private val sizeI = "\n" + """
        ---------------------------------------------------
        @Stable
        public fun Modifier.size(
            size: Dp
        ): Modifier
        Declare the preferred size of the content to be exactly sizedp square.
         The incoming measurement Constraints may override this value, forcing
        the content to be either smaller or larger.
        For a modifier that sets the size of the content regardless of the 
        incoming constraints, see Modifier. requiredSize. See width or height
        to set width or height alone. See widthIn, heightIn or sizeIn to set
        a preferred size range.
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val dpI = "\n" + """
        ---------------------------------------------------
        @Stable
        public val Int.dp: Dp
        Create a Dp using an Int: 
        val left = 10 
        val x = left.dp
        // -- or --
        val y = 10.dp
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val samplepI = "\n" + """
        ---------------------------------------------------
        
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val constrainAsI = "\n" + """
        ---------------------------------------------------
        @Stable
public final fun Modifier.constrainAs(
    ref: ConstrainedLayoutReference,
    constrainBlock: ConstrainScope.() -> Unit
): Modifier
Modifier that defines the constraints, as part of a ConstraintLayout, of the layout element.
  androidx. constraintlayout. compose. ConstraintLayoutScope
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val linkToI = "\n" + """
        ---------------------------------------------------
        public abstract fun linkTo(
    anchor: ConstraintLayoutBaseScope. HorizontalAnchor,
    margin: Dp = 0.dp,
    goneMargin: Dp = 0.dp
): Unit
Adds a link towards a ConstraintLayoutBaseScope. HorizontalAnchor.
  androidx. constraintlayout. compose. HorizontalAnchorable
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val spI = "\n" + """
        ---------------------------------------------------
        @Stable
public val Int.sp: TextUnit
Creates a SP unit TextUnit
  androidx. compose. ui. unit   TextUnit. kt
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val forEachI = "\n" + """
        ---------------------------------------------------
        @HidesMembers
public inline fun <T> Iterable<T>.forEach(
    action: (T) -> Unit
): Unit
Performs the given action on each element.
  kotlin. collections   _Collections. kt
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val alignI = "\n" + """
        ---------------------------------------------------
        @Stable
        public abstract fun Modifier.align(
            alignment: Alignment. Vertical
        ): Modifier
        Align the element vertically within the Row. This alignment will have priority over the Row's verticalAlignment parameter.
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val endI = "\n" + """
        ---------------------------------------------------
        @Stable
public final val End: Arrangement. Horizontal
Place children horizontally such that they are as close as possible to the end of the main axis. Visually: ####123 for LTR and 321#### for RTL.
  androidx. compose. foundation. layout. Arrangement
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val backgroundI = "\n" + """
        ---------------------------------------------------
        @Stable
        public fun Modifier.background(
            color: Color,
            shape: Shape = RectangleShape
        ): Modifier
        Draws shape with a solid color behind the content.
        Params:
        color - color to paint background with
        shape - desired shape of the background
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val clipI = "\n" + """
        ---------------------------------------------------
        @Stable
public fun Modifier.clip(
    shape: Shape
): Modifier
Clip the content to shape.
Params:
shape - the content will be clipped to this Shape.
  androidx. compose. ui. draw   Clip. kt
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val heightI = "\n" + """
        ---------------------------------------------------
        @Stable
        public fun Modifier.height(
            height: Dp
        ): Modifier
        Declare the preferred height of the content to be exactly heightdp. The incoming measurement Constraints may override this value, forcing the content to be either smaller or larger.
        For a modifier that sets the height of the content regardless of the incoming constraints see Modifier. requiredHeight. See width or size to set other preferred dimensions. See widthIn, heightIn or sizeIn to set a preferred size range.
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val widthI = "\n" + """
        ---------------------------------------------------
        @Stable
        public fun Modifier.width(
            width: Dp
        ): Modifier
        Declare the preferred width of the content to be exactly widthdp. The incoming measurement Constraints may override this value, forcing the content to be either smaller or larger.
        For a modifier that sets the width of the content regardless of the incoming constraints see Modifier. requiredWidth. See height or size to set other preferred dimensions. See widthIn, heightIn or sizeIn to set a preferred size range.
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val paddingI = "\n" + """
        ---------------------------------------------------
        @Stable
        public fun Modifier.padding(
            all: Dp
        ): Modifier
        Apply all dp of additional space along each edge of the content, left, top, right and bottom. Padding is applied before content measurement and takes precedence; content may only be as large as the remaining space.
        Negative padding is not permitted — it will cause IllegalArgumentException. See Modifier. offset.
        ---------------------------------------------------
    """.trimIndent() + "\n"

 private val flowRowI = "\n" + """
        @Composable
@ExperimentalLayoutApi
public fun FlowRow(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement. Horizontal = Arrangement.Start,
    verticalArrangement: Arrangement. Vertical = Arrangement.Top,
    maxItemsInEachRow: Int = Int.MAX_VALUE,
    maxLines: Int = Int.MAX_VALUE,
    overflow: FlowRowOverflow = FlowRowOverflow.Clip,
    content: @Composable() (FlowRowScope.() -> Unit)
): Unit
FlowRow is a layout that fills items from left to right (ltr) in LTR layouts or right to left (rtl) in RTL layouts and when it runs out of space, moves to the next "row" or "line" positioned on the bottom, and then continues filling items until the items run out.
Example:
Params:
modifier - The modifier to be applied to the Row.
horizontalArrangement - The horizontal arrangement of the layout's children.
verticalArrangement - The vertical arrangement of the layout's virtual rows.
maxItemsInEachRow - The maximum number of items per row
maxLines - The max number of rows
overflow - The strategy to handle overflowing items
content - The content as a RowScope
See Also:
FlowColumn, ContextualFlowRow, androidx. compose. foundation. layout. Row
    """.trimIndent() + "\n"

    private val rowI = "\n" + """
        @Composable
public inline fun Row(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement. Horizontal = Arrangement.Start,
    verticalAlignment: Alignment. Vertical = Alignment.Top,
    content: @Composable() (RowScope.() -> Unit)
): Unit
A layout composable that places its children in a horizontal sequence. For a layout composable that places its children in a vertical sequence, see Column. Note that by default items do not scroll; see Modifier. horizontalScroll to add this behavior. For a horizontally scrollable list that only composes and lays out the currently visible items see LazyRow.
The Row layout is able to assign children widths according to their weights provided using the RowScope. weight modifier. If a child is not provided a weight, it will be asked for its preferred width before the sizes of the children with weights are calculated proportionally to their weight based on the remaining available space. Note that if the Row is horizontally scrollable or part of a horizontally scrollable container, any provided weights will be disregarded as the remaining available space will be infinite.
When none of its children have weights, a Row will be as small as possible to fit its children one next to the other. In order to change the width of the Row, use the Modifier. width modifiers; e. g. to make it fill the available width Modifier. fillMaxWidth can be used. If at least one child of a Row has a weight, the Row will fill the available width, so there is no need for Modifier. fillMaxWidth. However, if Row's size should be limited, the Modifier. width or Modifier. size layout modifiers should be applied.
When the size of the Row is larger than the sum of its children sizes, a horizontalArrangement can be specified to define the positioning of the children inside the Row. See Arrangement for available positioning behaviors; a custom arrangement can also be defined using the constructor of Arrangement. Below is an illustration of different horizontal arrangements:
!Row arrangements 
Example usage:
Params:
modifier - The modifier to be applied to the Row.
horizontalArrangement - The horizontal arrangement of the layout's children.
verticalAlignment - The vertical alignment of the layout's children.
See Also:
Column, androidx. compose. foundation. lazy. LazyRow
    """.trimIndent() + "\n"



     private val dialogI = "\n" + """
       @Composable
public actual fun Dialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties,
    content: @Composable () -> Unit
): Unit
Opens a dialog with the given content.
A dialog is a small window that prompts the user to make a decision or enter additional information. A dialog does not fill the screen and is normally used for modal events that require users to take an action before they can proceed.
The dialog is visible as long as it is part of the composition hierarchy. In order to let the user dismiss the Dialog, the implementation of onDismissRequest should contain a way to remove the dialog from the composition hierarchy.
Example usage:
Params:
onDismissRequest - Executes when the user tries to dismiss the dialog.
properties - DialogProperties for further customization of this dialog's behavior.
content - The content to be displayed inside the dialog.
    """.trimIndent() + "\n"


    private val cardI = "\n" + """
        @Composable
public fun Card(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke? = null,
    content: @Composable() (ColumnScope.() -> Unit)
): Unit
<a href="https:// m3.material. io/ components/ cards/ overview" class="external" target="_blank">Material Design filled card.
Cards contain contain content and actions that relate information about a subject. Filled cards provide subtle separation from the background. This has less emphasis than elevated or outlined cards.
This Card does not handle input events - see the other Card overloads if you want a clickable or selectable Card.
![Filled card
image](https:// developer. android. com/ images/ reference/ androidx/ compose/ material3/ filled-card. png)
Card sample:
Params:
modifier - the Modifier to be applied to this card
shape - defines the shape of this card's container, border (when border is not null), and shadow (when using elevation)
colors - CardColors that will be used to resolve the colors used for this card in different states. See CardDefaults. cardColors.
elevation - CardElevation used to resolve the elevation for this card in different states. This controls the size of the shadow below the card. Additionally, when the container color is ColorScheme. surface, this controls the amount of primary color applied as an overlay. See also: Surface.
border - the border to draw around the container of this card
    """.trimIndent() + "\n"

    private val mapI = "\n" + """
        ---------------------------------------------------
        public inline fun <T, R> Iterable<T>.map(
            transform: (T) -> R
        ): List<R>
        Returns a list containing the results of applying 
        the given transform function to each element in the original collection.
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val textI = "\n" + """
       @Composable
public fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    style: TextStyle = LocalTextStyle.current
): Unit
High level element that displays text and provides semantics / accessibility information.
The default style uses the LocalTextStyle provided by the MaterialTheme / components. If you are setting your own style, you may want to consider first retrieving LocalTextStyle, and using TextStyle. copy to keep any theme defined attributes, only modifying the specific attributes you want to override.
For ease of use, commonly used parameters from TextStyle are also present here. The order of precedence is as follows:
If a parameter is explicitly set here (i. e, it is not null or TextUnit. Unspecified), then this parameter will always be used.
If a parameter is not set, (null or TextUnit. Unspecified), then the corresponding value from style will be used instead.
Additionally, for color, if color is not set, and style does not have a color, then LocalContentColor will be used.
Params:
text - the text to be displayed
modifier - the Modifier to be applied to this layout node
color - Color to apply to the text. If Color. Unspecified, and style has no color set, this will be LocalContentColor.
fontSize - the size of glyphs to use when painting the text. See TextStyle. fontSize.
fontStyle - the typeface variant to use when drawing the letters (e. g., italic). See TextStyle. fontStyle.
fontWeight - the typeface thickness to use when painting the text (e. g., FontWeight. Bold).
fontFamily - the font family to be used when rendering the text. See TextStyle. fontFamily.
letterSpacing - the amount of space to add between each letter. See TextStyle. letterSpacing.
textDecoration - the decorations to paint on the text (e. g., an underline). See TextStyle. textDecoration.
textAlign - the alignment of the text within the lines of the paragraph. See TextStyle. textAlign.
lineHeight - line height for the Paragraph in TextUnit unit, e. g. SP or EM. See TextStyle. lineHeight.
overflow - how visual overflow should be handled.
softWrap - whether the text should break at soft line breaks. If false, the glyphs in the text will be positioned as if there was unlimited horizontal space. If softWrap is false, overflow and TextAlign may have unexpected effects.
maxLines - An optional maximum number of lines for the text to span, wrapping if necessary. If the text exceeds the given number of lines, it will be truncated according to overflow and softWrap. It is required that 1 <= minLines <= maxLines.
minLines - The minimum height in terms of minimum number of visible lines. It is required that 1 <= minLines <= maxLines.
onTextLayout - callback that is executed when a new text layout is calculated. A TextLayoutResult object that callback provides contains paragraph information, size of the text, baselines and other details. The callback can be used to add additional decoration or functionality to the text. For example, to draw selection around the text.
style - style configuration for the text such as color, font, line height etc.
    """.trimIndent() + "\n"

    private val layout2 = "\n" + """
        ---------------------------------------------------
        @Suppress(names = {"ComposableLambdaParameterPosition"})
        @UiComposable
        @Composable
        public inline fun Layout(
            content: @Composable @UiComposable () -> Unit,
            modifier: Modifier = Modifier,
            measurePolicy: MeasurePolicy
        ): Unit
        Layout is the main core component for layout. It can be used to measure and
        position zero or more layout children.
        The measurement, layout and intrinsic measurement behaviours of this layout
        will be defined by the measurePolicy instance. See MeasurePolicy for more details.
        For a composable able to define its content according to the incoming constraints, 
        see androidx. compose. foundation. layout. BoxWithConstraints.
        Example usage:
        Params:
        content - The children composable to be laid out.
        modifier - Modifiers to be applied to the layout.
        measurePolicy - The policy defining the measurement and positioning of the layout.
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val box = "\n" + """
        ---------------------------------------------------
        @Composable
        public inline fun Box(
            modifier: Modifier = Modifier,
            contentAlignment: Alignment = Alignment.TopStart,
            propagateMinConstraints: Boolean = false,
            content: @Composable() (BoxScope.() -> Unit)
        ): Unit
        A layout composable with content. The Box will size itself to fit the content, 
        subject to the incoming constraints. When children are smaller than the parent, 
        by default they will be positioned inside the Box according to the contentAlignment.
         For individually specifying the alignments of the children layouts, use the BoxScope.
        align modifier. By default, the content will be measured without the Box's incoming
        min constraints, unless propagateMinConstraints is true. As an example, setting
        propagateMinConstraints to true can be useful when the Box has content on which
        modifiers cannot be specified directly and setting a min size on the content of 
        the Box is needed. If propagateMinConstraints is set to true, the min size set 
        on the Box will also be applied to the content, whereas otherwise the min size
        will only apply to the Box. When the content has more than one layout child the
        layout children will be stacked one on top of the other (positioned as explained
        above) in the composition order.
        Example usage:
        Params:
        modifier - The modifier to be applied to the layout.
        contentAlignment - The default alignment inside the Box.
        propagateMinConstraints - Whether the incoming min constraints should be passed to content.
        content - The content of the Box.
        ---------------------------------------------------
    """.trimIndent() + "\n"

    private val column = "\n" + """
        @Composable
        public inline fun Column(
            modifier: Modifier = Modifier,
            verticalArrangement: Arrangement. Vertical = Arrangement.Top,
            horizontalAlignment: Alignment. Horizontal = Alignment.Start,
            content: @Composable() (ColumnScope.() -> Unit)
        ): Unit
        A layout composable that places its children in a vertical sequence. For a layout 
        composable that places its children in a horizontal sequence, see Row. Note that by
        default items do not scroll; see Modifier. verticalScroll to add this behavior. For
        a vertically scrollable list that only composes and lays out the currently visible 
        items see LazyColumn.
        The Column layout is able to assign children heights according to their weights provided
        using the ColumnScope. weight modifier. If a child is not provided a weight, it will be
        asked for its preferred height before the sizes of the children with weights are
        calculated proportionally to their weight based on the remaining available space. 
        Note that if the Column is vertically scrollable or part of a vertically scrollable
        container, any provided weights will be disregarded as the remaining available space will be infinite.
        When none of its children have weights, a Column will be as small as possible to fit
        its children one on top of the other. In order to change the height of the Column,
        use the Modifier. height modifiers; e. g. to make it fill the available height Modifier. 
        fillMaxHeight can be used. If at least one child of a Column has a weight, the Column will 
        fill the available height, so there is no need for Modifier. fillMaxHeight. However, 
        if Column's size should be limited, the Modifier. height or Modifier. size layout modifiers 
        should be applied.
        When the size of the Column is larger than the sum of its children sizes, a verticalArrangement 
        can be specified to define the positioning of the children inside the Column. See Arrangement
        for available positioning behaviors; a custom arrangement can also be defined using the 
        constructor of Arrangement. Below is an illustration of different vertical arrangements:
        !Column arrangements 
        Example usage:
        Params:
        modifier - The modifier to be applied to the Column.
        verticalArrangement - The vertical arrangement of the layout's children.
        horizontalAlignment - The horizontal alignment of the layout's children.
        See Also:
        Row, androidx. compose. foundation. lazy. LazyColumn
    """.trimIndent() + "\n"

    private fun annotated(
        text: String,
        //  colorList: List<Color>,
        color: Color = Color.Black,
        textAlign: TextAlign = TextAlign.Start,
    ): AnnotatedString {
        return AnnotatedString(
            text = text,
            spanStyle = SpanStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = color,
            ),
            paragraphStyle = ParagraphStyle(
                textAlign = textAlign,
                lineHeight = 14.sp,
                textMotion = TextMotion.Animated
            )
        )
    }

    fun checkLine(line: String) {
        val regex = """([\w\s]+) is (\d+) years old""".toRegex()
        val matchResult = regex.find("Mickey Mouse is 95 years old")!!
        val (name, age) = matchResult.destructured

        println("$name,$age")
    }

    fun newReg(line: String) {
        val regex = """([\w\s]+) is (\d+) years old""".toRegex()
        val matchResult = regex.find("Mickey Mouse is 95 years old")!!
        val (name, age) = matchResult.destructured

        println("$name,$age")
    }

    @Composable
    fun choiceText(slot: Texts, isShowDialogClick: (Boolean, String) -> Unit): AnnotatedString {
        return when (slot) {
            Texts.ModifierDemo -> colorFun(
                text = modifierDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.StateDemo -> colorFun(text = stateDemo, isShowDialogClick = { isShow, textNew ->
                isShowDialogClick(isShow, textNew)
            })

            Texts.StringDemo -> colorFun(text = stringDemo, isShowDialogClick = { isShow, textNew ->
                isShowDialogClick(isShow, textNew)
            })

            Texts.SpanString -> colorFun(text = spanString, isShowDialogClick = { isShow, textNew ->
                isShowDialogClick(isShow, textNew)
            })

            Texts.ParaString -> colorFun(text = paraString, isShowDialogClick = { isShow, textNew ->
                isShowDialogClick(isShow, textNew)
            })

            Texts.BrushStyle -> colorFun(text = brushStyle, isShowDialogClick = { isShow, textNew ->
                isShowDialogClick(isShow, textNew)
            })

            Texts.BrushStyle2 -> colorFun(
                text = brushStyle2,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.BrushStyle3 -> colorFun(
                text = brushStyle3,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.RowColumnCode -> colorFun(
                text = rowColumnCode,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.TextCell -> colorFun(text = textCell, isShowDialogClick = { isShow, textNew ->
                isShowDialogClick(isShow, textNew)
            })

            Texts.TextRow -> colorFun(text = textRow, isShowDialogClick = { isShow, textNew ->
                isShowDialogClick(isShow, textNew)
            })

            Texts.BoxLayout -> colorFun(text = boxLayout, isShowDialogClick = { isShow, textNew ->
                isShowDialogClick(isShow, textNew)
            })

            Texts.TextCellBox -> colorFun(
                text = textCellBox,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.FlowRowDemo -> colorFun(
                text = flowRowDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.FlowColumnDemo -> colorFun(
                text = flowColumnDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.LayoutModifierDemo -> colorFun(
                text = layoutModifierDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })


            Texts.ModifierExtension -> colorFun(
                text = modifierExtension,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.CascadeScreen -> colorFun(
                text = cascadeScreen,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.CascadeLayout -> colorFun(
                text = cascadeLayout,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

             Texts.Beatles -> colorFun(
                text = beatles,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })


             Texts.ConstraintBias -> colorFun(
                text = constraintsBias,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.ConstraintChain -> colorFun(
                text = ConstrDemo.constraintChain,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.GuideLinesDemo -> colorFun(
                text = ConstrDemo.guideLinesDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.BarriersDemo -> colorFun(
                text = ConstrDemo.barriersDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.ConstraintSetsDemo -> colorFun(
                text = ConstrDemo.constraintSetsDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
            Texts.IntrinsicMinDemo -> colorFun(
                text = ConstrDemo.intrinsicMinDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            Texts.IntrinsicMaxDemo -> colorFun(
                text = ConstrDemo.intrinsicMaxDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
        }
    }
}


enum class Texts {
    ModifierDemo, StateDemo, StringDemo, SpanString, ParaString,
    BrushStyle, BrushStyle2, BrushStyle3, RowColumnCode, TextCell,
    TextRow, BoxLayout, TextCellBox, FlowRowDemo, FlowColumnDemo, LayoutModifierDemo,
    ModifierExtension, CascadeScreen, CascadeLayout, Beatles, ConstraintBias, ConstraintChain,
    GuideLinesDemo, BarriersDemo, ConstraintSetsDemo, IntrinsicMinDemo, IntrinsicMaxDemo,

}