package com.shu.complocaldemo.runToRun

import android.net.Uri
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.shu.complocaldemo.R

@Composable
fun UserProfileImage(
    modifier: Modifier = Modifier,
    imgUri: Uri?,
    // gender: Gender,
    tint: Color = MaterialTheme.colorScheme.onPrimary
) {
    AsyncImage(
        model = imgUri,
        contentDescription = null,
        modifier = modifier,
        fallback = painterResource(
            R.drawable.male
            /*    id = when (gender) {
                    Gender.MALE -> {
                        R.drawable.male
                    }

                    Gender.FEMALE -> {
                        R.drawable.female
                    }

                    else -> {
                        R.drawable.no_male_no_female
                    }
                }*/
        ),
        contentScale = ContentScale.Crop,
        colorFilter = if (imgUri == null) {
            ColorFilter.tint(color = tint)
        } else {
            null
        }
    )
}