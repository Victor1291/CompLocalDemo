package com.shu.complocaldemo.doc_compose.animation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shu.complocaldemo.doc_compose.animation.page.StaggeredPage

object StaggeredScreen : Screen {
    private fun readResolve(): Any = StaggeredScreen

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        StaggeredPage(goBack = { navigator.pop() })
    }
}
