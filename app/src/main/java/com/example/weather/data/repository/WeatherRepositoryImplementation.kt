package com.example.weather.data.repository

import com.example.weather.data.mappers.toWeatherInfo
import com.example.weather.data.remote.WeatherApi
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.util.Resource
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImplementation @Inject constructor(
    private val api: WeatherApi
):WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
       return try {
           Resource.Success(
               data = api.getWeatherData(
                   lat=lat,
                   long=long
               ).toWeatherInfo()
           )
       }catch (e:Exception){
           e.printStackTrace()
           Resource.Error(e.message ?:"An unknown error occured")
       }
    }
}