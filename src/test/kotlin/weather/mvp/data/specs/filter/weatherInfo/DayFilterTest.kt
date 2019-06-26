package weather.mvp.data.specs.filter.weatherInfo

import org.junit.Assert.assertEquals
import org.junit.Test
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.model.types.Weather

class DayFilterTest {

    private val weathers = listOf(
        WeatherInfo(Weather.SUNNY, 30, Day.MON, "Jakarta"),
        WeatherInfo(Weather.CLOUDY, 20, Day.MON, "Bangalore"),
        WeatherInfo(Weather.SUNNY, 33, Day.WED, "Jakarta")
    )

    private val filter = DayFilter()

    @Test
    fun `given weathers when DayFilter filter by Monday then return result of size 2 and day is MON`() {
        val result = filter.filter(weathers, "Monday")

        assertEquals(2, result.size)
        assertEquals(Day.MON, result[0].day)

    }

}