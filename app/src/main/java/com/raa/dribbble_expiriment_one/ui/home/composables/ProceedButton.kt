package com.raa.dribbble_expiriment_one.ui.home.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.raa.dribbble_expiriment_one.darkPurple
import com.raa.dribbble_expiriment_one.orange

@Composable
fun ProceedButton(navController: NavController, modifier : Modifier){
    ElevatedButton(
        shape = RoundedCornerShape(23.dp),
        colors = ButtonDefaults.buttonColors(containerColor = orange),
        onClick = { navController.navigate("ticket") },
        modifier = modifier,
    ) {
        Text(text = "PROCEED", color = darkPurple)
    }
}