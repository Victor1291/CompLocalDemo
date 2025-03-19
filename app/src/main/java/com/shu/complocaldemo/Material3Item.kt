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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.sp
import com.shu.complocaldemo.doc_compose.material3.AlertDemo
import com.shu.complocaldemo.doc_compose.material3.AlertTexts
import com.shu.complocaldemo.doc_compose.material3.ListItemDemo
import com.shu.complocaldemo.doc_compose.material3.ListTexts
import com.shu.complocaldemo.doc_compose.material3.TypographyDemo
import com.shu.complocaldemo.material3Demo.AlertDialogFlowRowDemo
import com.shu.complocaldemo.material3Demo.AlertDialogSample
import com.shu.complocaldemo.material3Demo.AlertDialogWithIconSample
import com.shu.complocaldemo.material3Demo.BasicAlertDialogSample
import com.shu.complocaldemo.material3Demo.HeaderSticky
import com.shu.complocaldemo.material3Demo.OneLineListItem
import com.shu.complocaldemo.material3Demo.PullToRefreshScalingSample
import com.shu.complocaldemo.material3Demo.ThreeLineListItemWithExtendedSupporting
import com.shu.complocaldemo.material3Demo.ThreeLineListItemWithOverlineAndSupporting
import com.shu.complocaldemo.material3Demo.TwoLineListItem
import com.shu.complocaldemo.string.AnimatedText

@OptIn(ExperimentalMaterial3Api::class)
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
    }
}


private val fontSizeSmall = 14.sp
private val fontSizeBig = 16.sp


