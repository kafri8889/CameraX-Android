package com.anafthdev.camerax

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun DragHandle(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth(0.3f)
            .height(4.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface)
    )
}
