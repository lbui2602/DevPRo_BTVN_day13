package com.example.devpro_btvn_day13.api

import com.example.devpro_btvn_day13.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        val instances: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val getWeatherApi:WeatherApi = instances.create(WeatherApi::class.java)
    }
}