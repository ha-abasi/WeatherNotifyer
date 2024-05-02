package com.hamedaasi.weathernotifyer.api_fetch.weather

import retrofit2.Call
import retrofit2.http.GET

interface ReturnInfoAPI {
    @GET("forecast?latitude=36.8380666&longitude=54.4451586&current=temperature_2m")
    fun getReturnInfo() : Call<ReturnInfo>
}