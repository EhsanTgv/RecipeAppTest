package com.project.recipeapptest.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingRecipeListShimmer(
    imageHeight: Dp,
    padding: Dp = 16.dp
) {
    val cardHeightPx = with(LocalDensity.current) { imageHeight.toPx() }

    val xTransition = rememberInfiniteTransition()
    val yTransition = rememberInfiniteTransition()

    val xState = xTransition.animateFloat(
        initialValue = 0f,
        targetValue = cardHeightPx * 2,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1300,
                delayMillis = 300,
                easing = LinearEasing
            )
        )
    )

    val yState = yTransition.animateFloat(
        initialValue = 0f,
        targetValue = cardHeightPx,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1300,
                delayMillis = 300,
                easing = LinearEasing
            )
        )
    )

    val colors = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.9f),
    )

    LazyColumn {
        items(5) {
            ShimmerRecipeCardItem(
                colors = colors,
                cardHeight = imageHeight,
                xShimmer = xState.value,
                yShimmer = yState.value,
                padding = padding
            )
        }
    }
}