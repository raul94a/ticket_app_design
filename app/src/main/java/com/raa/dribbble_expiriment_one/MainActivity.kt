package com.raa.dribbble_expiriment_one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raa.dribbble_expiriment_one.ui.qrCode.FinishScreen
import com.raa.dribbble_expiriment_one.ui.home.HomeScreen
import com.raa.dribbble_expiriment_one.ui.theme.DribbbleExpirimentOneTheme
import com.raa.dribbble_expiriment_one.ui.ticket.TicketScreen
import com.raa.dribbble_expiriment_one.ui.ticket.TravelResumeInfo


val orange = Color(0xffFAC578)
val darkGrey = Color(0xff626264)
val lightGrey = Color(0xffE1E2E8)
val darkPurple = Color(0xff200D4A)
val lightPurple = Color(0xff6A4992)
val mainPurpleColor = Color(0xff7532DC)
val ticketsPurlplebck = Color(0xff562C9B)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            DribbbleExpirimentOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(navController)
                        }
                        composable("ticket") {
                            TicketScreen(navController)
                        }
                        composable("finish") {
                            FinishScreen(navController)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun TicketTravelResume(textMainColor: Color, textSecondaryColor: Color, travel: TravelResumeInfo) {
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Column {

            Text(
                text = travel.originCity,
                color = textMainColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = travel.originDirection,
                color = textSecondaryColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Column {

            Text(
                text = travel.destinyCity,
                color = textMainColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = travel.destinyDirection,
                color = textSecondaryColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}
