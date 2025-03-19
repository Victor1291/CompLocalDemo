package com.shu.complocaldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.shu.complocaldemo.constrait.BarriersDemo
import com.shu.complocaldemo.constrait.Beatles
import com.shu.complocaldemo.constrait.ConstraintBias
import com.shu.complocaldemo.constrait.ConstraintChain
import com.shu.complocaldemo.constrait.ConstraintSetsDemo
import com.shu.complocaldemo.constrait.GuideLinesDemo
import com.shu.complocaldemo.custom.CascadeScreen
import com.shu.complocaldemo.doc_compose.animation.screen.HomeScreen
import com.shu.complocaldemo.doc_compose.coroutine.DemoCoroutines
import com.shu.complocaldemo.intrinsic.IntrinsicMaxDemo
import com.shu.complocaldemo.intrinsic.IntrinsicMinDemo
import com.shu.complocaldemo.string.AnimatedText
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompLocalDemoTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigator(HomeScreen) { navigator ->
                        SlideTransition(navigator)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentMain() {

    /* Scaffold(
         modifier = Modifier
             .fillMaxSize(),
         // containerColor = Color.Black
     ) { innerPadding ->*/
    // MainScreen(modifier = Modifier.padding(innerPadding))
    val sampleText =
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val fontSizeBig = 22.sp
    val fontSizeSmall = 14.sp
    var isShowDialog by remember { mutableStateOf(false) }
    var textDialog by remember { mutableStateOf("New Message") }
    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        item {
            AnimatedText(header = "Modifier ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.ModifierDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        ModifierScreen()
                    }
                }
            }
        }
        item {
            AnimatedText(header = "State ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.ModifierDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        MainScreen()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "String ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.StringDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                        AnimatedText(
                            header = "SpanString ",
                            textNew = CodeSample.choiceText(slot = Texts.SpanString,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(
                            header = "ParaString ",
                            textNew = CodeSample.choiceText(slot = Texts.ParaString,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(
                            header = "BrushStyle ",
                            textNew = CodeSample.choiceText(slot = Texts.BrushStyle,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(
                            header = "BrushStyle2 ",
                            textNew = CodeSample.choiceText(slot = Texts.BrushStyle2,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(
                            header = "BrushStyle3 ",
                            textNew = CodeSample.choiceText(slot = Texts.BrushStyle3,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        MainScreen2()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "Row and Column ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.RowColumnCode,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                        AnimatedText(
                            header = "TextCell ",
                            textNew = CodeSample.choiceText(slot = Texts.TextCell,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(
                            header = "TextRow ",
                            textNew = CodeSample.choiceText(slot = Texts.TextRow,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        MainScreen3()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "Box Layout ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.BoxLayout,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                    ) {
                        AnimatedText(
                            header = "TextCellBox ",
                            textNew = CodeSample.choiceText(slot = Texts.TextCellBox,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        BoxLayout()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "FlowRow ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.FlowRowDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        FlowRowDemo()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "Flow Column ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.FlowColumnDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        FlowColumnDemo()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "LayoutModifier ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.LayoutModifierDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                        AnimatedText(
                            header = "Modifier Extensions ",
                            textNew = CodeSample.choiceText(slot = Texts.ModifierExtension,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        LayoutModifierDemo()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "Cascade Layout ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.CascadeScreen,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                        AnimatedText(
                            header = "CascadeLayout ",
                            textNew = CodeSample.choiceText(slot = Texts.CascadeLayout,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    textDialog = textNew
                                    isShowDialog = isShow
                                }),
                            fontSizeSmall
                        ) {
                        }
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        CascadeScreen()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "Beatles ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.Beatles,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        Beatles()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "ConstraintBias ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.ConstraintBias,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        ConstraintBias()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "ConstraintChain ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.ConstraintChain,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        ConstraintChain()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "GuideLinesDemo ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.GuideLinesDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        GuideLinesDemo()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "BarriersDemo ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.BarriersDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        BarriersDemo()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "ConstraintSetsDemo ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.ConstraintSetsDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        ConstraintSetsDemo()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "IntrinsicMinDemo ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.IntrinsicMinDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        IntrinsicMinDemo()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "IntrinsicMaxDemo ", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "Code ",
                        textNew = CodeSample.choiceText(slot = Texts.IntrinsicMaxDemo,
                            isShowDialogClick =
                            { isShow, textNew ->
                                textDialog = textNew
                                isShowDialog = isShow
                            }),
                        fontSizeSmall
                    ) {
                    }
                    AnimatedText(header = "Preview ", size = fontSizeSmall) {
                        IntrinsicMaxDemo()
                    }
                }
            }
        }

        item {
            AnimatedText(header = "DemoCoroutines", size = fontSizeBig) {
                Column {
                    AnimatedText(
                        header = "coroutineScopeDemo",
                        textNew = buildAnnotatedString {
                            append(DemoCoroutines.coroutineScopeDemo)
                        }
                    )
                    AnimatedText(
                        header = "coroutineBuilders",
                        textNew = buildAnnotatedString {
                            append(DemoCoroutines.coroutineBuilders)
                        }
                    )
                    AnimatedText(
                        header = "jobs",
                        textNew = buildAnnotatedString {
                            append(DemoCoroutines.jobs)
                        }
                    )
                    AnimatedText(
                        header = "channels",
                        textNew = buildAnnotatedString {
                            append(DemoCoroutines.channels)
                        }
                    )
                    AnimatedText(
                        header = "sideEffects",
                        textNew = buildAnnotatedString {
                            append(DemoCoroutines.sideEffects)
                        }
                    )
                    AnimatedText(
                        header = "launchEffect",
                        textNew = buildAnnotatedString {
                            append(DemoCoroutines.launchEffect)
                        }
                    )

                }
            }
        }
        items(list) { item ->
            AnimatedText("$item. Глава ", size = fontSizeBig)
        }
    }

    if (isShowDialog) {
        BasicAlertDialog(onDismissRequest = { isShowDialog = false }) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(
                    Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = textDialog,
                        modifier = Modifier.verticalScroll(ScrollState(0))
                    )
                }
            }
        }
    }
}
/*  Composable1(modifier = Modifier.padding(innerPadding))
  SlotDemo(
      topContent = { Text("Top Text") },
      middleContent = { ButtonDemo() },
      bottomContent = { Text("Bottom Text") }
  )
}*/


val LocalColor = staticCompositionLocalOf { Color(0xFFffdbcf) }
