package com.raa.dribbble_expiriment_one.ui.ticket.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raa.dribbble_expiriment_one.R
import com.raa.dribbble_expiriment_one.ticketsPurlplebck

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketAppBar(navController: NavController){
    TopAppBar(
        modifier = Modifier.padding(5.dp),
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = ticketsPurlplebck),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        title = {
            Text(
                text = "Choose ticket",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth()
            )
        },
        actions = {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.ic_sort),
                contentDescription = "Menu",
                tint = Color.White
            )
        }
    )
}