package weather.mvp.ui.main

import weather.mvp.data.WeatherInfoListRepository
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.specs.filter.weatherInfo.AndFilter
import weather.mvp.data.specs.filter.weatherInfo.CityFilter
import weather.mvp.data.specs.filter.weatherInfo.StartDayFilter
import weather.mvp.ui.Presenter

class WeatherInfoPresenter(private val view: View) : Presenter {

    private val weatherInfoRepo = WeatherInfoListRepository()

    override fun onCreate() {
        weatherInfoRepo.add(weatherList)
    }

    override fun onDestroy() {}

    fun processInput(city: String, startDay: String){
        val results = weatherInfoRepo.query(AndFilter(CityFilter(), StartDayFilter()), city, startDay)
        view.printResult(results)
    }

    interface View {
        fun printResult(weatherInfo: List<WeatherInfo>)
    }

}