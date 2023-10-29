package com.raa.dribbble_expiriment_one.ui.ticket

import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.UUID

data class TravelResumeInfo(
    val id : String = UUID.randomUUID().toString(),
    val originCity: String,
    val originDirection: String,
    val destinyCity: String,
    val destinyDirection: String,
    val price: Float,
    val departureTime: String,
    val travelTime: String,
    val fastest : Boolean = false,
){
    fun priceDecimal() : String {
        return String.format("%.2f",price)
    }
}
