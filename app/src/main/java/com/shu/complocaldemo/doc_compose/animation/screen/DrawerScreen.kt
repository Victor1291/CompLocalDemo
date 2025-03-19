package com.shu.complocaldemo.doc_compose.animation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shu.complocaldemo.doc_compose.animation.page.ComposePage
import com.shu.complocaldemo.doc_compose.animation.page.DrawerPage
import com.shu.complocaldemo.doc_compose.animation.page.EasingDemo

object DrawerScreen : Screen {
    private fun readResolve(): Any = DrawerScreen

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        DrawerPage(goBack = { navigator.pop() })
    }
}
