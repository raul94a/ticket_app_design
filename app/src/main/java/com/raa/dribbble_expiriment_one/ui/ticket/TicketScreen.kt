package com.raa.dribbble_expiriment_one.ui.ticket


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raa.dribbble_expiriment_one.R
import com.raa.dribbble_expiriment_one.darkPurple
import com.raa.dribbble_expiriment_one.lightGrey
import com.raa.dribbble_expiriment_one.orange
import com.raa.dribbble_expiriment_one.ticketsPurlplebck
import com.raa.dribbble_expiriment_one.ui.ticket.composables.Chip
import com.raa.dribbble_expiriment_one.ui.ticket.composables.TicketAppBar
import com.raa.dribbble_expiriment_one.ui.ticket.composables.TravelCard


val travelOne = TravelResumeInfo(
    originCity = "Southampton",
    originDirection = "Airport",
    destinyCity = "Reading",
    destinyDirection = "West",
    price = 21.5f,
    departureTime = "12:00",
    travelTime = "1h 10min"
)


val travelTwo = TravelResumeInfo(

    originCity = "Southampton",
    originDirection = "Airport",
    destinyCity = "Reading",
    destinyDirection = "West",
    price = 22.99f, departureTime = "12:50",
    travelTime = "55min",
    fastest = true,
)

val travelThree = TravelResumeInfo(
    originCity = "Southampton",
    originDirection = "Airport",
    destinyCity = "Reading",
    destinyDirection = "West",
    price = 21.5f,
    departureTime = "13:30",
    travelTime = "1h 27min"
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketScreen(navController: NavController) {

    Scaffold(
        containerColor = ticketsPurlplebck,
        topBar = {
            TicketAppBar(navController)
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
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Spacer(modifier = Modifier.width(20.dp))
                    Chip(icon = Icons.Outlined.Person, text = "1 Adult")
                    Spacer(modifier = Modifier.width(5.dp))
                    Chip(icon = Icons.Outlined.DateRange, text = "12/10/2023")
                }
                TravelList()

            }
            BoxWithConstraints {
                val yOffset = this.maxHeight * .85f
                val xOffset = this.maxWidth
                val width = 60.dp
                val height = 65.dp
                IconButton(

                    modifier = Modifier
                        .offset(xOffset - width, yOffset)
                        .width(width)
                        .height(height)
                        .border(
                            color = darkPurple,
                            shape = RoundedCornerShape(topStart = 22.dp, bottomStart = 22.dp),
                            width = 1.5f.dp
                        )
                        .background(
                            color = orange,
                            shape = RoundedCornerShape(topStart = 22.dp, bottomStart = 22.dp)
                        ),
                    onClick = { navController.navigate("finish") }) {
                    Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = null)
                }

            }
        }

    }

}


@Composable
fun TravelList() {
    val selected = remember {
        mutableStateOf(travelOne.id)
    }
    Spacer(modifier = Modifier.height(20.dp))

    TravelCard(

        travel = travelOne,
        selected = selected.value == travelOne.id,
        onClick = {
            if (selected.value != travelOne.id) {
                selected.value = travelOne.id
            }
        }
    )
    Spacer(modifier = Modifier.height(20.dp))


    TravelCard(
        travel = travelTwo,
        selected = selected.value == travelTwo.id,
        onClick = {
            if (selected.value != travelTwo.id) {
                selected.value = travelTwo.id
            }
        }
    )

    Spacer(modifier = Modifier.height(20.dp))

    TravelCard(
        travel = travelThree,
        selected = selected.value == travelThree.id,
        onClick = {
            if (selected.value != travelThree.id) {
                selected.value = travelThree.id
            }
        }
    )
    Spacer(modifier = Modifier.height(20.dp))
}

