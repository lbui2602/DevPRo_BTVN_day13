package com.example.devpro_btvn_day13.api

import com.example.devpro_btvn_day13.models.CurrentWeatherResponse
import com.example.devpro_btvn_day13.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(Constants.CURRENT_WEATHER_URL)
    suspend fun getCurrentWeatherByCityName(
        @Query("q") cityName:String,
        @Query("appid") apiKey:String,
        @Query("lang") lang:String ? = "en"
    ): Response<CurrentWeatherResponse>
}