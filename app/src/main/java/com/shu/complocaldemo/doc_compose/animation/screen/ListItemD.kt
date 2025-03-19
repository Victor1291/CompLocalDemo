package com.shu.complocaldemo.doc_compose.animation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shu.complocaldemo.doc_compose.animation.page.ListItemPage

object ListItemD : Screen {
    private fun readResolve(): Any = ListItemD

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ListItemPage(goBack = { navigator.pop() })
    }
}
