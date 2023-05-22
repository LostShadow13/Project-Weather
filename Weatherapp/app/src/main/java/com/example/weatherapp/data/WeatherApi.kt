package com.example.weatherapp.data

import com.example.weatherapp.data.model.Weather
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

    @Headers("Content-Type: application/json")
    @GET("current")
    suspend fun getWeather(@Query("access_key") key: String, @Query("query") city: String): Weather

}