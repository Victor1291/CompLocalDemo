package com.shu.complocaldemo.doc_compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import com.shu.complocaldemo.CodeSample.colorFun

object AlertDemo {

    val alertDialog = """
        <a href="https:// m3.material. io/ components/ dialogs/ overview" class="external" target="_blank">Material Design basic dialog.
        Dialogs provide important prompts in a user flow. They can require an action, communicate information, or help users accomplish a task.
        ![Basic dialog
        image](https:// developer. android. com/ images/ reference/ androidx/ compose/ material3/ basic-dialog. png)
        The dialog will position its buttons, typically TextButtons, based on the available space. By default it will try to place them horizontally next to each other and fallback to horizontal placement if not enough space is available.
        Simple usage:
        Params:
        onDismissRequest - called when the user tries to dismiss the Dialog by clicking outside or pressing the back button. This is not called when the dismiss button is clicked.
        confirmButton - button which is meant to confirm a proposed action, thus resolving what triggered the dialog. The dialog does not set up any events for this button so they need to be set up by the caller.
        modifier - the Modifier to be applied to this dialog
        dismissButton - button which is meant to dismiss the dialog. The dialog does not set up any events for this button so they need to be set up by the caller.
        icon - optional icon that will appear above the title or above the text, in case a title was not provided.
        title - title which should specify the purpose of the dialog. The title is not mandatory, because there may be sufficient information inside the text.
        text - text which presents the details regarding the dialog's purpose.
        shape - defines the shape of this dialog's container
        containerColor - the color used for the background of this dialog. Use Color. Transparent to have no color.
        iconContentColor - the content color used for the icon.
        titleContentColor - the content color used for the title.
        textContentColor - the content color used for the text.
        tonalElevation - when containerColor is ColorScheme. surface, a translucent primary color overlay is applied on top of the container. A higher tonal elevation value will result in a darker color in light theme and lighter color in dark theme. See also: Surface.
        properties - typically platform specific properties to further configure the dialog.
        
        
        @Composable
        expect fun AlertDialog(
            onDismissRequest: () -> Unit,
            confirmButton: @Composable () -> Unit,
            modifier: Modifier = Modifier,
            dismissButton: @Composable (() -> Unit)? = null,
            icon: @Composable (() -> Unit)? = null,
            title: @Composable (() -> Unit)? = null,
            text: @Composable (() -> Unit)? = null,
            shape: Shape = AlertDialogDefaults.shape,
            containerColor: Color = AlertDialogDefaults.containerColor,
            iconContentColor: Color = AlertDialogDefaults.iconContentColor,
            titleContentColor: Color = AlertDialogDefaults.titleContentColor,
            textContentColor: Color = AlertDialogDefaults.textContentColor,
            tonalElevation: Dp = AlertDialogDefaults.TonalElevation,
            properties: DialogProperties = DialogProperties()
        )
        
        
    """.trimIndent()

    val alertDialogSample = "\n" + """
        @Composable
        fun AlertDialogSample() {
            val openDialog = remember { mutableStateOf(true) }
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back             
                        // button. If you want to disable that functionality, simply use an empty             
                        // onDismissRequest.      
                        openDialog.value = false
                    },
                    title = { Text(text = "Title") },
                    text = { Text(text = "Turned on by default") },
                    confirmButton = {
                        TextButton(onClick = { openDialog.value = false }) {
                            Text("Confirm")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { openDialog.value = false }) { Text("Dismiss") }
                    })
            }
        }
    """.trimIndent()

    val alertDialogWithIconSample = """
        @Composable
        fun AlertDialogWithIconSample() {
            val openDialog = remember { mutableStateOf(true) }

            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back             
                        // button. If you want to disable that functionality, simply use an empty             
                        // onDismissRequest.
                        openDialog.value = false
                    },
                    icon = {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    },
                    title = { Text(text = "Title") },
                    text = {
                        Text(
                            "This area typically contains the supportive text " +
                                    "which presents the details regarding the Dialog's purpose."
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = { openDialog.value = false }) {
                            Text("Confirm")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { openDialog.value = false }
                        ) {
                            Text("Dismiss")
                        }
                    }
                )
            }
        }
    """.trimIndent()

    val basicAlertDialog = """
        
        <a href="https:// m3.material. io/ components/ dialogs/ overview" class="external" target="_blank">Basic alert dialog dialog.
        Dialogs provide important prompts in a user flow. They can require an action, communicate information, or help users accomplish a task.
        ![Basic dialog
        image](https://developer.android.com/images/reference/androidx/compose/material3/basic-dialog.png)
        This basic alert dialog expects an arbitrary content that is defined by the caller. Note that your content will need to define its own styling.
        By default, the displayed dialog has the minimum height and width that the Material Design spec defines. If required, these constraints can be overwritten by providing a width or height Modifiers.
        Basic alert dialog usage with custom content:
        Params:
        onDismissRequest - called when the user tries to dismiss the Dialog by clicking outside or pressing the back button. This is not called when the dismiss button is clicked.
        modifier - the Modifier to be applied to this dialog's content.
        properties - typically platform specific properties to further configure the dialog.
        content - the content of the dialog
        Samples:
        androidx. compose. material3.samples. BasicAlertDialogSample
        
        @ExperimentalMaterial3Api
        @Composable
        fun BasicAlertDialog(
            onDismissRequest: () -> Unit,
            modifier: Modifier = Modifier,
            properties: DialogProperties = DialogProperties(),
            content: @Composable () -> Unit
        ) {
            Dialog(
                onDismissRequest = onDismissRequest,
                properties = properties,
            ) {
                val dialogPaneDescription = getString(Strings.Dialog)
                Box(
                    modifier =
                        modifier
                            .sizeIn(minWidth = DialogMinWidth, maxWidth = DialogMaxWidth)
                            .then(Modifier.semantics { paneTitle = dialogPaneDescription }),
                    propagateMinConstraints = true
                ) {
                    content()
                }
            }
        }
        
        @Deprecated(
            "Use BasicAlertDialog instead",
            replaceWith = ReplaceWith("BasicAlertDialog(onDismissRequest, modifier, properties, content)")
        )
        @ExperimentalMaterial3Api
        @Composable
        fun AlertDialog(
            onDismissRequest: () -> Unit,
            modifier: Modifier = Modifier,
            properties: DialogProperties = DialogProperties(),
            content: @Composable () -> Unit
        ) = BasicAlertDialog(onDismissRequest, modifier, properties, content)
        
    """.trimIndent()

    private val basicAlertDialogSample = """
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun BasicAlertDialogSample() {
            val openDialog = remember { mutableStateOf(true) }

            if (openDialog.value) {
                BasicAlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back             
                        // button. If you want to disable that functionality, simply use an empty             
                        // onDismissRequest.
                        openDialog.value = false
                    },
                ) {
                    Surface(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight(),
                        shape = MaterialTheme.shapes.large,
                        tonalElevation = AlertDialogDefaults.TonalElevation
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "This area typically contains the supportive text " +
                                        "which presents the details regarding the Dialog's purpose.",
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                            TextButton(
                                onClick = { openDialog.value = false },
                                modifier = Modifier.align(Alignment.End)
                            ) {
                                Text("Confirm")
                            }
                        }
                    }
                }
            }
        }
    """.trimIndent()

    val alertDialogDefaults = """
        /** Contains default values used for [AlertDialog] and [BasicAlertDialog]. */
        object AlertDialogDefaults {
            /** The default shape for alert dialogs */
            val shape: Shape
                @Composable get() = DialogTokens.ContainerShape.value

            /** The default container color for alert dialogs */
            val containerColor: Color
                @Composable get() = DialogTokens.ContainerColor.value

            /** The default icon color for alert dialogs */
            val iconContentColor: Color
                @Composable get() = DialogTokens.IconColor.value

            /** The default title color for alert dialogs */
            val titleContentColor: Color
                @Composable get() = DialogTokens.HeadlineColor.value

            /** The default text color for alert dialogs */
            val textContentColor: Color
                @Composable get() = DialogTokens.SupportingTextColor.value

            /** The default tonal elevation for alert dialogs */
            val TonalElevation: Dp = 0.dp
        }
    """.trimIndent()

    val alertDialogImpl = """
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        internal fun AlertDialogImpl(
            onDismissRequest: () -> Unit,
            confirmButton: @Composable () -> Unit,
            modifier: Modifier,
            dismissButton: @Composable (() -> Unit)?,
            icon: @Composable (() -> Unit)?,
            title: @Composable (() -> Unit)?,
            text: @Composable (() -> Unit)?,
            shape: Shape,
            containerColor: Color,
            iconContentColor: Color,
            titleContentColor: Color,
            textContentColor: Color,
            tonalElevation: Dp,
            properties: DialogProperties
        ): Unit =
            BasicAlertDialog(
                onDismissRequest = onDismissRequest,
                modifier = modifier,
                properties = properties
            ) {
                AlertDialogContent(
                    buttons = {
                        AlertDialogFlowRow(
                            mainAxisSpacing = ButtonsMainAxisSpacing,
                            crossAxisSpacing = ButtonsCrossAxisSpacing
                        ) {
                            dismissButton?.invoke()
                            confirmButton()
                        }
                    },
                    icon = icon,
                    title = title,
                    text = text,
                    shape = shape,
                    containerColor = containerColor,
                    tonalElevation = tonalElevation,
                    // Note that a button content color is provided here from the dialog's token, but in
                    // most cases, TextButtons should be used for dismiss and confirm buttons.
                    // TextButtons will not consume this provided content color value, and will used their
                    // own defined or default colors.
                    buttonContentColor = DialogTokens.ActionLabelTextColor.value,
                    iconContentColor = iconContentColor,
                    titleContentColor = titleContentColor,
                    textContentColor = textContentColor,
                )
            }

        @Composable
        internal fun AlertDialogContent(
            buttons: @Composable () -> Unit,
            modifier: Modifier = Modifier,
            icon: (@Composable () -> Unit)?,
            title: (@Composable () -> Unit)?,
            text: @Composable (() -> Unit)?,
            shape: Shape,
            containerColor: Color,
            tonalElevation: Dp,
            buttonContentColor: Color,
            iconContentColor: Color,
            titleContentColor: Color,
            textContentColor: Color,
        ) {
            Surface(
                modifier = modifier,
                shape = shape,
                color = containerColor,
                tonalElevation = tonalElevation,
            ) {
                Column(modifier = Modifier.padding(DialogPadding)) {
                    icon?.let {
                        CompositionLocalProvider(LocalContentColor provides iconContentColor) {
                            Box(Modifier.padding(IconPadding).align(Alignment.CenterHorizontally)) {
                                icon()
                            }
                        }
                    }
                    title?.let {
                        ProvideContentColorTextStyle(
                            contentColor = titleContentColor,
                            textStyle = DialogTokens.HeadlineFont.value
                        ) {
                            Box(
                                // Align the title to the center when an icon is present.
                                Modifier.padding(TitlePadding)
                                    .align(
                                        if (icon == null) {
                                            Alignment.Start
                                        } else {
                                            Alignment.CenterHorizontally
                                        }
                                    )
                            ) {
                                title()
                            }
                        }
                    }
                    text?.let {
                        val textStyle = DialogTokens.SupportingTextFont.value
                        ProvideContentColorTextStyle(
                            contentColor = textContentColor,
                            textStyle = textStyle
                        ) {
                            Box(
                                Modifier.weight(weight = 1f, fill = false)
                                    .padding(TextPadding)
                                    .align(Alignment.Start)
                            ) {
                                text()
                            }
                        }
                    }
                    Box(modifier = Modifier.align(Alignment.End)) {
                        val textStyle = DialogTokens.ActionLabelTextFont.value
                        ProvideContentColorTextStyle(
                            contentColor = buttonContentColor,
                            textStyle = textStyle,
                            content = buttons
                        )
                    }
                }
            }
        }
    """.trimIndent()

    val actualAlertDialog = """
        @Composable
actual fun AlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier,
    dismissButton: @Composable (() -> Unit)?,
    icon: @Composable (() -> Unit)?,
    title: @Composable (() -> Unit)?,
    text: @Composable (() -> Unit)?,
    shape: Shape,
    containerColor: Color,
    iconContentColor: Color,
    titleContentColor: Color,
    textContentColor: Color,
    tonalElevation: Dp,
    properties: DialogProperties
): Unit =
    AlertDialogImpl(
        onDismissRequest = onDismissRequest,
        confirmButton = confirmButton,
        modifier = modifier,
        dismissButton = dismissButton,
        icon = icon,
        title = title,
        text = text,
        shape = shape,
        containerColor = containerColor,
        iconContentColor = iconContentColor,
        titleContentColor = titleContentColor,
        textContentColor = textContentColor,
        tonalElevation = tonalElevation,
        properties = properties
    )
    """.trimIndent()

    private val alertDialogFlowRow = """
        
        /**
         * Simple clone of FlowRow that arranges its children in a horizontal flow with limited
         * customization.
         */
        @Composable
        internal fun AlertDialogFlowRow(
            mainAxisSpacing: Dp,
            crossAxisSpacing: Dp,
            content: @Composable () -> Unit
        ) {
            Layout(content) { measurables, constraints ->
                val sequences = mutableListOf<List<Placeable>>()
                val crossAxisSizes = mutableListOf<Int>()
                val crossAxisPositions = mutableListOf<Int>()

                var mainAxisSpace = 0
                var crossAxisSpace = 0

                val currentSequence = mutableListOf<Placeable>()
                var currentMainAxisSize = 0
                var currentCrossAxisSize = 0

                // Return whether the placeable can be added to the current sequence.
                fun canAddToCurrentSequence(placeable: Placeable) =
                    currentSequence.isEmpty() ||
                        currentMainAxisSize + mainAxisSpacing.roundToPx() + placeable.width <=
                            constraints.maxWidth

                // Store current sequence information and start a new sequence.
                fun startNewSequence() {
                    if (sequences.isNotEmpty()) {
                        crossAxisSpace += crossAxisSpacing.roundToPx()
                    }
                    // Ensures that confirming actions appear above dismissive actions.
                    @Suppress("ListIterator") sequences.add(0, currentSequence.toList())
                    crossAxisSizes += currentCrossAxisSize
                    crossAxisPositions += crossAxisSpace

                    crossAxisSpace += currentCrossAxisSize
                    mainAxisSpace = max(mainAxisSpace, currentMainAxisSize)

                    currentSequence.clear()
                    currentMainAxisSize = 0
                    currentCrossAxisSize = 0
                }

                measurables.fastForEach { measurable ->
                    // Ask the child for its preferred size.
                    val placeable = measurable.measure(constraints)

                    // Start a new sequence if there is not enough space.
                    if (!canAddToCurrentSequence(placeable)) startNewSequence()

                    // Add the child to the current sequence.
                    if (currentSequence.isNotEmpty()) {
                        currentMainAxisSize += mainAxisSpacing.roundToPx()
                    }
                    currentSequence.add(placeable)
                    currentMainAxisSize += placeable.width
                    currentCrossAxisSize = max(currentCrossAxisSize, placeable.height)
                }

                if (currentSequence.isNotEmpty()) startNewSequence()

                val mainAxisLayoutSize = max(mainAxisSpace, constraints.minWidth)

                val crossAxisLayoutSize = max(crossAxisSpace, constraints.minHeight)

                val layoutWidth = mainAxisLayoutSize

                val layoutHeight = crossAxisLayoutSize

                layout(layoutWidth, layoutHeight) {
                    sequences.fastForEachIndexed { i, placeables ->
                        val childrenMainAxisSizes =
                            IntArray(placeables.size) { j ->
                                placeables[j].width +
                                    if (j < placeables.lastIndex) mainAxisSpacing.roundToPx() else 0
                            }
                        val arrangement = Arrangement.End
                        val mainAxisPositions = IntArray(childrenMainAxisSizes.size) { 0 }
                        with(arrangement) {
                            arrange(
                                mainAxisLayoutSize,
                                childrenMainAxisSizes,
                                layoutDirection,
                                mainAxisPositions
                            )
                        }
                        placeables.fastForEachIndexed { j, placeable ->
                            placeable.place(x = mainAxisPositions[j], y = crossAxisPositions[i])
                        }
                    }
                }
            }
        }

        internal val DialogMinWidth = 280.dp
        internal val DialogMaxWidth = 560.dp

        private val ButtonsMainAxisSpacing = 8.dp
        private val ButtonsCrossAxisSpacing = 12.dp

        // Paddings for each of the dialog's parts.
        private val DialogPadding = PaddingValues(all = 24.dp)
        private val IconPadding = PaddingValues(bottom = 16.dp)
        private val TitlePadding = PaddingValues(bottom = 16.dp)
        private val TextPadding = PaddingValues(bottom = 24.dp)
    """.trimIndent()

    @Composable
    fun choiceText(
        slot: AlertTexts,
        isShowDialogClick: (Boolean, String) -> Unit
    ): AnnotatedString {
        return when (slot) {
            AlertTexts.AlertDialogSample -> colorFun(
                text = alertDialogSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            AlertTexts.AlertDialogWithIconSample -> colorFun(
                text = alertDialogWithIconSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            AlertTexts.BasicAlertDialogSample -> colorFun(
                text = basicAlertDialogSample,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })

            AlertTexts.AlertDialogFlowRowDemo -> colorFun(
                text = alertDialogFlowRow,
                isShowDialogClick = { isShow, textNew ->
                    isShowDialogClick(isShow, textNew)
                })
        }
    }
}

enum class AlertTexts {
    AlertDialogSample, AlertDialogWithIconSample, BasicAlertDialogSample, AlertDialogFlowRowDemo
}