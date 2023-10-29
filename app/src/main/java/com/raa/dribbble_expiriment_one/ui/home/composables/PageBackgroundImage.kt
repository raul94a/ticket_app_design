package com.raa.dribbble_expiriment_one.ui.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.raa.dribbble_expiriment_one.R

@Composable
fun PageBackgroundImage() {
    val colorPurple = Color(0xff360D76)

    Image(contentScale = ContentScale.FillHeight,
        painter = painterResource(id = R.drawable.train),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .scale(1f)
            .graphicsLayer { alpha = 1f }
            .drawWithContent {
                val colors = listOf(Color(0xff7532DC), colorPurple)

                drawContent()
                drawRect(
                    brush = Brush.radialGradient(colors, radius = 400f),
                    blendMode = BlendMode.Darken
                )

            })
}