package com.hamedaasi.weathernotifyer.api_fetch.weather

data class CurrentTemperature(
    val time : String,
    val interval : Int,
    val temperature_2m : Int,
)