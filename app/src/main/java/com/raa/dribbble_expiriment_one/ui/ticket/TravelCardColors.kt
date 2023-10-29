package com.raa.dribbble_expiriment_one.ui.ticket

import androidx.compose.ui.graphics.Color
import com.raa.dribbble_expiriment_one.darkPurple
import com.raa.dribbble_expiriment_one.lightGrey
import com.raa.dribbble_expiriment_one.orange

data class SelectedCardColors(
    override val priceColor: Color = darkPurple,
    override val textMainColor: Color = darkPurple,
    override val textSecondaryColor: Color = darkPurple,
    override val cardColor: Color = orange,
) : TravelCardColors()

data class UnSelectedCardColor(
    override val priceColor: Color = orange,
    override val textMainColor: Color = Color.White,
    override val textSecondaryColor: Color = lightGrey,
    override val cardColor: Color = darkPurple,
) :TravelCardColors()

abstract class TravelCardColors{
    open val priceColor: Color = darkPurple
    open val textMainColor: Color = darkPurple
    open val textSecondaryColor: Color = darkPurple
    open val cardColor: Color = orange
}