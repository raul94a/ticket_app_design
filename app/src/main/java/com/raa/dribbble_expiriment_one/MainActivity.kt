package com.raa.dribbble_expiriment_one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raa.dribbble_expiriment_one.ui.finish.FinishScreen
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
