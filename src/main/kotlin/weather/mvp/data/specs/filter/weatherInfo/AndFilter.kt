package weather.mvp.data.specs.filter.weatherInfo

import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.specs.filter.FilterSpecification

class AndFilter(
    private val firstFilter: FilterSpecification<WeatherInfo>,
    private val secondFilter: FilterSpecification<WeatherInfo>
) : FilterSpecification<WeatherInfo> {

    override fun filter(weathers: List<WeatherInfo>, vararg keyword: String): List<WeatherInfo> {

        val firstFilterResult = firstFilter.filter(weathers, keyword[0])

        return secondFilter.filter(firstFilterResult, keyword[1])

    }
}