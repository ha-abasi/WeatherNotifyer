package com.hamedaasi.weathernotifyer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrentTemperatureViewModel : ViewModel(){
    val currentTemperature : MutableLiveData<Float> by lazy {
        MutableLiveData<Float>()
    }
}