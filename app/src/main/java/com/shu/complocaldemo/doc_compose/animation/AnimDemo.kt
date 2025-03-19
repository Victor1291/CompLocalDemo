package com.shu.complocaldemo.doc_compose.animation

object AnimDemo {

    val ballScaleIndicator = """
        @Composable
        fun BallScaleIndicator() {
            // Creates the infinite transition
            val infiniteTransition = rememberInfiniteTransition()

            // Animate from 0f to 1f
            val animationProgress by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 800)
                )
            )

            Ball(
                modifier = Modifier
                    .scale(animationProgress)
                    .alpha(1 - animationProgress),
            )
        }
    """.trimIndent()

    val ballPulseSyncIndicator = """
        @Composable
        fun BallPulseSyncIndicator() {
            val animationValues = (1..3).map { index ->
                var animatedValue by remember { mutableStateOf(0f) }

                LaunchedEffect(key1 = Unit) {
                    // Delaying using Coroutines
                    delay(70L * index)

                    animate(
                        initialValue = 0f,
                        targetValue = 12f,
                        animationSpec = infiniteRepeatable(
                            // Remove delay property
                            animation = tween(durationMillis = 300),
                            repeatMode = RepeatMode.Reverse,
                        )
                    ) { value, _ -> animatedValue = value }
                }

                animatedValue
            }

            Row {
                animationValues.forEach { animatedValue ->
                    Ball(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .offset(y = animatedValue.dp),
                    )
                }
            }
        }
    """.trimIndent()

    val triangleSkewSpinIndicator = """
        
    """.trimIndent()

}