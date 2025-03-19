package com.shu.complocaldemo.string

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

@Composable
fun ExpandableTextAnimated3(
    modifier: Modifier = Modifier,
    text: String,
    collapsedMaxLine: Int = 3,
    showMoreText: String = " Show More",
    showLessText: String = " Show Less",
    style: TextStyle = MaterialTheme.typography.bodySmall,
    textColor: Color = Color.Black,
    showMoreStyle: SpanStyle = SpanStyle(color = Color.Blue, fontWeight = FontWeight.W500),
    showLessStyle: SpanStyle = SpanStyle(color = Color.Blue, fontWeight = FontWeight.W500),
) {

    var isExpanded by remember { mutableStateOf(false) }
    var isClickable by remember { mutableStateOf(false) }
    var lastCharacterIndex by remember { mutableStateOf(0) }

    AnimatedVisibility(
       visible = isExpanded,
     //   enter = fadeIn(),
      //  exit = fadeOut()
    ) {
        val annotatedTextOne = buildAnnotatedString {
            if (isClickable) {
                append(text)
                withLink(
                    link = LinkAnnotation.Clickable(
                        tag = "Show Less",
                        linkInteractionListener = { isExpanded = !isExpanded }
                    )
                ) {
                    withStyle(style = showLessStyle) {
                        append(showLessText)
                    }
                }
            } else {
                append(text)
            }
        }

        Text(
            text = annotatedTextOne,
            modifier = modifier,
            style = style,
            color = textColor,
            maxLines =  Int.MAX_VALUE ,
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    isClickable = true
                    lastCharacterIndex = textLayoutResult.getLineEnd(collapsedMaxLine - 1)
                }
            },
        )
    }
    AnimatedVisibility(
        visible = !isExpanded,
     //   enter = fadeIn(),
     //   exit = fadeOut()
    ) {

        val annotatedTextTwo = buildAnnotatedString {
            if (isClickable) {
                val adjustText = text.substring(startIndex = 0, endIndex = lastCharacterIndex)
                    .dropLast(showMoreText.length)
                    .dropLastWhile { it.isWhitespace() || it == '.' }
                append(adjustText)
                withLink(
                    link = LinkAnnotation.Clickable(
                        tag = "Show More",
                        linkInteractionListener = { isExpanded = !isExpanded }
                    )
                ) {
                    withStyle(style = showMoreStyle) {
                        append(showMoreText)
                    }
                }
            } else {
                append(text)
            }
        }

        Text(
            text = annotatedTextTwo,
            modifier = modifier,
            style = style,
            color = textColor,
            maxLines = collapsedMaxLine,
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    isClickable = true
                    lastCharacterIndex = textLayoutResult.getLineEnd(collapsedMaxLine - 1)
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedPreview3() {
    CompLocalDemoTheme {
        val sampleText =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        ExpandableTextAnimated3(
            text = sampleText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}