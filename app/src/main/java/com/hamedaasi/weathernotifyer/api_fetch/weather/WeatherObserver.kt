package com.hamedaasi.weathernotifyer.api_fetch.weather

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.work.PeriodicWorkRequest
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.GsonBuilder
import com.hamedaasi.weathernotifyer.CurrentTemperatureViewModel
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.runInterruptible
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber


class WeatherObserver(val model: CurrentTemperatureViewModel) : DefaultLifecycleObserver {

    var active:  Boolean = false

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Timber.i("On Start")

        runBlocking {
            FetchData().fetchWeather(model)
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)

        Timber.i("On Stop")

    }
}