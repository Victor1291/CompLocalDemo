package com.shu.complocaldemo.doc_compose.animation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shu.complocaldemo.doc_compose.animation.page.ComposePage
import com.shu.complocaldemo.doc_compose.animation.page.EasingDemo
import com.shu.complocaldemo.doc_compose.animation.page.StoriesPage

object StoriesScreen : Screen {
    private fun readResolve(): Any = StoriesScreen

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        StoriesPage(goBack = { navigator.pop() })
    }
}
