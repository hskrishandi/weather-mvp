package weather.mvp.ui.main

import weather.mvp.data.Repository
import weather.mvp.data.WeatherInfoListRepository
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.specs.filter.FilterSpecification
import weather.mvp.data.specs.filter.weatherInfo.AndFilter
import weather.mvp.data.specs.filter.weatherInfo.CityFilter
import weather.mvp.data.specs.filter.weatherInfo.StartDayFilter
import weather.mvp.ui.Presenter

class WeatherInfoPresenter(
    private val view: View,
    private val weatherInfoRepo: Repository<WeatherInfo> = WeatherInfoListRepository(),
    private var filter: FilterSpecification<WeatherInfo> = AndFilter(CityFilter(), StartDayFilter())
) : Presenter {

    override fun onCreate() {
        weatherInfoRepo.add(weatherList)
    }

    override fun onDestroy() {}

    fun processInput(city: String, startDay: String){
        val results = weatherInfoRepo.query(filter, city, startDay)
        view.printResult(results)
    }

    interface View {
        fun printResult(weatherInfo: List<WeatherInfo>)
    }

}