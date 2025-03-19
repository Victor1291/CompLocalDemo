package com.shu.complocaldemo.constrait

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.shu.complocaldemo.R
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme

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

@Preview(showBackground = true)
@Composable
fun BeatlesPreview() {
    CompLocalDemoTheme {
        Beatles()
    }
}