package com.shu.complocaldemo.doc_compose.animation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shu.complocaldemo.doc_compose.animation.page.Home

object HomeScreen : Screen {
    private fun readResolve(): Any = HomeScreen

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Home(
            openEasingDemo = { navigator.push(EasingsScreen) },
            openValueAnimatorDemo = { navigator.push(ValueAnimatorScreen) },
            materialDemo = { navigator.push(Material3Demo) },
            listItemDemo = { navigator.push(ListItemD) },
            alertDemo = { navigator.push(AlertD) },
            composeDemo = { navigator.push(ComposeD) },
            staggeredDemo = { navigator.push(StaggeredScreen) },
            pagerDemo = { navigator.push(PagerScreen) },
            drawerDemo = { navigator.push(DrawerScreen) },
            hoursDemo = { navigator.push(HoursScreen) },
        )
    }
}
