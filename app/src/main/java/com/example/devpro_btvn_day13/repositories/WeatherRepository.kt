package com.example.devpro_btvn_day13.repositories

import com.example.devpro_btvn_day13.api.RetrofitClient
import com.example.devpro_btvn_day13.utils.Constants

class WeatherRepository {
    suspend fun getCurrentWeatherByCityName(cityName:String)=
        RetrofitClient.getWeatherApi.getCurrentWeatherByCityName(cityName, Constants.API_KEY)
}