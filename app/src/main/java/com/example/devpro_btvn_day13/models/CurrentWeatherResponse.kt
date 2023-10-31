package com.example.devpro_btvn_day13.models


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("lists")
    val lists: List<Lists>,
    @SerializedName("message")
    val message: Int
)