package com.example.devpro_btvn_day13.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devpro_btvn_day13.repositories.WeatherRepository

class MainViewModelFactory(private val weatherRepository: WeatherRepository, private val application: Application):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(weatherRepository, application) as T
    }
}