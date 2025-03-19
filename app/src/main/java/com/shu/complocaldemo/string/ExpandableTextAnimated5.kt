package com.shu.complocaldemo.string

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme


enum class ContentStateText5 { Max, Min }

@Composable
fun AnimatedText5(textNew: String) {
    val showMoreText: String = " Show More"
    val showLessText: String = " Show Less"
    val colorList: List<Color> = listOf(
        Color.Red, Color.Blue,
        Color.Magenta, Color.Magenta, Color.Blue, Color.Red
    )

    val stringStyleMax: AnnotatedString = createAnnotatedString5(textNew, colorList)
    val adjustText = textNew.take(80)
    val stringStyleMin = createAnnotatedString5(adjustText, colorList)
    val showMoreTextWithStyle =
        createAnnotatedString5(showMoreText, colorList, color = Color.Blue, TextAlign.End)
    val showLessTextWithStyle =
        createAnnotatedString5(showLessText, colorList, color = Color.Blue, TextAlign.End)

    var isExpanded by remember { mutableStateOf(false) }
    val annotatedTextMax = buildAnnotatedString {
        withLink(
            link = LinkAnnotation.Clickable(
                tag = "Show Less",
                linkInteractionListener = { isExpanded = !isExpanded }
            )
        ) {
            append(showLessTextWithStyle)
        }
        append(stringStyleMax)
    }

    val annotatedTextMin = buildAnnotatedString {
        withLink(
            link = LinkAnnotation.Clickable(
                tag = "Show More",
                linkInteractionListener = { isExpanded = !isExpanded }
            )
        ) {
            append(showMoreTextWithStyle)
        }
        append(stringStyleMin)
    }

    ExpandableTextAnimated5(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textMax = annotatedTextMax,
        textMin = annotatedTextMin,
        isExpanded = isExpanded,
    )
}

@Composable
fun createAnnotatedString5(
    text: String,
    colorList: List<Color>,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start,
): AnnotatedString {

    return AnnotatedString(
        text = text,
        spanStyle = SpanStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 23.sp,
            color = color,
            // brush = Brush.linearGradient(colors = colorList),
            baselineShift = BaselineShift.Subscript,
            //  textDecoration = TextDecoration.Underline,
            textGeometricTransform = TextGeometricTransform(skewX = -0.4f),
            shadow = Shadow(
                Color.Black.copy(alpha = 0.5f),
                Offset(2f, 2f),
                blurRadius = 2f
            ),
        ),
        paragraphStyle = ParagraphStyle(
            textAlign = textAlign,
            lineHeight = 24.sp,
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
    )
}

@Composable
fun ExpandableTextAnimated5(
    modifier: Modifier = Modifier,
    textMax: AnnotatedString,
    textMin: AnnotatedString,
    isExpanded: Boolean,
    collapsedMaxLine: Int = 4,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    textColor: Color = Color.Black,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        AnimatedContent(
            targetState = isExpanded,
            label = "",
            transitionSpec = {
                // We can define how the new target content comes in and how initial content
                // leaves in the ContentTransform. Here we want to create the impression that the
                // different numbers have a spatial relationship - larger numbers are
                // positioned (vertically) below smaller numbers.
                if (targetState) {
                    // If the incoming number is larger, new number slides up and fades in while
                    // the previous (smaller) number slides up to make room and fades out.
                    slideInVertically { it } + fadeIn() togetherWith
                            slideOutVertically { -it } + fadeOut()
                } else {
                    // If the incoming number is smaller, new number slides down and fades in while
                    // the previous number slides down and fades out.
                    slideInVertically { -it } + fadeIn() togetherWith
                            slideOutVertically { it } + fadeOut()
                    // Disable clipping since the faded slide-out is desired out of bounds, but
                    // the size transform is still needed from number getting longer
                }.using(SizeTransform(clip = false))
                // Using default spring for the size change.
            }
        ) {
            when (it) {
                true -> Max5(textMax)
                false -> Min5(textMin, collapsedMaxLine)
            }
        }
    }
}

@Composable
fun Max5(textMax: AnnotatedString) {
    Text(
        text = textMax,
    )
}


@Composable
fun Min5(textMin: AnnotatedString, collapsedMaxLine: Int) {
    Text(
        text = textMin,
        maxLines = collapsedMaxLine,
    )
}


@Preview(showBackground = true)
@Composable
fun AnimatedPreview5() {
    CompLocalDemoTheme {
        val sampleText =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        AnimatedText5(
            textNew = sampleText,
        )
    }
}
