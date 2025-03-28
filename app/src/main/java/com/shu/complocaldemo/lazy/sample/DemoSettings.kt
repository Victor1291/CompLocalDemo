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
package com.shu.complocaldemo.lazy.sample

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.ui.unit.LayoutDirection

@Immutable
data class DemoSettings(
    val theme: Theme = Theme.AUTO,
    val layoutDirection: LayoutDirection? = null,
    val isVertical: Boolean = true,
    val isInfinite: Boolean = true,
) {
    companion object {
        /**
         * The default [Saver] implementation for [DemoSettings].
         */
        val Saver = run {
            val themeKey = "theme"
            val layoutDirKey = "layoutDir"
            val isVerticalKey = "isVertical"
            val isInfiniteKey = "isInfinite"

            mapSaver(
                save = {
                    mapOf(
                        themeKey to it.theme.ordinal,
                        layoutDirKey to it.layoutDirection?.ordinal,
                        isVerticalKey to it.isVertical,
                        isInfiniteKey to it.isInfinite,
                    )
                },
                restore = {
                    DemoSettings(
                        theme = (it[themeKey] as Int).let { ordinal ->
                            Theme.entries[ordinal]
                        },
                        layoutDirection = (it[layoutDirKey] as? Int)?.let { ordinal ->
                            LayoutDirection.entries[ordinal]
                        },
                        isVertical = it[isVerticalKey] as Boolean,
                        isInfinite = it[isInfiniteKey] as Boolean,
                    )
                },
            )
        }
    }
}

enum class Theme(val text: String) {
    AUTO("System"),
    LIGHT("Light"),
    DARK("Dark"),
}
