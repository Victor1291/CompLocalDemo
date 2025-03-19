package com.shu.complocaldemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.doc_compose.material3.AlertDemo
import com.shu.complocaldemo.doc_compose.material3.AlertTexts
import com.shu.complocaldemo.doc_compose.material3.CanvasDemo
import com.shu.complocaldemo.doc_compose.material3.CanvasTexts
import com.shu.complocaldemo.doc_compose.material3.ListItemDemo
import com.shu.complocaldemo.doc_compose.material3.ListTexts
import com.shu.complocaldemo.doc_compose.material3.TypographyDemo
import com.shu.complocaldemo.material3Demo.AlertDialogFlowRowDemo
import com.shu.complocaldemo.material3Demo.AlertDialogSample
import com.shu.complocaldemo.material3Demo.AlertDialogWithIconSample
import com.shu.complocaldemo.material3Demo.BasicAlertDialogSample
import com.shu.complocaldemo.material3Demo.CanvasPieChartSample
import com.shu.complocaldemo.material3Demo.CanvasSample
import com.shu.complocaldemo.material3Demo.DrawModifierNodeSample
import com.shu.complocaldemo.material3Demo.DrawScopeBatchedTransformSample
import com.shu.complocaldemo.material3Demo.DrawScopeOvalBrushSample
import com.shu.complocaldemo.material3Demo.DrawScopeRetargetingSample
import com.shu.complocaldemo.material3Demo.DrawScopeSample
import com.shu.complocaldemo.material3Demo.DrawTextAnnotatedStringSample
import com.shu.complocaldemo.material3Demo.DrawTextDrawWithCacheSample
import com.shu.complocaldemo.material3Demo.DrawTextMeasureInLayoutSample
import com.shu.complocaldemo.material3Demo.DrawTextSample
import com.shu.complocaldemo.material3Demo.DrawTextStyledSample
import com.shu.complocaldemo.material3Demo.DrawWithCacheContentSample
import com.shu.complocaldemo.material3Demo.DrawWithCacheModifierSample
import com.shu.complocaldemo.material3Demo.DrawWithCacheModifierStateParameterSample
import com.shu.complocaldemo.material3Demo.GradientBrushSample
import com.shu.complocaldemo.material3Demo.HeaderSticky
import com.shu.complocaldemo.material3Demo.PullToRefreshScalingSample
import com.shu.complocaldemo.material3Demo.StampedPathEffectSample
import com.shu.complocaldemo.material3Demo.ThreeLineListItemWithExtendedSupporting
import com.shu.complocaldemo.material3Demo.ThreeLineListItemWithOverlineAndSupporting
import com.shu.complocaldemo.material3Demo.TwoLineListItem
import com.shu.complocaldemo.string.AnimatedText

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Material3Item(header: String, isShowDialogClick: (Boolean, String) -> Unit) {

    Column {
        AnimatedText(
            header = "Typography",
            textNew = buildAnnotatedString {
                append(TypographyDemo.typographyClass)
            }
        )

        //AlertDialog
        AnimatedText(header = "AlertDialog", size = fontSizeBig) {
            Column {
                AnimatedText(
                    header = "AlertDialog",
                    textNew = buildAnnotatedString {
                        append(AlertDemo.alertDialog)
                    }
                )
                AnimatedText(header = "AlertDialogSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = AlertDemo.choiceText(slot = AlertTexts.AlertDialogSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            AlertDialogSample()
                        }
                    }
                }
                AnimatedText(header = "AlertDialogWithIconSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = AlertDemo.choiceText(slot = AlertTexts.AlertDialogWithIconSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            AlertDialogWithIconSample()
                        }
                    }
                }

                AnimatedText(
                    header = "BasicAlertDialog",
                    textNew = buildAnnotatedString {
                        append(AlertDemo.basicAlertDialog)
                    }
                )

                AnimatedText(header = "BasicAlertDialogSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = AlertDemo.choiceText(slot = AlertTexts.BasicAlertDialogSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            BasicAlertDialogSample()
                        }
                    }
                }

                AnimatedText(
                    header = "AlertDialogDefaults",
                    textNew = buildAnnotatedString {
                        append(AlertDemo.alertDialogDefaults)
                    }
                )

                AnimatedText(
                    header = "AlertDialogImpl",
                    textNew = buildAnnotatedString {
                        append(AlertDemo.alertDialogImpl)
                    }
                )

                AnimatedText(
                    header = "AlertDialog",
                    textNew = buildAnnotatedString {
                        append(AlertDemo.actualAlertDialog)
                    }
                )

                AnimatedText(header = "AlertDialogFlowRowDemo ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = AlertDemo.choiceText(slot = AlertTexts.AlertDialogFlowRowDemo,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            AlertDialogFlowRowDemo()
                        }
                    }
                }
            }
        }

        AnimatedText(header = "ListItem", size = fontSizeBig) {
            Column {
                AnimatedText(
                    header = "ListItem",
                    textNew = ListItemDemo.choiceText(slot = ListTexts.ListItem,
                        isShowDialogClick =
                        { isShow, textNew ->
                            isShowDialogClick(isShow, textNew)
                        }),
                    fontSizeSmall
                ) {}
                AnimatedText(
                    header = "UrlList",
                    textNew = ListItemDemo.choiceText(slot = ListTexts.UrlList,
                        isShowDialogClick =
                        { isShow, textNew ->
                            isShowDialogClick(isShow, textNew)
                        }),
                    fontSizeSmall
                ) {}

                AnimatedText(header = "OneLineListItem ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = ListItemDemo.choiceText(slot = ListTexts.OneLineListItem,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        var isShowDialog by remember { mutableStateOf(false) }
                        AnimatedText(
                            header = "Preview ",
                            size = fontSizeSmall,
                            onClick = { show ->
                                isShowDialog = show
                            }) {

                            if (isShowDialog) {
                                BasicAlertDialog(onDismissRequest = { isShowDialog = false }) {
                                    Surface(
                                        modifier = Modifier
                                            .wrapContentWidth()
                                            .wrapContentHeight(),
                                        shape = MaterialTheme.shapes.medium,
                                        tonalElevation = AlertDialogDefaults.TonalElevation
                                    ) {
                                        PullToRefreshScalingSample()
                                    }
                                }
                            }
                        }
                    }
                }
                AnimatedText(header = "TwoLineListItem ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = ListItemDemo.choiceText(slot = ListTexts.TwoLineListItem,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            TwoLineListItem()
                        }
                    }
                }

                AnimatedText(
                    header = "ThreeLineListItemWithOverlineAndSupporting ",
                    size = fontSizeBig
                ) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = ListItemDemo.choiceText(slot = ListTexts.ThreeLineListItemWithOverlineAndSupporting,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            ThreeLineListItemWithOverlineAndSupporting()
                        }
                    }
                }
                AnimatedText(
                    header = "ThreeLineListItemWithExtendedSupporting ",
                    size = fontSizeBig
                ) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = ListItemDemo.choiceText(slot = ListTexts.ThreeLineListItemWithExtendedSupporting,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            ThreeLineListItemWithExtendedSupporting()
                        }
                    }
                }
                AnimatedText(
                    header = "ListItemCode",
                    textNew = ListItemDemo.choiceText(slot = ListTexts.ListItemCode,
                        isShowDialogClick =
                        { isShow, textNew ->
                            isShowDialogClick(isShow, textNew)
                        }),
                    fontSizeSmall
                ) {}
                AnimatedText(
                    header = "ListItemLayout",
                    textNew = ListItemDemo.choiceText(slot = ListTexts.ListItemLayout,
                        isShowDialogClick =
                        { isShow, textNew ->
                            isShowDialogClick(isShow, textNew)
                        }),
                    fontSizeSmall
                ) {}
                AnimatedText(
                    header = "ListItemMeasurePolicy",
                    textNew = ListItemDemo.choiceText(slot = ListTexts.ListItemMeasurePolicy,
                        isShowDialogClick =
                        { isShow, textNew ->
                            isShowDialogClick(isShow, textNew)
                        }),
                    fontSizeSmall
                ) {}
                AnimatedText(
                    header = "ListItemDefaults",
                    textNew = ListItemDemo.choiceText(slot = ListTexts.ListItemDefaults,
                        isShowDialogClick =
                        { isShow, textNew ->
                            isShowDialogClick(isShow, textNew)
                        }),
                    fontSizeSmall
                ) {}
                AnimatedText(
                    header = "HeaderSticky ",
                    size = fontSizeBig
                ) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = ListItemDemo.choiceText(slot = ListTexts.HeaderSticky,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        var isShowDialog by remember { mutableStateOf(false) }
                        AnimatedText(header = "Preview ", size = fontSizeSmall,
                            onClick = { show ->
                                isShowDialog = show
                            }) {
                            if (isShowDialog) {
                                BasicAlertDialog(onDismissRequest = { isShowDialog = false }) {
                                    Surface(
                                        modifier = Modifier
                                            .wrapContentWidth()
                                            .wrapContentHeight(),
                                        shape = MaterialTheme.shapes.medium,
                                        tonalElevation = AlertDialogDefaults.TonalElevation
                                    ) {
                                        HeaderSticky()
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        //Canvas
        AnimatedText(header = "Canvas", size = fontSizeBig) {
            Column {
                AnimatedText(
                    header = "Canvas",
                    textNew = buildAnnotatedString {
                        append(CanvasDemo.canvas)
                    }
                )
                AnimatedText(header = "CanvasSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.CanvasSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            CanvasSample()
                        }
                    }
                }
                AnimatedText(
                    header = "CanvasWithDescription",
                    textNew = buildAnnotatedString {
                        append(CanvasDemo.canvasWithDescription)
                    }
                )

                AnimatedText(header = "CanvasWithDescriptionCode ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.CanvasWithDescriptionCode,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            CanvasPieChartSample()
                        }
                    }
                }

                AnimatedText(header = "StampedPathEffectCode ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.StampedPathEffectCode,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            StampedPathEffectSample()
                        }
                    }
                }

                AnimatedText(header = "GradientBrushSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.GradientBrushSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            GradientBrushSample()
                        }
                    }
                }

                AnimatedText(header = "DrawTextSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawTextSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawTextSample()
                        }
                    }
                }

                AnimatedText(header = "DrawTextStyledSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawTextStyledSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawTextStyledSample()
                        }
                    }
                }

                AnimatedText(header = "DrawTextAnnotatedStringSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawTextAnnotatedStringSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawTextAnnotatedStringSample()
                        }
                    }
                }

                AnimatedText(header = "DrawTextMeasureInLayoutSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawTextMeasureInLayoutSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawTextMeasureInLayoutSample()
                        }
                    }
                }

                AnimatedText(header = "DrawTextDrawWithCacheSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawTextDrawWithCacheSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawTextDrawWithCacheSample()
                        }
                    }
                }

                AnimatedText(header = "DrawScopeSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawScopeSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawScopeSample()
                        }
                    }
                }
                AnimatedText(header = "DrawScopeBatchedTransformSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawScopeBatchedTransformSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawScopeBatchedTransformSample()
                        }
                    }
                }
                AnimatedText(header = "DrawScopeOvalBrushSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawScopeOvalBrushSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawScopeOvalBrushSample()
                        }
                    }
                }

                AnimatedText(header = "DrawScopeRetargetingSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawScopeRetargetingSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawScopeRetargetingSample()
                        }
                    }
                }
                AnimatedText(header = "DrawWithCacheModifierSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawWithCacheModifierSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawWithCacheModifierSample()
                        }
                    }
                }
                AnimatedText(
                    header = "DrawWithCacheModifierStateParameterSample ",
                    size = fontSizeBig
                ) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawWithCacheModifierStateParameterSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawWithCacheModifierStateParameterSample()
                        }
                    }
                }
                AnimatedText(header = "DrawWithCacheContentSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawWithCacheContentSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawWithCacheContentSample()
                        }
                    }
                }
                AnimatedText(header = "DrawModifierNodeSample ", size = fontSizeBig) {
                    Column {
                        AnimatedText(
                            header = "Code ",
                            textNew = CanvasDemo.choiceText(slot = CanvasTexts.DrawModifierNodeSample,
                                isShowDialogClick =
                                { isShow, textNew ->
                                    isShowDialogClick(isShow, textNew)
                                }),
                            fontSizeSmall
                        ) {
                        }
                        AnimatedText(header = "Preview ", size = fontSizeSmall) {
                            DrawModifierNodeSample()
                        }
                    }
                }


            }
        }
    }
}


private val fontSizeSmall = 14.sp
private val fontSizeBig = 16.sp


