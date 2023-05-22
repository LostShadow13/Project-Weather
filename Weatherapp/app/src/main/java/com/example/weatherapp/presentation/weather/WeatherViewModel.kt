package com.example.weatherapp.presentation.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.domain.GetWeatherUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val getWeatherUseCase = GetWeatherUseCase()

    private val _weatherLiveData = MutableLiveData<Weather?>()
    val weatherLiveData: LiveData<Weather?> get() = _weatherLiveData

    fun loadWeather(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val weather = getWeatherUseCase.execute(city)
            _weatherLiveData.postValue(weather)
        }
    }

}