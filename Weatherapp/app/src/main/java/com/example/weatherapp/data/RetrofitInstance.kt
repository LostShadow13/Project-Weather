package com.example.weatherapp.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val weatherApi: WeatherApi = Retrofit.Builder()
        .baseUrl("http://api.weatherstack.com/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(OkHttpClient.Builder().build())
        .build()
        .create(WeatherApi::class.java)

}