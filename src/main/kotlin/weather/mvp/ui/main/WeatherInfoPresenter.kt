package weather.mvp.ui.main

import weather.mvp.data.WeatherInfoListRepository
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.model.types.Weather
import weather.mvp.data.specs.filter.weatherInfo.AndFilter
import weather.mvp.data.specs.filter.weatherInfo.CityFilter
import weather.mvp.data.specs.filter.weatherInfo.StartDayFilter
import weather.mvp.ui.Presenter

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

class WeatherInfoPresenter(private val view: View) : Presenter {

    private val weatherInfoRepo = WeatherInfoListRepository()

    override fun onCreate() {
        weatherInfoRepo.add(weatherList)
    }

    override fun onDestroy() {}

    fun processInput(city: String, startDay: String){
        val results = weatherInfoRepo.query(null, city, startDay)
        view.printResult(results)
    }

    interface View {
        fun printResult(weatherInfo: List<WeatherInfo>)
    }

}