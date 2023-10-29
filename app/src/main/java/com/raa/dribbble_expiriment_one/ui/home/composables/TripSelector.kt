package com.raa.dribbble_expiriment_one.ui.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raa.dribbble_expiriment_one.R
import com.raa.dribbble_expiriment_one.darkGrey
import com.raa.dribbble_expiriment_one.lightGrey
import com.raa.dribbble_expiriment_one.orange


@Composable
fun TripSelector(){

        Column(modifier = Modifier.fillMaxHeight(.4f)) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(50.dp))

                // thing

                TravelPlaceholder()
                Spacer(modifier = Modifier.width(15.dp))
                // from - to
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight(1.1f)
                ) {
                    Column {

                        Text(text = "Southampton", color = Color.White, fontSize = 30.sp)
                        Text(text = "Airptort", color = Color.LightGray)
                    }

                    Column {

                        Text(text = "Reading", color = Color.White, fontSize = 30.sp)
                        Text(text = "West", color = Color.LightGray)
                    }

                }
            }
        }


}

@Composable
fun OrangeCircle() {
    Box() {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color(0xffF98040), shape = CircleShape)
        ) {}
        Box(
            modifier = Modifier
                .size(6.dp)
                .background(Color(0xff141B84), shape = CircleShape)
                .align(Alignment.Center)
        ) {}
    }


}


@Composable
fun TravelPlaceholder() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        OrangeCircle()
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = darkGrey,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = darkGrey,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = darkGrey,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = lightGrey,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )
        Box(
            modifier = Modifier
                .background(orange, CircleShape)
                .size(30.dp), contentAlignment = Alignment.Center
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_sort),
                contentDescription = "arr1",
                modifier = Modifier
                    .padding(5.dp)
                    .rotate(90f)
                    .size(13.dp)
            )
        }

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = darkGrey,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = darkGrey,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = darkGrey,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = lightGrey,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )
        OrangeCircle()
    }
}
