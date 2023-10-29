package com.raa.dribbble_expiriment_one.ui.ticket.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.raa.dribbble_expiriment_one.darkPurple

@Composable
fun Chip(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .background(darkPurple, RoundedCornerShape(30.dp))
            .padding(10.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = text, color = Color.White)
    }
}