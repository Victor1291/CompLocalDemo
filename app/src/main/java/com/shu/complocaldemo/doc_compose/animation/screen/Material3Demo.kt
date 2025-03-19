package com.shu.complocaldemo.doc_compose.animation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shu.complocaldemo.doc_compose.animation.page.EasingDemo
import com.shu.complocaldemo.doc_compose.animation.page.Material3Page

object Material3Demo : Screen {
    private fun readResolve(): Any = Material3Demo

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Material3Page(goBack = { navigator.pop() })
    }
}
