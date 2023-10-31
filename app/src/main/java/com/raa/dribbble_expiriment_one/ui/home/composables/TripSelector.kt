package com.raa.dribbble_expiriment_one.ui.home.composables

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloat
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raa.dribbble_expiriment_one.R
import com.raa.dribbble_expiriment_one.darkGrey
import com.raa.dribbble_expiriment_one.lightGrey
import com.raa.dribbble_expiriment_one.orange


@SuppressLint("Range")
@Composable
fun TripSelector() {

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

        ArrowCircle()

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


@SuppressLint("UnusedTransitionTargetStateParameter")
@OptIn(ExperimentalTransitionApi::class)
@Composable
fun ArrowCircle() {
    // Allow resume on rotation

    var clickedState = remember { MutableTransitionState(false) }
    val transition = rememberTransition(clickedState)
    val rotation by transition.animateFloat(
        // Uses a custom spring for the transition.
        transitionSpec = {

            if (false isTransitioningTo true) {
                tween(1200, delayMillis = 250)
            } else spring(dampingRatio = Spring.DampingRatioMediumBouncy)

        }, label = "scale!"
    ){
        if(it) 1f else 720f
    }
    Log.d("ROTATION", "$rotation")
    LaunchedEffect(key1 = "RotationAnimation", block = {
        clickedState.targetState = true
    })
    Box(
        modifier = Modifier
            .background(orange, CircleShape)
            .size(30.dp), contentAlignment = Alignment.Center
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_compare),
            contentDescription = "arr1",
            modifier = Modifier
                .rotate(90f + rotation)
                .size(16.dp)
                
        )
    }
}