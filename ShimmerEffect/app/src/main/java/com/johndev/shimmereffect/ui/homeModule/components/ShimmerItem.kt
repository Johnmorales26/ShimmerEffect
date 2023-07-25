package com.johndev.shimmereffect.ui.homeModule.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.johndev.shimmereffect.R
import com.johndev.shimmereffect.ui.theme.AntiFlashWhiteColor
import com.johndev.shimmereffect.ui.theme.ShimmerEffectTheme

@Composable
fun ShimmerItem(color: Color) {
    val gradient = listOf(
        color.copy(alpha = 0.9f),
        color.copy(alpha = 0.4f),
        color.copy(alpha = 0.9f),
    )
    val transition = rememberInfiniteTransition(label = "")
    val translateAnimation = transition.animateFloat(
        initialValue = 8f,
        targetValue = 1808f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        ), label = ""
    )
    val brush = linearGradient(
        colors = gradient,
        start = Offset(200f, 200f),
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )
    Surface(
        color = Color.Transparent,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.common_padding_min)),
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.card_height))
    ) {
        Card(
            border = BorderStroke(2.dp, brush),
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize(Alignment.CenterStart)
                    .padding(horizontal = dimensionResource(id = R.dimen.common_padding_default)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.common_padding_min))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(3f),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.common_padding_min))
                ) {
                    Text(
                        text = "",
                        Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .background(brush)
                    )
                    Text(
                        text = "",
                        Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .background(brush)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(brush)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShimmerEffectTheme {
        ShimmerItem(color = AntiFlashWhiteColor)
    }
}