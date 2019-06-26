package weather.mvp.data.specs.filter.weatherInfo

import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.specs.filter.FilterSpecification

class CityFilter : FilterSpecification<WeatherInfo> {
    override fun filter(weathers: List<WeatherInfo>, vararg keyword: String): List<WeatherInfo> {
        val result = mutableListOf<WeatherInfo>()

        for(weather in weathers){
            if(weather.location.equals(keyword[0], true))
                result.add(weather)
        }

        return result
    }
}