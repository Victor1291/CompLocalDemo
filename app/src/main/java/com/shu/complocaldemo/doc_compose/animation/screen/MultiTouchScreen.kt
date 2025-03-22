package com.shu.complocaldemo.doc_compose.animation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shu.complocaldemo.doc_compose.animation.page.ComposePage
import com.shu.complocaldemo.doc_compose.animation.page.EasingDemo
import com.shu.complocaldemo.doc_compose.animation.page.MultiTouchPage

object MultiTouchScreen : Screen {
    private fun readResolve(): Any = MultiTouchScreen

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        MultiTouchPage(goBack = { navigator.pop() })
    }
}
