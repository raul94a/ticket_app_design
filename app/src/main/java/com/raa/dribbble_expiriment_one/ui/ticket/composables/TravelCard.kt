package com.raa.dribbble_expiriment_one.ui.ticket.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raa.dribbble_expiriment_one.R
import com.raa.dribbble_expiriment_one.TicketTravelResume
import com.raa.dribbble_expiriment_one.darkGrey
import com.raa.dribbble_expiriment_one.darkPurple
import com.raa.dribbble_expiriment_one.mainPurpleColor
import com.raa.dribbble_expiriment_one.orange
import com.raa.dribbble_expiriment_one.ui.ticket.SelectedCardColors
import com.raa.dribbble_expiriment_one.ui.ticket.TravelResumeInfo
import com.raa.dribbble_expiriment_one.ui.ticket.UnSelectedCardColor
import kotlin.math.round
import kotlin.math.roundToInt


@Composable
fun TravelCard(
    selected: Boolean,
    onClick: () -> Unit,
    travel: TravelResumeInfo
) {
    val padding = 30.dp
    val cardColors = if (selected) SelectedCardColors() else UnSelectedCardColor()
    Box(modifier = Modifier.padding(horizontal = padding)) {

        Card(
            colors = CardDefaults.cardColors(containerColor = cardColors.cardColor),
            modifier = Modifier
                .clickable {
                    onClick()
                }
                .border(shape = RoundedCornerShape(20.dp), color = Color.Transparent, width = 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp), verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row {

                        TicketTripIcons(selected)
                        Spacer(modifier = Modifier.width(10.dp))
                        TicketTravelResume(
                            cardColors.textMainColor,
                            cardColors.textSecondaryColor,
                            travel
                        )
                    }
                    Row {


                        TravelPrice(
                            cardColors.priceColor,
                            cardColors.textSecondaryColor,
                            travel.priceDecimal()
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }

            Divider(color = if(selected) darkPurple else Color.White, thickness = .5f.dp)
            Spacer(modifier = Modifier.height(10.dp))
            DepartureInfo(cardColors.textSecondaryColor, cardColors.textMainColor, travel)
            Spacer(modifier = Modifier.height(10.dp))

        }
        if (travel.fastest) Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(25.dp)
                .offset((-7).dp, ((-4).dp))
                .background(
                    color = Color(0xff3C87C6),
                    shape = CircleShape
                )
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_flash),
                modifier = Modifier.size(16.dp),
                contentDescription = null,

                )
        }
    }
}


@Composable
fun DepartureInfo(textSecondaryColor: Color, textMainColor: Color, travel: TravelResumeInfo) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.width(40.dp))
        Column {
            Text(
                text = "Departure Time",
                fontSize = 13.sp,
                fontWeight = FontWeight.Light,
                color = textSecondaryColor
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Icon(
                    imageVector = Icons.Outlined.CheckCircle,
                    tint = textMainColor,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = travel.departureTime, fontSize = 15.sp, color = textMainColor)
            }
        }
        Spacer(modifier = Modifier.width(40.dp))

        Column {
            Text(
                text = "Travel Time",
                fontSize = 13.sp,
                color = textSecondaryColor,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.height(5.dp))

            Row {
                Icon(
                    imageVector = Icons.Outlined.CheckCircle,
                    tint = textMainColor,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(text = travel.travelTime, fontSize = 15.sp, color = textMainColor)
            }
        }
    }
}

@Composable
fun TravelPrice(priceColor: Color, textSecondaryColor: Color, price: String) {
    Column(verticalArrangement = Arrangement.Top) {

        Text(
            text = "Price",
            textAlign = TextAlign.Start,
            fontSize = 12.sp,
            color = textSecondaryColor,
            fontWeight = FontWeight.Light
        )
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 14.sp,
                    color = priceColor,

                    )
            ) {
                append("£")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 24.sp,
                    color = priceColor,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(price)
            }
        })
    }
}


@Composable
fun TicketTripIcons(selected: Boolean) {
    val lightGrey = Color(0xffEEE9E1)
    var iconMain = lightGrey
    var iconLast = darkGrey
    if (selected) {
        iconMain = iconLast
        iconLast = lightGrey
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(15.dp))
        PurpleCircle(selected = selected)
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = iconMain,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = iconMain,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "arr1",
            tint = iconLast,
            modifier = Modifier
                .size(17.dp)
                .padding(0.dp)
        )
        PurpleCircle(selected)
    }
}


@Composable
fun PurpleCircle(selected: Boolean) {
    var outerCircleColor = mainPurpleColor
    var innerCircleColor = orange
    if (!selected) {
        outerCircleColor = innerCircleColor
        innerCircleColor = mainPurpleColor
    }
    Box() {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(outerCircleColor, shape = CircleShape)
        ) {}
        Box(
            modifier = Modifier
                .size(6.dp)
                .background(innerCircleColor, shape = CircleShape)
                .align(Alignment.Center)
        ) {}
    }


}

