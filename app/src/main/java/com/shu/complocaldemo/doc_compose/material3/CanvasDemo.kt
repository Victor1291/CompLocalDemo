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

        }
    }

}

enum class CanvasTexts {
    Canvas, CanvasSample, CanvasWithDescription, CanvasWithDescriptionCode, StampedPathEffectCode,
    GradientBrushSample, DrawTextSample, DrawTextStyledSample, DrawTextAnnotatedStringSample,
    DrawTextMeasureInLayoutSample, DrawTextDrawWithCacheSample, DrawScopeSample, DrawScopeBatchedTransformSample,
    DrawScopeOvalBrushSample, DrawScopeRetargetingSample, DrawWithCacheModifierSample,
    DrawWithCacheModifierStateParameterSample, DrawWithCacheContentSample, DrawModifierNodeSample
}