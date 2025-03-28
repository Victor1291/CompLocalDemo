/*
 * Copyright 2024 Gergely Kőrössy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shu.complocaldemo.lazy.sample.home

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shu.complocaldemo.R
import com.shu.complocaldemo.lazy.sample.Destination
import com.shu.complocaldemo.lazy.sample.Home
import com.shu.complocaldemo.lazy.sample.topDestinations
import com.shu.complocaldemo.lazy.sample.ui.component.NavScreen

fun NavGraphBuilder.homeScreen(
    onSettingsClick: () -> Unit,
    onScreenClick: (destination: Destination) -> Unit,
    modifier: Modifier = Modifier,
) {
    composable(Home.route) {
        HomeScreen(
            onSettingsClick = onSettingsClick,
            onScreenClick = onScreenClick,
            modifier = modifier,
        )
    }
}

@Composable
private fun HomeScreen(
    onSettingsClick: () -> Unit,
    onScreenClick: (destination: Destination) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavScreen(
        title = Home.title,
        destinations = topDestinations,
        onScreenClick = onScreenClick,
        modifier = modifier,
        actions = {
            IconButton(
                onClick = onSettingsClick,
            ) {
                Icon(
                    painter = painterResource(R.drawable.palette),
                    contentDescription = "Settings",
                )
            }
        },
    )
}
