package com.raa.dribbble_expiriment_one.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raa.dribbble_expiriment_one.R
import com.raa.dribbble_expiriment_one.ui.home.composables.BottomNavigationBar
import com.raa.dribbble_expiriment_one.ui.home.composables.PageBackgroundImage
import com.raa.dribbble_expiriment_one.ui.home.composables.ProceedButton
import com.raa.dribbble_expiriment_one.ui.home.composables.TripDatePersonOptions
import com.raa.dribbble_expiriment_one.ui.home.composables.TripSelector


// HOMEEEEE
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val systemUiController: SystemUiController = rememberSystemUiController()

    systemUiController.isStatusBarVisible = false // Status bar
    systemUiController.isNavigationBarVisible = false // Navigation bar
    systemUiController.isSystemBarsVisible = false // Status & Navigation bars        setContent {
    var index by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            BottomNavigationBar(onClick = {
                index = it
            }, selectedIndex = index)

        }
    ) {

        Box(

            modifier = Modifier
                .fillMaxSize()

        ) {
            PageBackgroundImage()

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
            {
                Column(modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.height(50.dp))

                    Header()

                    // Southampton
                    Spacer(modifier = Modifier.height(20.dp))
                    TripSelector()
                    Spacer(modifier = Modifier.height(50.dp))

                    TripDatePersonOptions()

                    ProceedButton(
                        navController = navController, modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(.9f)
                            .height(55.dp)
                    )
                }

            }
        }


    }

}


@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(40.dp))


        Text(
            text = "Your Trip",
            textAlign = TextAlign.End,
            color = Color.White,
        )

        Box() {

            Row {


                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_sort),
                    contentDescription = "Menu",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.padding(end = 15.dp))
            }
        }

    }
}



