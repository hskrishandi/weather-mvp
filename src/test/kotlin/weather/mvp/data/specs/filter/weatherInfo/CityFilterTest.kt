package weather.mvp.data.specs.filter.weatherInfo

import org.junit.Assert.assertEquals
import org.junit.Test
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.model.types.Weather

class CityFilterTest {

    private val weathers = listOf(
        WeatherInfo(Weather.SUNNY, 30, Day.MON, "Jakarta"),
        WeatherInfo(Weather.CLOUDY, 20, Day.TUE, "Bangalore"),
        WeatherInfo(Weather.SUNNY, 33, Day.WED, "Jakarta")
    )

    private val filter = CityFilter()

    @Test
    fun `given weathers when filter by Jakarta then return result of size 2 and location is Jakarta`() {
        val result = filter.filter(weathers, "Jakarta")
        assertEquals(2, result.size)
        assertEquals("Jakarta", result[0].location)
    }
}