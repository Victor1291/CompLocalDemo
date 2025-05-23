package com.shu.complocaldemo.doc_compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import com.shu.complocaldemo.CodeSample.colorFun

object ListItemDemo {

    private val listItem = """
    <a href="https:// m3.material. io/ components/ lists/ overview" class="external" target="_blank">Material Design list item.
    Lists are continuous, vertical indexes of text or images.
    ![Lists
    image](https:// developer. android. com/ images/ reference/ androidx/ compose/ material3/ lists. png)
    This component can be used to achieve the list item templates existing in the spec. One-line list items have a singular line of headline content. Two-line list items additionally have either supporting or overline content. Three-line list items have either both supporting and overline content, or extended (two-line) supporting text. For example:
    one-line item
    Params:
    headlineContent - the headline content of the list item
    modifier - Modifier to be applied to the list item
    overlineContent - the content displayed above the headline content
    supportingContent - the supporting content of the list item
    leadingContent - the leading content of the list item
    trailingContent - the trailing meta text, icon, switch or checkbox
    colors - ListItemColors that will be used to resolve the background and content color for this list item in different states. See ListItemDefaults. colors
    tonalElevation - the tonal elevation of this list item
    shadowElevation - the shadow elevation of this list item
    Samples:
    androidx. compose. material3.samples. OneLineListItem
""".trimIndent()

    const val urlList = "https://m3.material.io/components/lists/overview"

    private val oneLineListItem = """
        @Composable
fun OneLineListItem() {
    Column {
        ListItem(
            headlineContent = { Text("One line list item with 24x24 icon") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }
        )
        HorizontalDivider()
    }
}
    """.trimIndent()

    private val twoLineListItem = """
       @Composable
fun TwoLineListItem() {
    Column {
        ListItem(
            headlineContent = { Text("Two line list item with trailing") },
            supportingContent = { Text("Secondary text") },
            trailingContent = { Text("meta") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }
        )
        HorizontalDivider()
    }
}
    """.trimIndent()

    private val threeLineListItemWithOverlineAndSupporting = """
        @Composable
        fun ThreeLineListItemWithOverlineAndSupporting() {
            Column {
                ListItem(
                    headlineContent = { Text("Three line list item") },
                    overlineContent = { Text("OVERLINE") },
                    supportingContent = { Text("Secondary text") },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    },
                    trailingContent = { Text("meta") }
                )
                HorizontalDivider()
            }
        }
    """.trimIndent()

    private val threeLineListItemWithExtendedSupporting = """
        @Composable
        fun ThreeLineListItemWithExtendedSupporting() {
            Column {
                ListItem(
                    headlineContent = { Text("Three line list item") },
                    supportingContent = {
                        Text("Secondary text that is long and perhaps goes onto another line")
                    },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    },
                    trailingContent = { Text("meta") }
                )
                HorizontalDivider()
            }
        }
    """.trimIndent()

    val listItemCode = """
        @Composable
        fun ListItem(
            headlineContent: @Composable () -> Unit,
            modifier: Modifier = Modifier,
            overlineContent: @Composable (() -> Unit)? = null,
            supportingContent: @Composable (() -> Unit)? = null,
            leadingContent: @Composable (() -> Unit)? = null,
            trailingContent: @Composable (() -> Unit)? = null,
            colors: ListItemColors = ListItemDefaults.colors(),
            tonalElevation: Dp = ListItemDefaults.Elevation,
            shadowElevation: Dp = ListItemDefaults.Elevation,
        ) {
            val decoratedHeadlineContent: @Composable () -> Unit = {
                ProvideTextStyleFromToken(
                    colors.headlineColor(enabled = true),
                    ListTokens.ListItemLabelTextFont,
                    headlineContent
                )
            }
            val decoratedSupportingContent: @Composable (() -> Unit)? =
                supportingContent?.let {
                    {
                        ProvideTextStyleFromToken(
                            colors.supportingColor(),
                            ListTokens.ListItemSupportingTextFont,
                            it
                        )
                    }
                }
            val decoratedOverlineContent: @Composable (() -> Unit)? =
                overlineContent?.let {
                    {
                        ProvideTextStyleFromToken(
                            colors.overlineColor(),
                            ListTokens.ListItemOverlineFont,
                            it
                        )
                    }
                }
            val decoratedLeadingContent: @Composable (() -> Unit)? =
                leadingContent?.let {
                    {
                        Box(Modifier.padding(end = LeadingContentEndPadding)) {
                            CompositionLocalProvider(
                                LocalContentColor provides colors.leadingIconColor(enabled = true),
                                content = it
                            )
                        }
                    }
                }
            val decoratedTrailingContent: @Composable (() -> Unit)? =
                trailingContent?.let {
                    {
                        Box(Modifier.padding(start = TrailingContentStartPadding)) {
                            ProvideTextStyleFromToken(
                                colors.trailingIconColor(enabled = true),
                                ListTokens.ListItemTrailingSupportingTextFont,
                                content = it
                            )
                        }
                    }
                }

            Surface(
                modifier = Modifier.semantics(mergeDescendants = true) {}.then(modifier),
                shape = ListItemDefaults.shape,
                color = colors.containerColor(),
                contentColor = colors.headlineColor(enabled = true),
                tonalElevation = tonalElevation,
                shadowElevation = shadowElevation,
            ) {
                ListItemLayout(
                    headline = decoratedHeadlineContent,
                    overline = decoratedOverlineContent,
                    supporting = decoratedSupportingContent,
                    leading = decoratedLeadingContent,
                    trailing = decoratedTrailingContent,
                )
            }
        }
    """.trimIndent()

    val listItemLayout = """
        @Composable
        private fun ListItemLayout(
            leading: @Composable (() -> Unit)?,
            trailing: @Composable (() -> Unit)?,
            headline: @Composable () -> Unit,
            overline: @Composable (() -> Unit)?,
            supporting: @Composable (() -> Unit)?,
        ) {
            val measurePolicy = remember { ListItemMeasurePolicy() }
            Layout(
                contents =
                    listOf(
                        headline,
                        overline ?: {},
                        supporting ?: {},
                        leading ?: {},
                        trailing ?: {},
                    ),
                measurePolicy = measurePolicy,
            )
        }
    """.trimIndent()

    val listItemMeasurePolicy = """
        private class ListItemMeasurePolicy : MultiContentMeasurePolicy {
    override fun MeasureScope.measure(
        measurables: List<List<Measurable>>,
        constraints: Constraints
    ): MeasureResult {
        val (
            headlineMeasurable,
            overlineMeasurable,
            supportingMeasurable,
            leadingMeasurable,
            trailingMeasurable) =
            measurables
        var currentTotalWidth = 0

        val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)
        val startPadding = ListItemStartPadding
        val endPadding = ListItemEndPadding
        val horizontalPadding = (startPadding + endPadding).roundToPx()

        // ListItem layout has a cycle in its dependencies which we use
        // intrinsic measurements to break:
        // 1. Intrinsic leading/trailing width
        // 2. Intrinsic supporting height
        // 3. Intrinsic vertical padding
        // 4. Actual leading/trailing measurement
        // 5. Actual supporting measurement
        // 6. Actual vertical padding
        val intrinsicLeadingWidth =
            leadingMeasurable.firstOrNull()?.minIntrinsicWidth(constraints.maxHeight) ?: 0
        val intrinsicTrailingWidth =
            trailingMeasurable.firstOrNull()?.minIntrinsicWidth(constraints.maxHeight) ?: 0
        val intrinsicSupportingWidthConstraint =
            looseConstraints.maxWidth.subtractConstraintSafely(
                intrinsicLeadingWidth + intrinsicTrailingWidth + horizontalPadding
            )
        val intrinsicSupportingHeight =
            supportingMeasurable
                .firstOrNull()
                ?.minIntrinsicHeight(intrinsicSupportingWidthConstraint) ?: 0
        val intrinsicIsSupportingMultiline =
            isSupportingMultilineHeuristic(intrinsicSupportingHeight)
        val intrinsicListItemType =
            ListItemType(
                hasOverline = overlineMeasurable.firstOrNull() != null,
                hasSupporting = supportingMeasurable.firstOrNull() != null,
                isSupportingMultiline = intrinsicIsSupportingMultiline,
            )
        val intrinsicVerticalPadding = (verticalPadding(intrinsicListItemType) * 2).roundToPx()

        val paddedLooseConstraints =
            looseConstraints.offset(
                horizontal = -horizontalPadding,
                vertical = -intrinsicVerticalPadding,
            )

        val leadingPlaceable = leadingMeasurable.firstOrNull()?.measure(paddedLooseConstraints)
        currentTotalWidth += widthOrZero(leadingPlaceable)

        val trailingPlaceable =
            trailingMeasurable
                .firstOrNull()
                ?.measure(paddedLooseConstraints.offset(horizontal = -currentTotalWidth))
        currentTotalWidth += widthOrZero(trailingPlaceable)

        var currentTotalHeight = 0

        val headlinePlaceable =
            headlineMeasurable
                .firstOrNull()
                ?.measure(paddedLooseConstraints.offset(horizontal = -currentTotalWidth))
        currentTotalHeight += heightOrZero(headlinePlaceable)

        val supportingPlaceable =
            supportingMeasurable
                .firstOrNull()
                ?.measure(
                    paddedLooseConstraints.offset(
                        horizontal = -currentTotalWidth,
                        vertical = -currentTotalHeight
                    )
                )
        currentTotalHeight += heightOrZero(supportingPlaceable)
        val isSupportingMultiline =
            supportingPlaceable != null &&
                (supportingPlaceable[FirstBaseline] != supportingPlaceable[LastBaseline])

        val overlinePlaceable =
            overlineMeasurable
                .firstOrNull()
                ?.measure(
                    paddedLooseConstraints.offset(
                        horizontal = -currentTotalWidth,
                        vertical = -currentTotalHeight
                    )
                )

        val listItemType =
            ListItemType(
                hasOverline = overlinePlaceable != null,
                hasSupporting = supportingPlaceable != null,
                isSupportingMultiline = isSupportingMultiline,
            )
        val topPadding = verticalPadding(listItemType)
        val verticalPadding = topPadding * 2

        val width =
            calculateWidth(
                leadingWidth = widthOrZero(leadingPlaceable),
                trailingWidth = widthOrZero(trailingPlaceable),
                headlineWidth = widthOrZero(headlinePlaceable),
                overlineWidth = widthOrZero(overlinePlaceable),
                supportingWidth = widthOrZero(supportingPlaceable),
                horizontalPadding = horizontalPadding,
                constraints = constraints,
            )
        val height =
            calculateHeight(
                leadingHeight = heightOrZero(leadingPlaceable),
                trailingHeight = heightOrZero(trailingPlaceable),
                headlineHeight = heightOrZero(headlinePlaceable),
                overlineHeight = heightOrZero(overlinePlaceable),
                supportingHeight = heightOrZero(supportingPlaceable),
                listItemType = listItemType,
                verticalPadding = verticalPadding.roundToPx(),
                constraints = constraints,
            )

        return place(
            width = width,
            height = height,
            leadingPlaceable = leadingPlaceable,
            trailingPlaceable = trailingPlaceable,
            headlinePlaceable = headlinePlaceable,
            overlinePlaceable = overlinePlaceable,
            supportingPlaceable = supportingPlaceable,
            isThreeLine = listItemType == ListItemType.ThreeLine,
            startPadding = startPadding.roundToPx(),
            endPadding = endPadding.roundToPx(),
            topPadding = topPadding.roundToPx(),
        )
    }

    override fun IntrinsicMeasureScope.maxIntrinsicHeight(
        measurables: List<List<IntrinsicMeasurable>>,
        width: Int
    ): Int = calculateIntrinsicHeight(measurables, width, IntrinsicMeasurable::maxIntrinsicHeight)

    override fun IntrinsicMeasureScope.maxIntrinsicWidth(
        measurables: List<List<IntrinsicMeasurable>>,
        height: Int
    ): Int = calculateIntrinsicWidth(measurables, height, IntrinsicMeasurable::maxIntrinsicWidth)

    override fun IntrinsicMeasureScope.minIntrinsicHeight(
        measurables: List<List<IntrinsicMeasurable>>,
        width: Int
    ): Int = calculateIntrinsicHeight(measurables, width, IntrinsicMeasurable::minIntrinsicHeight)

    override fun IntrinsicMeasureScope.minIntrinsicWidth(
        measurables: List<List<IntrinsicMeasurable>>,
        height: Int
    ): Int = calculateIntrinsicWidth(measurables, height, IntrinsicMeasurable::minIntrinsicWidth)

    private fun IntrinsicMeasureScope.calculateIntrinsicWidth(
        measurables: List<List<IntrinsicMeasurable>>,
        height: Int,
        intrinsicMeasure: IntrinsicMeasurable.(height: Int) -> Int,
    ): Int {
        val (
            headlineMeasurable,
            overlineMeasurable,
            supportingMeasurable,
            leadingMeasurable,
            trailingMeasurable) =
            measurables
        return calculateWidth(
            leadingWidth = leadingMeasurable.firstOrNull()?.intrinsicMeasure(height) ?: 0,
            trailingWidth = trailingMeasurable.firstOrNull()?.intrinsicMeasure(height) ?: 0,
            headlineWidth = headlineMeasurable.firstOrNull()?.intrinsicMeasure(height) ?: 0,
            overlineWidth = overlineMeasurable.firstOrNull()?.intrinsicMeasure(height) ?: 0,
            supportingWidth = supportingMeasurable.firstOrNull()?.intrinsicMeasure(height) ?: 0,
            horizontalPadding = (ListItemStartPadding + ListItemEndPadding).roundToPx(),
            constraints = Constraints(),
        )
    }
    
    
        private fun IntrinsicMeasureScope.calculateIntrinsicHeight(
            measurables: List<List<IntrinsicMeasurable>>,
            width: Int,
            intrinsicMeasure: IntrinsicMeasurable.(width: Int) -> Int,
        ): Int {
            val (
                headlineMeasurable,
                overlineMeasurable,
                supportingMeasurable,
                leadingMeasurable,
                trailingMeasurable) =
                measurables

            var remainingWidth =
                width.subtractConstraintSafely((ListItemStartPadding + ListItemEndPadding).roundToPx())
            val leadingHeight =
                leadingMeasurable.firstOrNull()?.let {
                    val height = it.intrinsicMeasure(remainingWidth)
                    remainingWidth =
                        remainingWidth.subtractConstraintSafely(
                            it.maxIntrinsicWidth(Constraints.Infinity)
                        )
                    height
                } ?: 0
            val trailingHeight =
                trailingMeasurable.firstOrNull()?.let {
                    val height = it.intrinsicMeasure(remainingWidth)
                    remainingWidth =
                        remainingWidth.subtractConstraintSafely(
                            it.maxIntrinsicWidth(Constraints.Infinity)
                        )
                    height
                } ?: 0
            val overlineHeight = overlineMeasurable.firstOrNull()?.intrinsicMeasure(remainingWidth) ?: 0
            val supportingHeight =
                supportingMeasurable.firstOrNull()?.intrinsicMeasure(remainingWidth) ?: 0
            val isSupportingMultiline = isSupportingMultilineHeuristic(supportingHeight)
            val listItemType =
                ListItemType(
                    hasOverline = overlineHeight > 0,
                    hasSupporting = supportingHeight > 0,
                    isSupportingMultiline = isSupportingMultiline,
                )

            return calculateHeight(
                leadingHeight = leadingHeight,
                trailingHeight = trailingHeight,
                headlineHeight = headlineMeasurable.firstOrNull()?.intrinsicMeasure(width) ?: 0,
                overlineHeight = overlineHeight,
                supportingHeight = supportingHeight,
                listItemType = listItemType,
                verticalPadding = (verticalPadding(listItemType) * 2).roundToPx(),
                constraints = Constraints(),
            )
        }
    }
    private fun IntrinsicMeasureScope.calculateWidth(
        leadingWidth: Int,
        trailingWidth: Int,
        headlineWidth: Int,
        overlineWidth: Int,
        supportingWidth: Int,
        horizontalPadding: Int,
        constraints: Constraints,
    ): Int {
        if (constraints.hasBoundedWidth) {
            return constraints.maxWidth
        }
        // Fallback behavior if width constraints are infinite
        val mainContentWidth = maxOf(headlineWidth, overlineWidth, supportingWidth)
        return horizontalPadding + leadingWidth + mainContentWidth + trailingWidth
    }

    private fun IntrinsicMeasureScope.calculateHeight(
        leadingHeight: Int,
        trailingHeight: Int,
        headlineHeight: Int,
        overlineHeight: Int,
        supportingHeight: Int,
        listItemType: ListItemType,
        verticalPadding: Int,
        constraints: Constraints,
    ): Int {
        val defaultMinHeight =
            when (listItemType) {
                ListItemType.OneLine -> ListTokens.ListItemOneLineContainerHeight
                ListItemType.TwoLine -> ListTokens.ListItemTwoLineContainerHeight
                else /* ListItemType.ThreeLine */ -> ListTokens.ListItemThreeLineContainerHeight
            }
        val minHeight = max(constraints.minHeight, defaultMinHeight.roundToPx())

        val mainContentHeight = headlineHeight + overlineHeight + supportingHeight

        return max(minHeight, verticalPadding + maxOf(leadingHeight, mainContentHeight, trailingHeight))
            .coerceAtMost(constraints.maxHeight)
    }

    private fun MeasureScope.place(
        width: Int,
        height: Int,
        leadingPlaceable: Placeable?,
        trailingPlaceable: Placeable?,
        headlinePlaceable: Placeable?,
        overlinePlaceable: Placeable?,
        supportingPlaceable: Placeable?,
        isThreeLine: Boolean,
        startPadding: Int,
        endPadding: Int,
        topPadding: Int,
    ): MeasureResult {
        return layout(width, height) {
            leadingPlaceable?.let {
                it.placeRelative(
                    x = startPadding,
                    y = if (isThreeLine) topPadding else CenterVertically.align(it.height, height)
                )
            }
            trailingPlaceable?.let {
                it.placeRelative(
                    x = width - endPadding - it.width,
                    y = if (isThreeLine) topPadding else CenterVertically.align(it.height, height)
                )
            }

            val mainContentX = startPadding + widthOrZero(leadingPlaceable)
            val mainContentY =
                if (isThreeLine) {
                    topPadding
                } else {
                    val totalHeight =
                        heightOrZero(headlinePlaceable) +
                            heightOrZero(overlinePlaceable) +
                            heightOrZero(supportingPlaceable)
                    CenterVertically.align(totalHeight, height)
                }
            var currentY = mainContentY

            overlinePlaceable?.placeRelative(mainContentX, currentY)
            currentY += heightOrZero(overlinePlaceable)

            headlinePlaceable?.placeRelative(mainContentX, currentY)
            currentY += heightOrZero(headlinePlaceable)

            supportingPlaceable?.placeRelative(mainContentX, currentY)
        }
    }
    """.trimIndent()

    val listItemDefaults = """
        /** Contains the default values used by list items. */
        object ListItemDefaults {
            /** The default elevation of a list item */
            val Elevation: Dp = ListTokens.ListItemContainerElevation

            /** The default shape of a list item */
            val shape: Shape
                @Composable @ReadOnlyComposable get() = ListTokens.ListItemContainerShape.value

            /** The container color of a list item */
            val containerColor: Color
                @Composable @ReadOnlyComposable get() = ListTokens.ListItemContainerColor.value

            /** The content color of a list item */
            val contentColor: Color
                @Composable @ReadOnlyComposable get() = ListTokens.ListItemLabelTextColor.value

            /**
             * Creates a [ListItemColors] that represents the default container and content colors used in a
             * [ListItem].
             *
             * @param containerColor the container color of this list item when enabled.
             * @param headlineColor the headline text content color of this list item when enabled.
             * @param leadingIconColor the color of this list item's leading content when enabled.
             * @param overlineColor the overline text color of this list item
             * @param supportingColor the supporting text color of this list item
             * @param trailingIconColor the color of this list item's trailing content when enabled.
             * @param disabledHeadlineColor the content color of this list item when not enabled.
             * @param disabledLeadingIconColor the color of this list item's leading content when not
             *   enabled.
             * @param disabledTrailingIconColor the color of this list item's trailing content when not
             *   enabled.
             */
            @Composable
            fun colors(
                containerColor: Color = ListTokens.ListItemContainerColor.value,
                headlineColor: Color = ListTokens.ListItemLabelTextColor.value,
                leadingIconColor: Color = ListTokens.ListItemLeadingIconColor.value,
                overlineColor: Color = ListTokens.ListItemOverlineColor.value,
                supportingColor: Color = ListTokens.ListItemSupportingTextColor.value,
                trailingIconColor: Color = ListTokens.ListItemTrailingIconColor.value,
                disabledHeadlineColor: Color =
                    ListTokens.ListItemDisabledLabelTextColor.value.copy(
                        alpha = ListTokens.ListItemDisabledLabelTextOpacity
                    ),
                disabledLeadingIconColor: Color =
                    ListTokens.ListItemDisabledLeadingIconColor.value.copy(
                        alpha = ListTokens.ListItemDisabledLeadingIconOpacity
                    ),
                disabledTrailingIconColor: Color =
                    ListTokens.ListItemDisabledTrailingIconColor.value.copy(
                        alpha = ListTokens.ListItemDisabledTrailingIconOpacity
                    )
            ): ListItemColors =
                ListItemColors(
                    containerColor = containerColor,
                    headlineColor = headlineColor,
                    leadingIconColor = leadingIconColor,
                    overlineColor = overlineColor,
                    supportingTextColor = supportingColor,
                    trailingIconColor = trailingIconColor,
                    disabledHeadlineColor = disabledHeadlineColor,
                    disabledLeadingIconColor = disabledLeadingIconColor,
                    disabledTrailingIconColor = disabledTrailingIconColor,
                )
        }

        /**
         * Represents the container and content colors used in a list item in different states.
         *
         * @param containerColor the container color of this list item when enabled.
         * @param headlineColor the headline text content color of this list item when enabled.
         * @param leadingIconColor the color of this list item's leading content when enabled.
         * @param overlineColor the overline text color of this list item
         * @param supportingTextColor the supporting text color of this list item
         * @param trailingIconColor the color of this list item's trailing content when enabled.
         * @param disabledHeadlineColor the content color of this list item when not enabled.
         * @param disabledLeadingIconColor the color of this list item's leading content when not enabled.
         * @param disabledTrailingIconColor the color of this list item's trailing content when not enabled.
         * @constructor create an instance with arbitrary colors. See [ListItemDefaults.colors] for the
         *   default colors used in a [ListItem].
         */
        @Immutable
        class ListItemColors
        constructor(
            val containerColor: Color,
            val headlineColor: Color,
            val leadingIconColor: Color,
            val overlineColor: Color,
            val supportingTextColor: Color,
            val trailingIconColor: Color,
            val disabledHeadlineColor: Color,
            val disabledLeadingIconColor: Color,
            val disabledTrailingIconColor: Color,
        ) {
            /** The container color of this [ListItem] based on enabled state */
            internal fun containerColor(): Color {
                return containerColor
            }

            /** The color of this [ListItem]'s headline text based on enabled state */
            @Stable
            internal fun headlineColor(enabled: Boolean): Color {
                return if (enabled) headlineColor else disabledHeadlineColor
            }

            /** The color of this [ListItem]'s leading content based on enabled state */
            @Stable
            internal fun leadingIconColor(enabled: Boolean): Color =
                if (enabled) leadingIconColor else disabledLeadingIconColor

            /** The color of this [ListItem]'s overline text based on enabled state */
            @Stable internal fun overlineColor(): Color = overlineColor

            /** The color of this [ListItem]'s supporting text based on enabled state */
            @Stable internal fun supportingColor(): Color = supportingTextColor

            /** The color of this [ListItem]'s trailing content based on enabled state */
            @Stable
            internal fun trailingIconColor(enabled: Boolean): Color =
                if (enabled) trailingIconColor else disabledTrailingIconColor
        }

        @Composable
        private fun ProvideTextStyleFromToken(
            color: Color,
            textToken: TypographyKeyTokens,
            content: @Composable () -> Unit,
        ) =
            ProvideContentColorTextStyle(
                contentColor = color,
                textStyle = textToken.value,
                content = content
            )

        /** Helper class to define list item type. Used for padding and sizing definition. */
        @JvmInline
        private value class ListItemType private constructor(private val lines: Int) :
            Comparable<ListItemType> {

            override operator fun compareTo(other: ListItemType) = lines.compareTo(other.lines)

            companion object {
                /** One line list item */
                val OneLine = ListItemType(1)

                /** Two line list item */
                val TwoLine = ListItemType(2)

                /** Three line list item */
                val ThreeLine = ListItemType(3)

                internal operator fun invoke(
                    hasOverline: Boolean,
                    hasSupporting: Boolean,
                    isSupportingMultiline: Boolean
                ): ListItemType {
                    return when {
                        (hasOverline && hasSupporting) || isSupportingMultiline -> ThreeLine
                        hasOverline || hasSupporting -> TwoLine
                        else -> OneLine
                    }
                }
            }
        }

        // Container related defaults
        // TODO: Make sure these values stay up to date until replaced with tokens.
        @VisibleForTesting internal val ListItemVerticalPadding = 8.dp

        @VisibleForTesting internal val ListItemThreeLineVerticalPadding = 12.dp

        @VisibleForTesting internal val ListItemStartPadding = 16.dp

        @VisibleForTesting internal val ListItemEndPadding = 16.dp

        // Icon related defaults.
        // TODO: Make sure these values stay up to date until replaced with tokens.
        @VisibleForTesting internal val LeadingContentEndPadding = 16.dp

        // Trailing related defaults.
        // TODO: Make sure these values stay up to date until replaced with tokens.
        @VisibleForTesting internal val TrailingContentStartPadding = 16.dp

        // In the actual layout phase, we can query supporting baselines,
        // but for an intrinsic measurement pass, we have to estimate.
        private fun Density.isSupportingMultilineHeuristic(estimatedSupportingHeight: Int): Boolean =
            estimatedSupportingHeight > 30.sp.roundToPx()

        private fun verticalPadding(listItemType: ListItemType): Dp =
            when (listItemType) {
                ListItemType.ThreeLine -> ListItemThreeLineVerticalPadding
                else -> ListItemVerticalPadding
            }

        private fun Int.subtractConstraintSafely(n: Int): Int {
            if (this == Constraints.Infinity) {
                return this
            }
            return this - n
        }

    """.trimIndent()

    val headerSticky = """
        @OptIn(ExperimentalFoundationApi::class)
        @Preview
        @Composable
        fun HeaderSticky() {
            val phones = listOf(
                "Apple iPhone 12", "Google Pixel 4", "Google Pixel 6",
                "Samsung Galaxy 6s", "Apple iPhone 7", "OnePlus 7", "OnePlus 9 Pro",
                "Apple iPhone 13", "Samsung Galaxy Z Flip", "Google Pixel 4a",
                "Apple iPhone 8"
            )

            val groupedPhones = phones.groupBy { it.substringBefore(' ') }
            LazyColumn {
                groupedPhones.forEach { (manufacturer, models) ->
                    stickyHeader {

                        Text(
                            text = manufacturer,
                            color = Color.White,
                            modifier = Modifier
                                .background(Color.Gray)
                                .padding(5.dp)
                                .fillMaxWidth()
                        )
                    }


                    items(models) { model ->
                        OneLineListItem(model)
                    }
                }
            }
        }
    """.trimIndent()


    @Composable
    fun choiceText(
        slot: ListTexts,
        isShowDialogClick: (Boolean, String) -> Unit
    ): AnnotatedString {
        return when (slot) {
            ListTexts.ListItem -> colorFun(
                text = listItem,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.UrlList -> colorFun(
                text = urlList,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.OneLineListItem -> colorFun(
                text = oneLineListItem,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.TwoLineListItem -> colorFun(
                text = twoLineListItem,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.ThreeLineListItemWithOverlineAndSupporting -> colorFun(
                text = threeLineListItemWithOverlineAndSupporting,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.ThreeLineListItemWithExtendedSupporting -> colorFun(
                text = threeLineListItemWithExtendedSupporting,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.ListItemCode -> colorFun(
                text = listItemCode,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.ListItemLayout -> colorFun(
                text = listItemLayout,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.ListItemMeasurePolicy -> colorFun(
                text = listItemMeasurePolicy,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            ListTexts.ListItemDefaults -> colorFun(
                text = listItemDefaults,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
            ListTexts.HeaderSticky -> colorFun(
                text = headerSticky ,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

        }
    }
}

enum class ListTexts {
    ListItem, UrlList, OneLineListItem, TwoLineListItem, ThreeLineListItemWithOverlineAndSupporting,
    ThreeLineListItemWithExtendedSupporting, ListItemCode, ListItemLayout, ListItemMeasurePolicy,
    ListItemDefaults, HeaderSticky
}