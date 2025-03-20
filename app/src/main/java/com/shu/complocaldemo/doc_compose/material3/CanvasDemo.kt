package com.shu.complocaldemo.doc_compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import com.shu.complocaldemo.CodeSample.colorFun

object CanvasDemo {

    val canvas = """
    
    Component that allow you to specify an area on the screen and perform canvas 
    drawing on this area. You MUST specify size with modifier, whether with exact
     sizes via Modifier. size modifier, or relative to parent, via Modifier. fillMaxSize,
      ColumnScope. weight, etc. If parent wraps this child, only exact sizes must be specified.
      
    Params:
    modifier - mandatory modifier to specify size strategy for this composable
    onDraw - lambda that will be called to perform drawing. Note that this lambda
     will be called during draw stage, you have no access to composition scope, 
     meaning that Composable function invocation inside it will result to runtime exception
    
""".trimIndent()

    private val canvasSample = """
        @Composable
        fun CanvasSample() {
            Canvas(modifier = Modifier.size(100.dp)) {
                drawRect(Color.Magenta)
                inset(10.0f) {
                    drawLine(
                        color = Color.Red,
                        start = Offset.Zero,
                        end = Offset(size.width, size.height),
                        strokeWidth = 5.0f
                    )
                }
            }
        }
    """.trimIndent()

    val canvasWithDescription = """
        @Composable
        fun Canvas(modifier: Modifier, onDraw: DrawScope.() -> Unit) =
            Spacer(modifier.drawBehind(onDraw))

Component that allow you to specify an area on the screen and perform canvas drawing on this area.
 You MUST specify size with modifier, whether with exact sizes via Modifier. size modifier,
  or relative to parent, via Modifier. fillMaxSize, ColumnScope. weight, etc.
   If parent wraps this child, only exact sizes must be specified.
Params:
modifier - mandatory modifier to specify size strategy for this composable
contentDescription - text used by accessibility services to describe what this 
canvas represents. This should be provided unless the canvas is used for decorative
 purposes or as part of a larger entity already described in some other way.
  This text should be localized, such as by using androidx. compose.ui.res.stringResource
onDraw - lambda that will be called to perform drawing. Note that this lambda will 
be called during draw stage, you have no access to composition scope, meaning that 
Composable function invocation inside it will result to runtime exception
        
        @Composable
        fun Canvas(modifier: Modifier, contentDescription: String, onDraw: DrawScope.() -> Unit) =
            Spacer(modifier.drawBehind(onDraw).semantics { this.contentDescription = contentDescription })

    """.trimIndent()

    private val canvasWithDescriptionCode = """
        @Composable
        fun CanvasPieChartSample() {
            Canvas(
                contentDescription = "Pie chart: 80% apples, 20% bananas (localized string)",
                modifier = Modifier.size(300.dp)
            ) {
                // Apples (80%)
                drawCircle(
                    color = Color.Red,
                    radius = size.width / 2
                )

                // Bananas (20%)
                drawArc(
                    color = Color.Yellow,
                    startAngle = 0f,
                    sweepAngle = 360f * 0.20f,
                    useCenter = true,
                    topLeft = Offset(0f, (size.height - size.width) / 2f),
                    size = Size(size.width, size.width)
                )
            }
        }
         """.trimIndent()

    private val stampedPathEffectSample = """
        @Composable
        fun StampedPathEffectSample() {
            val size = 20f
            val square = Path().apply {
                lineTo(size, 0f)
                lineTo(size, size)
                lineTo(0f, size)
                close()
            }
            Column(modifier = Modifier.fillMaxHeight().wrapContentSize(Alignment.Center)) {
                val canvasModifier = Modifier.requiredSize(80.dp).align(Alignment.CenterHorizontally)

                // StampedPathEffectStyle.Morph will modify the lines of the square to be curved to fit
                // the curvature of the circle itself. Each stamped square will be rendered as an arc
                // that is fully contained by the bounds of the circle itself
                Canvas(modifier = canvasModifier) {
                    drawCircle(color = Color.Blue)
                    drawCircle(
                        color = Color.Red,
                        style = Stroke(
                            pathEffect = PathEffect.stampedPathEffect(
                                shape = square,
                                style = StampedPathEffectStyle.Morph,
                                phase = 0f,
                                advance = 30f
                            )
                        )
                    )
                }

                Spacer(modifier = Modifier.requiredSize(10.dp))

                // StampedPathEffectStyle.Rotate will draw the square repeatedly around the circle
                // such that each stamped square is centered on the circumference of the circle and is
                // rotated along the curvature of the circle itself
                Canvas(modifier = canvasModifier) {
                    drawCircle(color = Color.Blue)
                    drawCircle(
                        color = Color.Red,
                        style = Stroke(
                            pathEffect = PathEffect.stampedPathEffect(
                                shape = square,
                                style = StampedPathEffectStyle.Rotate,
                                phase = 0f,
                                advance = 30f
                            )
                        )
                    )
                }

                Spacer(modifier = Modifier.requiredSize(10.dp))

                // StampedPathEffectStyle.Translate will draw the square repeatedly around the circle
                // with the top left of each stamped square on the circumference of the circle
                Canvas(modifier = canvasModifier) {
                    drawCircle(color = Color.Blue)
                    drawCircle(
                        color = Color.Red,
                        style = Stroke(
                            pathEffect = PathEffect.stampedPathEffect(
                                shape = square,
                                style = StampedPathEffectStyle.Translate,
                                phase = 0f,
                                advance = 30f
                            )
                        )
                    )
                }
            }
        }
    """.trimIndent()

    private val gradientBrushSample = """
        @Composable
        fun GradientBrushSample() {
            Column(modifier = Modifier.fillMaxSize().wrapContentSize()) {

                // Create a linear gradient that shows red in the top left corner
                // and blue in the bottom right corner
                val linear = Brush.linearGradient(listOf(Color.Red, Color.Blue))

                Box(modifier = Modifier.size(120.dp).background(linear))

                Spacer(modifier = Modifier.size(20.dp))

                val horizontal = Brush.horizontalGradient(listOf(Color.Red, Color.Blue))

                Box(modifier = Modifier.size(120.dp).background(horizontal))

                Spacer(modifier = Modifier.size(20.dp))

                val horizontal2 = Brush.horizontalGradient(
                    0.2f to Color.Red,
                    0.4f to Color.Yellow,
                    0.6f to Color.Green,
                    0.8f to Color.Blue,
                    )

                Box(modifier = Modifier.size(120.dp).background(horizontal2))

                Spacer(modifier = Modifier.size(20.dp))

                // Create a radial gradient centered about the drawing area that is green on
                // the outer
                // edge of the circle and magenta towards the center of the circle
                val radial = Brush.radialGradient(listOf(Color.Green, Color.Magenta))
                Box(modifier = Modifier.size(120.dp).background(radial))

                Spacer(modifier = Modifier.size(20.dp))

                // Create a sweep gradient centered about the drawing area that is cyan at
                // the start angle and magenta towards the end angle.
                val sweep = Brush.sweepGradient(listOf(Color.Cyan, Color.Magenta))
                Box(modifier = Modifier.size(120.dp).background(sweep))


            }
        }


        fun LinearGradientColorStopSample() {
            Brush.linearGradient(
                0.0f to Color.Red,
                0.3f to Color.Green,
                1.0f to Color.Blue,
                start = Offset(0.0f, 50.0f),
                end = Offset(0.0f, 100.0f)
            )
        }


        fun LinearGradientSample() {
            Brush.linearGradient(
                listOf(Color.Red, Color.Green, Color.Blue),
                start = Offset(0.0f, 50.0f),
                end = Offset(0.0f, 100.0f)
            )
        }


        fun HorizontalGradientSample() {
            Brush.horizontalGradient(
                listOf(Color.Red, Color.Green, Color.Blue),
                startX = 10.0f,
                endX = 20.0f
            )
        }


        fun HorizontalGradientColorStopSample() {
            Brush.horizontalGradient(
                0.0f to Color.Red,
                0.3f to Color.Green,
                1.0f to Color.Blue,
                startX = 0.0f,
                endX = 100.0f
            )
        }


        fun VerticalGradientColorStopSample() {
            Brush.verticalGradient(
                0.1f to Color.Red,
                0.3f to Color.Green,
                0.5f to Color.Blue,
                startY = 0.0f,
                endY = 100.0f
            )
        }


        fun VerticalGradientSample() {
            Brush.verticalGradient(
                listOf(Color.Red, Color.Green, Color.Blue),
                startY = 0.0f,
                endY = 100.0f
            )
        }


        fun RadialBrushColorStopSample() {
            val side1 = 100
            val side2 = 200
            Brush.radialGradient(
                0.0f to Color.Red,
                0.3f to Color.Green,
                1.0f to Color.Blue,
                center = Offset(side1 / 2.0f, side2 / 2.0f),
                radius = side1 / 2.0f,
                tileMode = TileMode.Repeated
            )
        }


        fun RadialBrushSample() {
            val side1 = 100
            val side2 = 200
            Brush.radialGradient(
                listOf(Color.Red, Color.Green, Color.Blue),
                center = Offset(side1 / 2.0f, side2 / 2.0f),
                radius = side1 / 2.0f,
                tileMode = TileMode.Repeated
            )
        }


        fun SweepGradientColorStopSample() {
            Brush.sweepGradient(
                0.0f to Color.Red,
                0.3f to Color.Green,
                1.0f to Color.Blue,
                center = Offset(0.0f, 100.0f)
            )
        }


        fun SweepGradientSample() {
            Brush.sweepGradient(
                listOf(Color.Red, Color.Green, Color.Blue),
                center = Offset(10.0f, 20.0f)
            )
        }

    """.trimIndent()

    private val drawTextSample = """
         val textMeasurer = rememberTextMeasurer()

    Canvas(Modifier.fillMaxSize()) {
        drawText(textMeasurer, "Hello, World!")
    }
    """.trimIndent()

    private val drawTextStyledSample = """
        @Composable
        fun DrawTextStyledSample() {
            val textMeasurer = rememberTextMeasurer()

            Canvas(Modifier.fillMaxSize()) {
                drawText(
                    textMeasurer = textMeasurer,
                    text = "Hello, World!",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    """.trimIndent()

    private val drawTextAnnotatedStringSample = """
        @Composable
        fun DrawTextAnnotatedStringSample() {
            val textMeasurer = rememberTextMeasurer()

            Canvas(Modifier.fillMaxSize()) {
                drawText(
                    textMeasurer = textMeasurer,
                    text = buildAnnotatedString {
                        withStyle(ParagraphStyle(textAlign = TextAlign.Start)) {
                            append("Hello")
                        }
                        withStyle(ParagraphStyle(textAlign = TextAlign.End)) {
                            append("World")
                        }
                    }
                )
            }
        }
    """.trimIndent()

    private val drawTextMeasureInLayoutSample = """
        This sample demonstrates how to use layout phase to improve performance when drawing text on
 * DrawScope. We can use [layout] Modifier or [Layout] composable to calculate the text layout
 * during layout phase and then cache the result in a Snapshot aware state to draw it during draw
 * phase.
 
 @Composable
 fun DrawTextMeasureInLayoutSample() {
     val textMeasurer = rememberTextMeasurer()
     var textLayoutResult by remember {
         mutableStateOf<TextLayoutResult?>(null)
     }

     Canvas(
         Modifier
             .fillMaxSize()
             .layout { measurable, constraints ->
                 val placeable = measurable.measure(constraints)
                 // TextLayout can be done any time prior to its use in draw, including in a
                 // background thread.
                 // In this sample, text layout is measured in layout modifier. This way the layout
                 // call can be restarted when async font loading completes due to the fact that
                 // `.measure` call is executed in `.layout`.
                 textLayoutResult = textMeasurer.measure(
                     text = "Hello, World!",
                     style = TextStyle(fontSize = 24.sp)
                 )
                 layout(placeable.width, placeable.height) {
                     placeable.placeRelative(0, 0)
                 }
             }) {
         // This happens during draw phase.
         textLayoutResult?.let { drawText(it) }
     }
 }
    """.trimIndent()

    private val drawTextDrawWithCacheSample = """
        This sample demonstrates how to use [drawWithCache] modifier to improve performance when drawing
 * text on DrawScope. We can use [drawWithCache] to calculate the text layout once in
 * [CacheDrawScope] and then repeatedly use the same [TextLayoutResult] in the draw phase.
 *
 * This approach improves performance when the text itself does not change but its draw attributes
 * do change over time, such as during a color animation.
 
 @Composable
 fun DrawTextDrawWithCacheSample() {
     // We can disable implicit caching since we will cache in DrawWithCache
     val textMeasurer = rememberTextMeasurer(cacheSize = 0)
     // Apply the current text style from theme, otherwise TextStyle.Default will be used.
     val materialTextStyle = LocalTextStyle.current

     // Animate color repeatedly
     val infiniteTransition = rememberInfiniteTransition(label = "animeText")
     val color by infiniteTransition.animateColor(
         initialValue = Color.Red,
         targetValue = Color.Blue,
         animationSpec = infiniteRepeatable(tween(1000)), label = "animeText"
     )

     Box(
         Modifier
             .fillMaxSize()
             .drawWithCache {
                 // Text layout will be measured just once until the size of the drawing area or
                 // materialTextStyle changes.
                 val textLayoutResult = textMeasurer.measure(
                     text = "Hello, World!",
                     style = materialTextStyle,
                     constraints = Constraints.fixed(
                         width = (size.width / 2).roundToInt(),
                         height = (size.height / 2).roundToInt()
                     ),
                     overflow = TextOverflow.Ellipsis
                 )
                 // color changes will only invalidate draw phase
                 onDrawWithContent {
                     drawContent()
                     drawText(
                         textLayoutResult,
                         color = color,
                         topLeft = Offset(
                             (size.width - textLayoutResult.size.width) / 2,
                             (size.height - textLayoutResult.size.height) / 2,
                         )
                     )
                 }
             })
 }
    """.trimIndent()

    private val drawScopeSample = """
         Sample showing how to use CanvasScope to issue drawing commands into
 * a given canvas as well as providing transformations to the drawing environment
 */
@Preview
@Composable
fun DrawScopeSample() {
    // Sample showing how to use the DrawScope receiver scope to issue
    // drawing commands
    Canvas(Modifier.size(120.dp)) {
        drawRect(color = Color.Gray) // Draw grey background
        // Inset content by 10 pixels on the left/right sides and 12 by the
        // top/bottom
        inset(10.0f, 12.0f) {
            val quadrantSize = size / 2.0f

            // Draw a rectangle within the inset bounds
            drawRect(
                size = quadrantSize,
                color = Color.Red
            )

            rotate(45.0f) {
                drawRect(size = quadrantSize, color = Color.Blue)
            }
        }
    }
}
    """.trimIndent()

    private val drawScopeBatchedTransformSample = """
        @Composable
        fun DrawScopeBatchedTransformSample() {
            Canvas(Modifier.size(120.dp)) { // CanvasScope
                inset(20.0f) {
                    // Use withTransform to batch multiple transformations for 1 or more drawing calls
                    // that are to be drawn.
                    // This is more efficient than issuing nested translation, rotation and scaling
                    // calls as the internal state is saved once before and after instead of multiple
                    // times between each transformation if done individually
                    withTransform({
                        translate(10.0f, 12.0f)
                        rotate(45.0f, center)
                        scale(2.0f, 0.5f)
                    }) {
                        drawRect(Color.Cyan)
                        drawCircle(Color.Blue)
                    }
                    drawRect(Color.Red, alpha = 0.25f)
                }
            }
        }
    """.trimIndent()

    val drawScopeOvalBrushSample = """
        @Composable
        fun DrawScopeOvalBrushSample() {
            Canvas(Modifier.size(120.dp)) {
                drawOval(
                    brush = Brush.linearGradient(listOf(Color.Red, Color.Blue)),
                    topLeft = Offset(10f, 10f),
                    size = Size(size.width - 20f, size.height - 20f)
                )
            }
        }

        @Preview
        @Composable
        fun DrawScopeOvalColorSample() {
            Canvas(Modifier.size(120.dp)) {
                drawOval(
                    color = Color.Cyan,
                    topLeft = Offset(10f, 10f),
                    size = Size(size.width - 20f, size.height - 20f)
                )
            }
        }
    """.trimIndent()

    val drawScopeRetargetingSample = """
        @Composable
        fun DrawScopeRetargetingSample() {
            Box(modifier = Modifier.size(120.dp)
                .drawWithCache {
                    // Example that shows how to redirect rendering to an Android Picture and then
                    // draw the picture into the original destination
                    // Note:
                    // Canvas#drawPicture is supported with hardware acceleration on Android API 23+
                    // Check https://developer.android.com/topic/performance/hardware-accel#drawing-support
                    // for details of which drawing operations are supported with hardware acceleration
                    val picture = android.graphics.Picture()
                    val width = this.size.width.toInt()
                    val height = this.size.height.toInt()
                    onDrawWithContent {
                        val pictureCanvas =
                            androidx.compose.ui.graphics.Canvas(picture.beginRecording(width, height))
                        draw(this, this.layoutDirection, pictureCanvas, this.size) {
                            this@onDrawWithContent.drawContent()
                        }
                        picture.endRecording()

                        drawIntoCanvas { canvas -> canvas.nativeCanvas.drawPicture(picture) }
                    }
                })
        }
    """.trimIndent()

    private val drawWithCacheModifierSample = """
        /**
         * Sample showing how to leverage [Modifier.drawWithCache] in order
         * to cache contents in between draw calls that depend on sizing information.
         * In the example below, the LinearGradient is created once and re-used across
         * calls to onDraw. If the size of the drawing area changes, then the
         * LinearGradient is re-created with the updated width and height.
         */
        @Preview
        @Composable
        fun DrawWithCacheModifierSample() {
            Box(
                Modifier
                    .size(200.dp)
                    .drawWithCache {
                        val gradient = Brush.linearGradient(
                            colors = listOf(Color.Red, Color.Blue),
                            start = Offset.Zero,
                            end = Offset(size.width, size.height)
                        )
                        onDrawBehind {
                            drawRect(gradient)
                        }
                    }
            )
        }
    """.trimIndent()

    private val drawWithCacheModifierStateParameterSample = """
        /**
         * Sample showing how to leverage [Modifier.drawWithCache] to persist data across
         * draw calls. In the example below, the linear gradient will be re-created if either
         * the size of the drawing area changes, or the toggle flag represented by a mutable state
         * object changes. Otherwise the same linear gradient instance is re-used for each call
         * to drawRect.
         */
        @Preview
        @Composable
        fun DrawWithCacheModifierStateParameterSample() {
            val colors1 = listOf(Color.Red, Color.Blue)
            val colors2 = listOf(Color.Yellow, Color.Green)
            var toggle by remember { mutableStateOf(true) }
            Box(
                Modifier
                    .size(200.dp)
                    .clickable { toggle = !toggle }
                    .drawWithCache {
                        val gradient = Brush.linearGradient(
                            colors = if (toggle) colors1 else colors2,
                            start = Offset.Zero,
                            end = Offset(size.width, size.height)
                        )
                        onDrawBehind {
                            drawRect(gradient)
                        }
                    }
            )
        }
    """.trimIndent()

    private val drawWithCacheContentSample = """
      /**
       * Sample showing how to leverage [Modifier.drawWithCache] to cache a LinearGradient
       * if the size is unchanged. Additionally this sample illustrates how to re-arrange
       * drawing order using [ContentDrawScope.drawContent] in order to draw the desired
       * content first to support blending against the sample vector graphic of a triangle
       */
      @Preview
      @Composable
      fun DrawWithCacheContentSample() {
          val vectorPainter =
              rememberVectorPainter(24.dp, 24.dp, autoMirror = true) { viewportWidth, viewportHeight ->
                  Path(
                      pathData = PathData {
                          lineTo(viewportWidth, 0f)
                          lineTo(0f, viewportHeight)
                          close()
                      },
                      fill = SolidColor(Color.Black)
                  )
              }
          Image(
              painter = vectorPainter,
              contentDescription = null,
              modifier = Modifier
                  .requiredSize(120.dp)
                  .drawWithCache {
                      val gradient = Brush.linearGradient(
                          colors = listOf(Color.Red, Color.Blue),
                          start = Offset.Zero,
                          end = Offset(0f, size.height)
                      )
                      onDrawWithContent {
                          drawContent()
                          drawRect(gradient, blendMode = BlendMode.Plus)
                      }
                  }
          )
      }
  """.trimIndent()

    private val drawModifierNodeSample = """
        @ExperimentalComposeUiApi
        @Preview
        @Composable
        fun DrawModifierNodeSample() {
            val textMeasurer = rememberTextMeasurer()
            class CircleNode(var color: Color) : DrawModifierNode, Modifier.Node() {
                override fun ContentDrawScope.draw() {
                    val gradient = Brush.linearGradient(
                        colors = listOf(Color.Red, Color.Blue),
                        start = Offset.Zero,
                        end = Offset(size.width, size.height)
                    )
                    drawCircle(gradient)
                    drawCircle(Color.Black, radius = size.minDimension / 4.0f)
                    drawText(
                        textMeasurer = textMeasurer,
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(color = Color.White)) {
                                withStyle(ParagraphStyle(textAlign = TextAlign.Start)) {
                                    append("Hello")
                                }
                                withStyle(ParagraphStyle(textAlign = TextAlign.End)) {
                                    append("World")
                                }
                            }
                        },
                        topLeft = Offset(size.width/ 2.0f, size.height / 2.0f)
                    )
                }
            }

            data class CircleElement(val color: Color) : ModifierNodeElement<CircleNode>() {
                override fun create() = CircleNode(color)
                override fun update(node: CircleNode) {
                    node.color = color
                }

                override fun InspectorInfo.inspectableProperties() {
                    name = "color"
                    properties["color"] = color
                }
            }

            fun Modifier.circle(color: Color) = this then CircleElement(color)
            Box(
                Modifier
                    .fillMaxSize()
                    .circle(Color.Red)
            ) {

                DrawTextAnnotatedStringSample()
            }
        }
    """.trimIndent()

    val headCanvas = """
        В этой главе мы познакомимся с рисованием 2D-графики с помощью компонента Compose Canvas.
         По мере изучения возможностей Canvas станет ясно, что, как и в случае почти со всем 
         остальным в Compose, мы можем добиться впечатляющих результатов всего с несколькими строками кода.
         
         Знакомство с компонентом Canvas

         Компонент Canvas предоставляет поверхность, на которой можно выполнять 2D-графику. 
         Однако за кулисами Canvas делает гораздо больше, чем просто предоставляет область для
         рисования, в том числе обеспечивает автоматическое сохранение и управление состоянием 
         графического содержимого. Canvas также имеет собственную область видимости (DrawScope),
         которая предоставляет нам доступ к свойствам области холста, включая размеры и центральную 
         точку текущей области, а также к набору функций, которые мы можем использовать для
         рисования фигур, линий и контуров, определения вставок, выполнения поворотов и многого другого.

         Учитывая визуальную природу этой конкретной функции Compose, в оставшейся части этой главы
         мы будем использовать проект для демонстрации многих функций компонента Canvas в действии.
         
          Рисование линии и получение размера холста

Первый пример рисования, который мы рассмотрим, — это рисование прямой диагональной линии от 
одного угла холста до другого. Для этого нам нужно получить размеры холста, обратившись к
 свойствам размера, предоставляемым DrawScope.
 
 Компонент DrawLine создает холст фиксированного размера и извлекает свойства высоты и ширины 
 из DrawScope. Остается только нарисовать линию с помощью вызова DrawScopeРисованная линия() функция:
  
    """.trimIndent()

    val lineCanvas = """
        @Composable
        fun DrawLine() {

            Canvas(modifier = Modifier.size(300.dp)) {

                val height = size.height
                val width = size.width

                drawLine(
                    start = Offset(x= 0f, y = 0f),
                    end = Offset(x = width, y = height),
                    color = Color.Blue,
                    strokeWidth = 16.0f
                )
            }
        }
    """.trimIndent()

    val dashpathefect = """
        46.4 Рисование пунктирных линий

        Любую форму линии, нарисованной на холсте, можно настроить с помощью пунктирных эффектов,
        настроив экземпляр PathEffect и присвоив его аргументу pathEffect при вызове функции
        рисования. Чтобы создать пунктирную линию, нам нужно вызвать Эффект dashpathefect()
        метод экземпляра PathEffect и передайте ему массив чисел с плавающей запятой. 
           Числа с плавающей запятой указывают интервалы «включения» и «выключения» линии в
        пикселях. Должно быть чётное количество значений интервалов, минимум 2 значения.
        Измените компонуемый элемент DrawLine, чтобы добавить эффект пунктирной линии следующим образом:
        
        @Preview
        @Composable
        fun DrawLinePathEffect() {

            Canvas(modifier = Modifier.size(300.dp)) {

                val height = size.height
                val width = size.width

                drawLine(
                    start = Offset(x= 0f, y = 0f),
                    end = Offset(x = width, y = height),
                    color = Color.Blue,
                    strokeWidth = 16.0f,
                    pathEffect = PathEffect.dashPathEffect(
                        floatArrayOf(30f, 10f, 10f, 10f), phase = 0f)
                )
            }
        }
    """.trimIndent()

    val drawRectDemo = """
    46.5 Рисование прямоугольника

    Прямоугольники рисуются на холсте с помощью drawRect() функция, которую можно использовать 
    несколькими способами. Следующие изменения кода позволяют нарисовать прямоугольник определенных 
    размеров в позиции по умолчанию (0, 0) в области холста:
    
    @Preview
    @Composable
    fun DrawRectDemo() {

        Canvas(modifier = Modifier.size(300.dp)) {

            val size = Size(600f, 250f)

            drawRect(
                color = Color.Blue,
                size = size
            )
        }
       }
    Обратите внимание, что размеры холста составляют 300 x 300, а размер прямоугольника — 600 x 250.
    На первый взгляд может показаться, что прямоугольник должен быть намного шире, чем он выглядит 
    на рисунке выше, по сравнению с холстом. Однако на практике размер холста указывается
    в независимых от плотности пикселях (dp), а размер прямоугольника — в пикселях (px).
    Независимые от плотности пиксели — это абстрактное измерение, которое рассчитывается
    на основе физической плотности экрана, измеряемой в точках на дюйм (dpi). С другой стороны,
    пиксели — это реальные физические пиксели на экране. Чтобы работать исключительно в пикселях, 
    начните со значений dp, а затем преобразуйте их в пиксели следующим образом
    
    @Composable
    fun DrawRectPx() {

        Canvas(modifier = Modifier.size(300.dp)) {

            val size = Size(200.dp.toPx(), 100.dp.toPx())

            drawRect(
                color = Color.Blue,
                size = size
            )
        }
    }
    
    Вместо указания размеров размер прямоугольника можно определить относительно размера холста.
    Например, следующий код рисует квадрат, который в два раза меньше холста:
    
    @Preview
    @Composable
    fun DrawRectSize() {

        Canvas(modifier = Modifier.size(300.dp)) {

           // val size = Size(200.dp.toPx(), 100.dp.toPx())

            drawRect(
                color = Color.Blue,
                size = size / 2f
            )
        }
    }
    
    @Preview
    @Composable
    fun DrawRectTopLeft() {

        Canvas(modifier = Modifier.size(300.dp)) {

            drawRect(
                color = Color.Blue,
                topLeft = Offset(x=350f, y = 300f),
                size = size / 2f
            )
        }
    }
    
    В качестве альтернативы, inset() функция может быть использована для изменения границ компонента Canvas:
    
    @Preview
    @Composable
    fun DrawRectTopLeft() {

        Canvas(modifier = Modifier.size(300.dp)) {

            drawRect(
                color = Color.Blue,
                topLeft = Offset(x=350f, y = 300f),
                size = size / 2f
            )
        }
    }

    @Composable
    fun DrawRectInset() {
        Canvas(modifier = Modifier.size(300.dp)) {

            inset(100f, 200f) {

                drawRect(
                    color = Color.Blue,
                    size = size / 2f
                )
            }
        }
    }
   
  
""".trimIndent()

    val cornerRadius = """
        В Inset() Функция может быть вызвана с широким спектром параметров, влияющих на 
        различные стороны холста. Функция также особенно полезна тем, что из замыкающей
         лямбды можно вызвать несколько функций рисования, каждая из которых будет использовать
        одни и те же значения вставки.

        В drawRoundRect() функция также доступна для рисования прямоугольников со скругленными 
        углами. В дополнение к размеру и положению, этой функции также необходимо &#0;"/p> 
        передать соответствующим образом настроенный компонент cornerRadius. 
        обратите внимание, что прямоугольники (как со скругленными углами, так и без них)
        можно нарисовать контуром, только указав обводку для Стиль property, например:
        @Preview
        @Composable
        fun DrawRectCorner() {
            Canvas(modifier = Modifier.size(300.dp)) {

                val size = Size(
                    width = 280.dp.toPx(),
                    height = 200.dp.toPx()
                )
                drawRoundRect(
                    color = Color.Blue,
                    size = size,
                    topLeft = Offset(20f, 20f),
                    style = Stroke(width = 8.dp.toPx()),
                    cornerRadius = CornerRadius(
                        x = 30.dp.toPx(),
                        y = 30.dp.toPx()
                    )
                )
            }
        }
        
    """.trimIndent()

    val rotating = """
        46.6 Applying rotation

        Any element drawn on a Canvas component can be rotated via a call to the scope rotate() function. 
        The following code, for example, rotates a rectangle drawing by 45°:
        
        @Preview
        @Composable
        fun DrawRect() {

            Canvas(modifier = Modifier.size(300.dp)) {

                rotate(45f) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(200f, 200f),
                        size = size / 2f
                    )
                }
            }
        }
    """.trimIndent()

    val circleOval = """
        46.7 Drawing circles and ovals

        Circles are drawn in Compose using the drawCircle() function. 
        The following code draws a circle centered within a Canvas.
        Note that we find the center of the canvas by referencing the DrawScope center property:
         
         @Preview
         @Composable
         fun DrawCircle() {
             Canvas(modifier = Modifier.size(300.dp)) {

                 drawCircle(
                     color = Color.Blue,
                     center = center,
                     radius = 120.dp.toPx()
                 )
             }
         }
         
         Oval shapes, on the other hand, are drawn by calling the drawOval() function. 
         The following composable, for example, draws the outline of an oval shape:
         
         @Preview
         @Composable
         fun DrawOval() {

             Canvas(modifier = Modifier.size(300.dp)) {
                 val canvasWidth = size.width
                 val canvasHeight = size.height
                 drawOval(
                     color = Color.Blue,
                     topLeft = Offset(x = 25.dp.toPx(), y = 90.dp.toPx()),
                     size = Size(
                         width = canvasWidth - 50.dp.toPx(),
                         height = canvasHeight / 2 - 50.dp.toPx()
                     ),
                     style = Stroke(width = 12.dp.toPx())
                 )
             }
         }
    """.trimIndent()

    val gradient = """
        46.8 Рисование градиентов

        Фигуры можно заполнить с помощью градиентных узоров, используя компонент «Кисть», 
        который, в свою очередь, может рисовать горизонтальные, вертикальные, линейные,
        радиальные и плавные градиенты. Например, чтобы заполнить прямоугольник горизонтальным
        градиентом, нам нужна кисть, инициализированная списком цветов, а также начальным 
        и конечным положениями по оси X и дополнительным параметром режима мозаики.
        В следующем примере рисуется прямоугольник, занимающий весь холст,
        и заполняется горизонтальным градиентом:
        
        @Preview
        @Composable
        fun GradientFill() {

            Canvas(modifier = Modifier.size(300.dp)) {
                val canvasSize = size
                val colorList: List<Color> = listOf(Color.Red, Color.Blue,
                    Color.Magenta, Color.Yellow, Color.Green, Color.Cyan)
                val brush = Brush.horizontalGradient(
                    colors = colorList,
                    startX = 0f,
                    endX = 300.dp.toPx(),
                    tileMode = TileMode.Repeated
                )
                drawRect(
                    brush = brush,
                    size = canvasSize
                )
            }
        }

        @Preview
        @Composable
        fun RadialFill() {
            Canvas(modifier = Modifier.size(300.dp)) {
                val radius = 150.dp.toPx()
                val colorList: List<Color> = listOf(Color.Red, Color.Blue,
                    Color.Magenta, Color.Yellow, Color.Green, Color.Cyan)

                val brush = Brush.radialGradient(
                    colors = colorList,
                    center = center,
                    radius = radius,
                    tileMode = TileMode.Repeated
                )

                drawCircle(
                    brush = brush,
                    center = center,
                    radius = radius
                )
            }
        }
        
        Градиенты особенно полезны для добавления теневых эффектов на рисунки. Рассмотрим, 
        например, следующий горизонтальный градиент, применённый к рисунку круга:
        
        @Preview
        @Composable
        fun ShadowCircle() {

            Canvas(modifier = Modifier.size(300.dp)) {
                val radius = 150.dp.toPx()
                val colorList: List<Color> =
                    listOf(Color.Blue, Color.Black)
                val brush = Brush.horizontalGradient(
                    colors = colorList,
                    startX = 0f,
                    endX = 300.dp.toPx(),
                    tileMode = TileMode.Repeated
                )

                drawCircle(
                brush = brush,
                radius = radius
                )
            }
        }
    """.trimIndent()

    val arc = """
        46.9 Рисование дуг

        В Drawar() нарисовать дугу() Функция DrawScope используется для рисования дуги, 
        вписывающейся в заданный прямоугольник, и требует указания кисти или цвета, 
        а также углов начала и поворота. Например, следующий код рисует дугу, начинающуюся
        под углом 20° и поворачивающуюся на 90° в пределах прямоугольника размером 250dp на 250dp:
         
         @Composable
         fun DrawArc() {

             Canvas(modifier = Modifier.size(300.dp)) {
                 drawArc(
                     Color.Blue,
                     startAngle = 20f,
                     sweepAngle = 90f,
                     useCenter = true,
                     size = Size(250.dp.toPx(), 250.dp.toPx())
                 )
             }
         }
    """.trimIndent()

    val pathDemo = """
        46.10 Рисование контуров

        До сих пор в этой главе мы фокусировались на рисовании предопределённых фигур, 
        таких как круги и прямоугольники. DrawScope также поддерживает рисование контуров. 
        Контуры — это, по сути, линии, проведённые между несколькими координатами в пределах
        области холста. Контуры хранятся в экземпляре класса Path, который после определения
        передаётся в Чертежный путь() функция для рендеринга на холсте.

        При проектировании пути необходимо moveTo() Сначала вызывается функция для определения 
        начальной точки первой линии. Затем проводится линия до следующей позиции с помощью 
        линеТо() или relativeLineTo() функции. В линеТо() Функция принимает координаты x и y
        следующей позиции относительно верхнего левого угла родительского холста. relativeLineTo()
        Функция, с другой стороны, предполагает, что переданные ей координаты относятся к предыдущему 
        положению и могут быть отрицательными или положительными. Класс Path также включает функции
         для рисования непрямых линий, в том числе кубических и квадратичных кривых Безье.

        Как только путь будет завершен, закрыть() функция должна быть вызвана для завершения рисования.

        В пределах MainActivity.kt Чтобы нарисовать произвольную форму с помощью комбинации
        прямых линий и кривых Безье, внесите следующие изменения в файл:
        
        @Composable
        fun DrawPath() {

            Canvas(modifier = Modifier.size(300.dp)) {


                val path = Path().apply {
                    moveTo(0f, 0f)
                   // quadraticBezierTo(50.dp.toPx(), 200.dp.toPx(),
                    quadraticTo(
                        50.dp.toPx(), 200.dp.toPx(),
                        300.dp.toPx(), 300.dp.toPx()
                    )

                    lineTo(270.dp.toPx(), 100.dp.toPx())
                   // quadraticBezierTo(60.dp.toPx(), 80.dp.toPx(), 0f, 0f)
                    quadraticTo(60.dp.toPx(), 80.dp.toPx(), 0f, 0f)
                    close()
                }

                drawPath(
                    path = path,
                    Color.Blue,
                    )
            }
        }
    """.trimIndent()

    val drawPoints = """
        46.11 Точки рисования drawPoints()

        В Точки drawPoints() функция используется для отрисовки отдельных точек в местах,
        указанных списком экземпляров Offset. Параметр pointMode функции drawPoints() 
        Функция используется для управления тем, будет ли каждая точка отображаться отдельно
        (в режиме «Точки») или соединена линиями в режимах «Линии» и «Многоугольник». 
        drawPoints() функция в режиме «Точки» особенно полезна для алгоритмического рисования.
        Например, следующий код строит синусоиду, состоящую из отдельных точек:
        
        @Composable
        fun DrawPoints() {

            Canvas(modifier = Modifier.size(300.dp)) {
                val height = size.height
                val width = size.width
                val points = mutableListOf<Offset>()
                for (x in 0..size.width.toInt()) {
                    val y = (kotlin.math.sin(x * (2f * PI / width))
                            * (height / 2) + (height / 2)).toFloat()
                    points.add(Offset(x.toFloat(), y))
                }

                drawPoints(
                    points = points,
                    strokeWidth = 3f,
                    pointMode = PointMode.Points,
                    color = Color.Blue
                )
            }

        }
        
    """.trimIndent()

    val drawingImage = """
         Drawing an image
         Ресурс изображения можно нанести на холст с помощью вызова функции N
         нариСуйте изображение() функция. Чтобы увидеть эту функцию в действии,
         нам сначала нужно добавить в проект ресурс с изображением
         
         В Android Studio откройте окно диспетчера ресурсов. Найдите отпуск.png
          Найдите изображение в проводнике файловой системы вашей операционной 
          системы и перетащите его в окно диспетчера ресурсов. В появившемся
           диалоговом окне нажмите «Далее», а затем кнопку «Импорт», чтобы
            добавить изображение в проект. Теперь изображение должно появиться в
            диспетчере ресурсов.
           
            В нариСуйте изображение() Функция также позволяет применять цветовые фильтры к
            отображаемому изображению. Для этого требуется экземпляр ColorFilter,
            который можно настроить с помощью параметров оттенка, освещения, 
            цветовой матрицы и смешивания. Полное описание цветовой фильтрации выходит
            за рамки этой книги, но дополнительную информацию можно найти на следующей веб-странице:

            https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/ColorFilter
            
            @Preview
            @Composable
            fun DrawImage() {

                val image = ImageBitmap.imageResource(id = R.drawable.vacation)

                Canvas(
                    modifier = Modifier
                        .size(360.dp, 270.dp)
                ) {
                    drawImage(
                        image = image,
                        topLeft = Offset(x = 0f, y = 0f),
                        colorFilter = ColorFilter.tint(
                            color = Color(0xADFFAA2E),
                            blendMode = BlendMode.ColorBurn
                        )
                    )
                }
            }
            
    """.trimIndent()

    val drawingText = """
        
         Рисование текста

Текст рисуется на холсте с помощью DrawScope DrawText() функция и экземпляр TextMeasurer. 
Роль TextMeasurer заключается в вычислении размера текста на основе таких факторов,
 как семейство шрифтов и размер. Мы можем получить экземпляр TextMeasurer, вызвав 
 Запомнить текстовый измеритель() функционируйте следующим образом:
 
 val textMeasurer = rememberTextMeasurer()
 
 Получив экземпляр TextMeasurer, мы можем передать его в DrawText() функция вместе
  с текстом, который нужно нарисовать:
  
  Canvas(modifier = Modifier.fillMaxSize()) {
  drawText(textMeasurer, "Sample Text")
  }
  
  В то время как приведенный выше пример отображает обычную текстовую строку,
  рисование текста лучше всего работает при использовании с аннотированными строками
  (тема, рассмотренная в этой книге “Аннотированные строки и стили кисти” глава).
  
  Preview
  @Composable
  fun DrawText() {

      val colorList: List<Color> = listOf(
          Color.Black,
          Color.Blue, Color.Yellow, Color.Red, Color.Green, Color.Magenta
      )
      val textMeasurer = rememberTextMeasurer()
      val annotatedText = buildAnnotatedString {
          withStyle(
              style = SpanStyle(
                  fontSize = 60.sp,
                  fontWeight = FontWeight.ExtraBold,
                  brush = Brush.verticalGradient(colors = colorList)
              )
          ) {
              append("Text Drawing")
          }
      }
      Canvas(modifier = Modifier.fillMaxSize()) {
          drawText(textMeasurer, annotatedText)
      }
  }
  
  Интересным преимуществом использования TextMeasurer является то, что он предоставляет
   доступ к размерам нарисованного текста. Эта информация полезна, если вам нужно добавить 
   фон, соответствующий размеру текста. Размер текста можно получить, передав аннотированную 
   строку в TextMeasurer. measure() <&#0;" [размер/шрифт> функция. measure()
    Функция вернёт объект TextLayoutResult, из которого мы можем извлечь свойства размера.

  Чтобы увидеть это в действии, измените функцию DrawText следующим образом, 
  чтобы текст отображался на фоне с горизонтальным градиентом подходящего размера:
  
  @Preview
  @Composable
  fun DrawText2() {

      val colorList: List<Color> = listOf(
          Color.Black,
          Color.Blue, Color.Yellow, Color.Red, Color.Green, Color.Magenta
      )
      val textMeasurer = rememberTextMeasurer()
      val annotatedText = buildAnnotatedString {
          withStyle(
              style = SpanStyle(
                  fontSize = 60.sp,
                  fontWeight = FontWeight.ExtraBold,
                  brush = Brush.verticalGradient(colors = colorList)
              )
          ) {
              append("Text Drawing")
          }
      }
      Canvas(modifier = Modifier.fillMaxSize()) {

          val dimensions = textMeasurer.measure(annotatedText)

          drawRect(
              brush = Brush.horizontalGradient(colors = colorList),
              size = dimensions.size.toSize()
          )
          drawText(textMeasurer, annotatedText)
      }
  }
    """.trimIndent()

    @Composable
    fun choiceText(
        slot: CanvasTexts,
        isShowDialogClick: (Boolean, String) -> Unit
    ): AnnotatedString {
        return when (slot) {
            CanvasTexts.Canvas -> colorFun(
                text = canvas,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.CanvasSample -> colorFun(
                text = canvasSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.CanvasWithDescription -> colorFun(
                text = canvasWithDescription,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.CanvasWithDescriptionCode -> colorFun(
                text = canvasWithDescriptionCode,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.StampedPathEffectCode -> colorFun(
                text = stampedPathEffectSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.GradientBrushSample -> colorFun(
                text = gradientBrushSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawTextSample -> colorFun(
                text = drawTextSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawTextStyledSample -> colorFun(
                text = drawTextStyledSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawTextAnnotatedStringSample -> colorFun(
                text = drawTextAnnotatedStringSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawTextMeasureInLayoutSample -> colorFun(
                text = drawTextMeasureInLayoutSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawTextDrawWithCacheSample -> colorFun(
                text = drawTextDrawWithCacheSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawScopeSample -> colorFun(
                text = drawScopeSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawScopeBatchedTransformSample -> colorFun(
                text = drawScopeBatchedTransformSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawScopeOvalBrushSample -> colorFun(
                text = drawScopeOvalBrushSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawScopeRetargetingSample -> colorFun(
                text = drawScopeRetargetingSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawWithCacheModifierSample -> colorFun(
                text = drawWithCacheModifierSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawWithCacheModifierStateParameterSample -> colorFun(
                text = drawWithCacheModifierStateParameterSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawWithCacheContentSample -> colorFun(
                text = drawWithCacheContentSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawModifierNodeSample -> colorFun(
                text = drawModifierNodeSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.LineCanvas -> colorFun(
                text = lineCanvas,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.Dashpathefect -> colorFun(
                text = dashpathefect,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.DrawRectDemo -> colorFun(
                text = drawRectDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            CanvasTexts.CornerRadius -> colorFun(
                text = cornerRadius,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
             CanvasTexts.Rotating -> colorFun(
                text = rotating,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
             CanvasTexts.CircleOval -> colorFun(
                text = circleOval,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
              CanvasTexts.Gradient -> colorFun(
                text = gradient,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
              CanvasTexts.Arc -> colorFun(
                text = arc,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
            CanvasTexts.PathDemo -> colorFun(
                text = pathDemo,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
              CanvasTexts.DrawPoints -> colorFun(
                text = drawPoints,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
             CanvasTexts.DrawingImage -> colorFun(
                text = drawingImage,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
             CanvasTexts.DrawingText -> colorFun(
                text = drawingText,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })


        }
    }

}

enum class CanvasTexts {
    Canvas, CanvasSample, CanvasWithDescription, CanvasWithDescriptionCode, StampedPathEffectCode,
    GradientBrushSample, DrawTextSample, DrawTextStyledSample, DrawTextAnnotatedStringSample,
    DrawTextMeasureInLayoutSample, DrawTextDrawWithCacheSample, DrawScopeSample, DrawScopeBatchedTransformSample,
    DrawScopeOvalBrushSample, DrawScopeRetargetingSample, DrawWithCacheModifierSample,
    DrawWithCacheModifierStateParameterSample, DrawWithCacheContentSample, DrawModifierNodeSample,
    LineCanvas, Dashpathefect, DrawRectDemo, CornerRadius, Rotating, CircleOval, Gradient, Arc,
    PathDemo, DrawPoints, DrawingImage, DrawingText,
}