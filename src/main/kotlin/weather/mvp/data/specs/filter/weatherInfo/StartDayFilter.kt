package weather.mvp.data.specs.filter.weatherInfo

import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.specs.filter.FilterSpecification

class StartDayFilter : FilterSpecification<WeatherInfo> {

    private val numOfDays = 5
    private val dayFilter = DayFilter()

    override fun filter(weathers: List<WeatherInfo>, vararg keyword: String): List<WeatherInfo> {
        val result = mutableListOf<WeatherInfo>()
        val day = Day.fromName(keyword[0]) ?: return result
        val dayIndex = day.ordinal

        for(i in 0 until numOfDays){
            val index = (dayIndex + i) % 7
            result.addAll(dayFilter.filter(weathers, Day.values()[index].day))
        }

        return result
    }
}