package com.shu.complocaldemo.runToRun

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.runToRun.HomeTopBarHeader
import com.shu.complocaldemo.runToRun.HomeWeeklyGoalCard
import com.shu.complocaldemo.runToRun.RunningButton
import kotlin.math.roundToInt

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
   // user: User,
    weeklyGoal: Float,
    onWeeklyGoalClick: () -> Unit,
    distanceCovered: Float,
    duration: Long,
    navigateToRun: () -> Unit,
    navigateToSettings: () -> Unit
) {
    Box(
        modifier = modifier.height(IntrinsicSize.Min),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(bottomStart = 64.dp, bottomEnd = 64.dp)
                )
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(bottomStart = 64.dp, bottomEnd = 64.dp),
                    ambientColor = MaterialTheme.colorScheme.primary,
                    spotColor = MaterialTheme.colorScheme.primary
                )
        )
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeTopBarHeader(
              //  user = user,
                navigateToSettings = navigateToSettings
            )
            Spacer(modifier = Modifier.size(32.dp))
            if (duration > 0) {
                HomeWeeklyGoalCard(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    weeklyGoal = weeklyGoal.roundToInt(),
                    weeklyGoalDone = distanceCovered,
                    onClick = onWeeklyGoalClick
                )
            } else {
                RunningButton(
                    modifier = Modifier,
                    navigateToRun = navigateToRun
                )
            }
        }
    }
}