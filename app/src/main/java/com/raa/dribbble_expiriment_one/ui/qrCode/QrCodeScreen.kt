package com.raa.dribbble_expiriment_one.ui.qrCode

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raa.dribbble_expiriment_one.R
import com.raa.dribbble_expiriment_one.darkGrey
import com.raa.dribbble_expiriment_one.darkPurple
import com.raa.dribbble_expiriment_one.orange
import com.raa.dribbble_expiriment_one.ticketsPurlplebck

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinishScreen(navController: NavController) {

    Scaffold(
        containerColor = ticketsPurlplebck,
        topBar = {
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
                        text = "Your ticket",
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
    ) {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            Column(
                modifier = Modifier

                    .verticalScroll(rememberScrollState())

            ) {

                CongratsMessage()
                QrCard()

            }

        }

    }
}

@Composable
fun CongratsMessage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Congrats!",
            color = Color.White,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Your ticket is ready to be used.",
            color = Color.White,
            fontSize = 13.sp,

            )
        Spacer(modifier = Modifier.height(60.dp))


    }
}

@Composable
fun QrCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = orange),
        modifier = Modifier.padding(horizontal = 30.dp),
    ) {
        Column {

            Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                Text(text = "Raúl Albín", color = darkPurple, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "SOA", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    ArrowIcons()
                    Spacer(modifier = Modifier.width(10.dp))

                    Text("RDW", modifier = Modifier.offset((-8 * 4).dp, 0.dp), fontSize = 12.sp)

                }
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TripDate()
                    NumberOfTravellersIndicator()
                    DepartureTime()
                }
            }
            Divider(color = darkPurple)

            Image(
                modifier = Modifier.padding(20.dp).align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.qrcode_orange),
                contentDescription = null
            )

        }
    }
}

@Composable
fun ArrowIcons() {
    Icon(
        imageVector = Icons.Outlined.KeyboardArrowRight,
        contentDescription = "arr1",
        tint = darkGrey,
        modifier = Modifier
            .padding(0.dp)
            .size(17.dp)
            .offset((-8).dp, 0.dp)


    )
    Icon(
        imageVector = Icons.Outlined.KeyboardArrowRight,
        contentDescription = "arr1",
        tint = darkGrey,
        modifier = Modifier
            .size(17.dp)
            .padding(0.dp)
            .offset((-8 * 2).dp, 0.dp)
    )

    Icon(
        imageVector = Icons.Outlined.KeyboardArrowRight,
        contentDescription = "arr1",
        tint = darkPurple,
        modifier = Modifier
            .size(17.dp)
            .padding(0.dp)
            .offset((-8 * 3).dp, 0.dp)

    )
}


@Composable
fun TripDate() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Outlined.DateRange, contentDescription = null, tint = darkPurple)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "12/12/2023",
            color = darkPurple,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun NumberOfTravellersIndicator() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Outlined.Person, contentDescription = null, tint = darkPurple)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "1",
            color = darkPurple,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DepartureTime() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_timer),
            contentDescription = null,
            tint = darkPurple
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "12:00",
            color = darkPurple,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}