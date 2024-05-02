package com.hamedaasi.weathernotifyer.api_fetch.weather

data class ReturnInfo(
    val latitude : Float,
    val longitude : Float,
    val elevation: Int,
    val current: CurrentTemperature
)