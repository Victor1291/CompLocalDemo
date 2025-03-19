package com.shu.complocaldemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.EmojiSupportMatch
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

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


@Preview(showBackground = true)
@Composable
fun SpanStringPreview() {
    CompLocalDemoTheme {
        MainScreen2()
    }
}

/*
A SpanStyle instance can be initialized with any combination of the following style options:

• color
• fontSize
• fontWeight
• fontStyle
• fontSynthesis
• fontFamily
• fontFeatureSettings
• letterSpacing
• baselineShift - The amount by which the text is shifted up from the current baseline.Величина, на которую текст смещен вверх от текущей базовой линии
• textGeometricTransform
• localeList
• background
• textDecoration
• shadow

ParagraphStyle, on the other hand, applies a style to paragraphs and can be used to modify the following properties:

• textAlign
• textDirection
• lineHeight
• textIndent

The following is the basic syntax for using paragraph styles in annotated strings:

buildAnnotatedString {

withStyle(style = ParagraphStyle( /* style settings */)) {
    append(/* text string */)
    }
    withStyle(style = ParagraphStyle(/* style settings */))
    append(/* more text */)
    }
}
 */