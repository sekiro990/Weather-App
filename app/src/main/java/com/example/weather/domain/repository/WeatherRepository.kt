package com.example.weather.domain.repository

import com.example.weather.domain.weather.WeatherData
import com.example.weather.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double,long:Double):Resource<WeatherInfo>
}