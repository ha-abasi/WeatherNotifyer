package com.hamedaasi.weathernotifyer.api_fetch.weather

import com.google.gson.GsonBuilder
import com.hamedaasi.weathernotifyer.CurrentTemperatureViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class FetchData {
    val base_addr = "https://api.open-meteo.com/v1/";
    /*


       {
           "latitude": 52.52,
           "longitude": 13.419998,
           "generationtime_ms": 0.02300739288330078,
           "utc_offset_seconds": 0,
           "timezone": "GMT",
           "timezone_abbreviation": "GMT",
           "elevation": 38,
           "current_units": {
               "time": "iso8601",
               "interval": "seconds",
               "temperature_2m": "°C"
           },
           "current": {
               "time": "2024-05-02T10:00",
               "interval": 900,
               "temperature_2m": 24
           }
       }




    */
    fun fetchWeather(model : CurrentTemperatureViewModel) {
        val gson = GsonBuilder() .setLenient() .create()
        val retrofit =	Retrofit
            .Builder()
            .baseUrl(base_addr)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val info: ReturnInfoAPI = retrofit.create(ReturnInfoAPI::class.java)

        val call : Call<ReturnInfo> = info.getReturnInfo()

        class MyCallBack : Callback<ReturnInfo> {
            override fun onResponse(p0: Call<ReturnInfo>, p1: Response<ReturnInfo>) {
                Timber.i("OnSuccess")
                model.currentTemperature.value = p1.body()?.current?.temperature_2m
                Timber.i("At ${p1.body()?.current?.time}, The Temperature : " + p1.body()?.current?.temperature_2m)
            }

            override fun onFailure(p0: Call<ReturnInfo>, p1: Throwable) {
                Timber.i("onFailure !")
                Timber.i(p1.message)
            }

        }

        call.enqueue(MyCallBack())
    }
}