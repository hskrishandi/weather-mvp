package weather.mvp.data.specs.filter.weatherInfo

import org.junit.Assert.assertEquals
import org.junit.Test
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.model.types.Weather

class AndFilterTest {

    private val weathers = listOf(
        WeatherInfo(Weather.SUNNY, 30, Day.MON, "Jakarta"),
        WeatherInfo(Weather.CLOUDY, 20, Day.MON, "Bangalore"),
        WeatherInfo(Weather.RAINY, 22, Day.TUE, "Jakarta"),
        WeatherInfo(Weather.SUNNY, 33, Day.WED, "Jakarta")
    )

    private val cityAndDayfilter = AndFilter(CityFilter(), DayFilter())

    @Test
    fun `given list of weathers when city and day filter by Jakarta Monday then return 1 result location Jakarta and day MON`() {
        val result = cityAndDayfilter.filter(weathers, "Jakarta", "Monday")
        assertEquals(1, result.size)
        assertEquals("Jakarta", result[0].location)
        assertEquals(Day.MON, result[0].day)
    }
}