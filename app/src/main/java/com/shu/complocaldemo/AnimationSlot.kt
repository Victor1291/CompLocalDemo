package com.shu.complocaldemo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.shu.complocaldemo.doc_compose.animation.screen.HomeScreen
import com.shu.complocaldemo.string.AnimatedText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimationSlot(header: String, isShowDialogClick: (Boolean, String) -> Unit) {
    var isShowDialog by remember { mutableStateOf(false) }
    AnimatedText(header = header, size = fontSizeBig) {
        Column {
            AnimatedText(header = "ComposeAnimation ", size = fontSizeBig) {
                Column {
                    AnimatedText(header = "Preview ", size = fontSizeSmall, onClick = { show ->
                        isShowDialog = show
                    }) {
                        if (isShowDialog) {
                            BasicAlertDialog(onDismissRequest = { isShowDialog = false }) {
                                Surface(color = MaterialTheme.colorScheme.background) {
                                    Navigator(HomeScreen) { navigator ->
                                        SlideTransition(navigator)
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