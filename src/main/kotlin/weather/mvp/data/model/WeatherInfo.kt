package main.kotlin.weather.mvp.data.model

import main.kotlin.weather.mvp.data.model.types.Day
import main.kotlin.weather.mvp.data.model.types.Weather

data class WeatherInfo(
    val weather: Weather,
    val temperature: Int,
    val day: Day,
    val location: String)