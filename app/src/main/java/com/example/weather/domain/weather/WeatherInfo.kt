package com.example.weather.domain.weather

import com.example.weather.data.remote.WeatherDto
import java.time.MonthDay

data class WeatherInfo(
    val weatherDataPerDay: Map<Int,List<WeatherData>>,
    val currentWeatherData:WeatherData?
)
