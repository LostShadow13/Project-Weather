package com.example.weatherapp.data

import com.example.weatherapp.data.model.Weather
import java.lang.Exception

class Repository {

    private val api = RetrofitInstance.weatherApi

    companion object {
        private const val API_KEY = "1da90e34e141af86f61aa8b1905aff12"
    }

    suspend fun getWeather(city: String): Weather? {
        return try {
            api.getWeather(API_KEY, city)
        } catch (e: Exception) {
            null
        }
    }

}