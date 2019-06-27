package weather.mvp.ui.main

import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.model.types.Weather

val weatherList = listOf(
    WeatherInfo(Weather.SUNNY, 30, Day.MON, "Jakarta"),
    WeatherInfo(Weather.CLOUDY, 20, Day.TUE, "Jakarta"),
    WeatherInfo(Weather.SUNNY, 33, Day.WED, "Jakarta"),
    WeatherInfo(Weather.RAINY, 17, Day.THU, "Jakarta"),
    WeatherInfo(Weather.WINDY, 18, Day.FRI, "Jakarta"),
    WeatherInfo(Weather.FOGGY, 18, Day.SAT, "Jakarta"),
    WeatherInfo(Weather.SUNNY, 27, Day.SUN, "Jakarta"),

    WeatherInfo(Weather.FOGGY, 18, Day.MON, "Bangalore"),
    WeatherInfo(Weather.WINDY, 22, Day.TUE, "Bangalore"),
    WeatherInfo(Weather.SUNNY, 39, Day.WED, "Bangalore"),
    WeatherInfo(Weather.WINDY, 27, Day.THU, "Bangalore"),
    WeatherInfo(Weather.WINDY, 21, Day.FRI, "Bangalore"),
    WeatherInfo(Weather.FOGGY, 18, Day.SAT, "Bangalore"),
    WeatherInfo(Weather.SUNNY, 27, Day.SUN, "Bangalore")
)