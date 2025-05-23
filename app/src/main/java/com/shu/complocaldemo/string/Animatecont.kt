package com.shu.complocaldemo.string

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.ui.tooling.preview.Preview
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme


@Composable
fun AnimateConst() {
    Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        var count by remember { mutableStateOf(0) }
// The `AnimatedContent` below uses an integer count as its target state. So when the
// count changes, it will animate out the content associated with the previous count, and
// animate in the content associated with the target state.
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                // We can define how the new target content comes in and how initial content
                // leaves in the ContentTransform. Here we want to create the impression that the
                // different numbers have a spatial relationship - larger numbers are
                // positioned (vertically) below smaller numbers.
                if (targetState > initialState) {
                    // If the incoming number is larger, new number slides up and fades in while
                    // the previous (smaller) number slides up to make room and fades out.
                    slideInVertically { it } + fadeIn() togetherWith
                            slideOutVertically { -it } + fadeOut()
                } else {
                    // If the incoming number is smaller, new number slides down and fades in while
                    // the previous number slides down and fades out.
                    slideInVertically { -it } + fadeIn() togetherWith
                            slideOutVertically { it } + fadeOut()
                    // Disable clipping since the faded slide-out is desired out of bounds, but
                    // the size transform is still needed from number getting longer
                }.using(SizeTransform(clip = false))
                // Using default spring for the size change.
            }, label = ""
        ) { targetCount ->
            // This establishes a mapping between the target state and the content in the form of a
            // Composable function. IMPORTANT: The parameter of this content lambda should
            // *always* be used. During the content transform, the old content will be looked up
            // using this lambda with the old state, until it's fully animated out.
            // Since AnimatedContent differentiates the contents using their target states as the
            // key, the same composable function returned by the content lambda like below will be
            // invoked under different keys and therefore treated as different entities.
            Text("$targetCount", fontSize = 20.sp)
        }
        Spacer(Modifier.size(20.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { count-- }) { Text("Minus") }
            Spacer(Modifier.size(60.dp))
            Button(onClick = { count++ }) {
                Text("Plus ")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimateConstPreview() {
    CompLocalDemoTheme {
        AnimateConst()
    }
}