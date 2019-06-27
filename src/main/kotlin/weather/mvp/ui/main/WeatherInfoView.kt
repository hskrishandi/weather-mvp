package weather.mvp.ui.main

import weather.mvp.data.model.WeatherInfo
import weather.mvp.utils.WeatherInfoPrinter

class WeatherInfoView : WeatherInfoPresenter.View {

    private val presenter = WeatherInfoPresenter(this)
    private val printer = WeatherInfoPrinter()

    init {
        presenter.onCreate()
    }

    fun onSubmit(city: String, day: String) {
        presenter.processInput(city, day)
    }

    fun onDestroy(){
        presenter.onDestroy()
    }

    override fun printResult(weatherInfo: List<WeatherInfo>) {
        val results = printer.arrangeByCity(weatherInfo)
        printer.printByCity(results)
    }

}