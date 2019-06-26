package weather.mvp.data.specs.filter.weatherInfo

import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.specs.filter.FilterSpecification

class DayFilter : FilterSpecification<WeatherInfo> {
    override fun filter(weathers: List<WeatherInfo>, vararg keyword: String): List<WeatherInfo> {
        val result = mutableListOf<WeatherInfo>()

        val day = Day.fromName(keyword[0])

        for(weather in weathers){
            if(weather.day == day)
                result.add(weather)
        }

        return result
    }
}