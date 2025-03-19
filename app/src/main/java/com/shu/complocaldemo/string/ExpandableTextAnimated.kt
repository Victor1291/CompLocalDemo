package com.shu.complocaldemo.string

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun AnimatedText(
    header: String,
    textNew: AnnotatedString = AnnotatedString(""),
    size: TextUnit = 14.sp,
    onClick: (Boolean) -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val showMoreText: String = " show "
    val showLessText: String = " hide "
    val showMoreStyle: SpanStyle = SpanStyle(color = Color.Blue, fontWeight = FontWeight.W500)
    val showLessStyle: SpanStyle = SpanStyle(color = Color.Blue, fontWeight = FontWeight.W500)
    val showHeaderStyle: SpanStyle = SpanStyle(color = Color.Red, fontWeight = FontWeight.W500)
    val colorList: List<Color> = listOf(
        Color.Red, Color.Blue,
        Color.Magenta, Color.Magenta, Color.Blue, Color.Red
    )
    val paragraphStyle = ParagraphStyle(
        textAlign = TextAlign.Start,
        lineHeight = size,
        lineHeightStyle = LineHeightStyle(
            LineHeightStyle.Alignment.Proportional,
            LineHeightStyle.Trim.Both
        ),
        textIndent = TextIndent(
            firstLine = 10.sp,
            restLine = 5.sp
        ),
        textMotion = TextMotion.Animated
    )
    val paragraphEnd = ParagraphStyle(
        textAlign = TextAlign.End,
        lineHeight = size,
        lineHeightStyle = LineHeightStyle(
            LineHeightStyle.Alignment.Proportional,
            LineHeightStyle.Trim.Both
        ),
        textMotion = TextMotion.Animated
    )
    val spanStyle = SpanStyle(
        fontWeight = FontWeight.Normal,
        fontSize = size,
        // brush = Brush.linearGradient(colors = colorList),
        //  baselineShift = BaselineShift.Subscript,
        //  textDecoration = TextDecoration.Underline,
        // textGeometricTransform = TextGeometricTransform(skewX = -0.4f),
        /* shadow = Shadow(
             Color.Black.copy(alpha = 0.2f),
             Offset(5f, 5f),
             blurRadius = 2f
         ),*/
    )

    var isExpanded by remember { mutableStateOf(false) }
    val annotatedTextMax = buildAnnotatedString {
        append(buildAnnotatedString {
            withStyle(style = showHeaderStyle) {
                append(header)
            }
            append(textNew)
            withLink(
                link = LinkAnnotation.Clickable(
                    tag = "Show Less",
                    styles = TextLinkStyles(showLessStyle),
                    linkInteractionListener = { isExpanded = !isExpanded
                    onClick(false)
                    }
                )
            ) {
                append(showLessText)
            }
        }
        )
    }

    val annotatedTextMin = buildAnnotatedString {
        append(buildAnnotatedString {
            withStyle(style = showHeaderStyle) {
                append(header)
            }
            withLink(
                link = LinkAnnotation.Clickable(
                    tag = "Show More",
                    styles = TextLinkStyles(showLessStyle),
                    linkInteractionListener = {
                        isExpanded = !isExpanded
                    onClick(true)
                    }
                )
            ) {
                append(showMoreText)
            }
        })
    }

    ExpandableTextAnimated(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textMax = annotatedTextMax,
        textMin = annotatedTextMin,
        isExpanded = isExpanded,
        onClick = { }, //isExpanded = !isExpanded },
        content = content
    )
}

@Composable
fun ExpandableTextAnimated(
    modifier: Modifier = Modifier,
    textMax: AnnotatedString,
    textMin: AnnotatedString,
    isExpanded: Boolean,
    collapsedMaxLine: Int = 4,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    textColor: Color = Color.Black,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        /* AnimatedContent(
            targetState = isExpanded,
            label = "",
            transitionSpec = {
                fadeIn(animationSpec = tween(150, delayMillis = 0))
                    .togetherWith(fadeOut(animationSpec = tween(150)))
                    .using(
                        SizeTransform { initialSize, targetSize ->
                            // Using different SizeTransform for different state change
                            if (targetState) {
                                keyframes {
                                    durationMillis = 500

                                    // Animate to full target width and by 200px in height at 150ms
                                    IntSize(targetSize.width, initialSize.height + 200) at 150
                                }
                            } else {
                                keyframes {
                                    durationMillis = 200

                                    // Animate 1/ 2 the height without changing the width at 150ms.
                                    // The width and rest of the height will be animated in the
                                    // timeframe between 150ms and duration (i. e. 500ms)
                                    IntSize(
                                        initialSize.width,
                                        (initialSize.height + targetSize.height) / 2
                                    ) at 150
                                }
                            }
                        })
            }
        ) {*/
        Column() {
            Text(
                modifier = modifier
                    // .clickable { onClick() }
                    .animateContentSize(),
                text = if (isExpanded) textMax else textMin,
                maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            )
            if (isExpanded) {
                content()
            }
        }


        //   }
        // }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimatedPreview() {
    CompLocalDemoTheme {
        val sampleText =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        val header = "Новая глава знаний:  "
        AnimatedText(
            header = header,
            textNew = AnnotatedString( sampleText),
            22.sp
        )
    }
}
