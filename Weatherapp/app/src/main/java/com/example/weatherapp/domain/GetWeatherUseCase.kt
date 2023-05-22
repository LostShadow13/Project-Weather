package com.example.weatherapp.domain

import com.example.weatherapp.data.Repository
import com.example.weatherapp.data.model.Weather

class GetWeatherUseCase {

    private val repository = Repository()

    suspend fun execute(city: String): Weather? {
        return repository.getWeather(city)
    }

}