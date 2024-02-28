package com.example.weather.data.remote

import com.plcoding.weatherapp.data.remote.WeatherDataDto
import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name= "hourly")
    val weatherData: WeatherDataDto
)
