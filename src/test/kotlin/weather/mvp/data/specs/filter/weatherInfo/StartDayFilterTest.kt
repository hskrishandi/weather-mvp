package weather.mvp.data.specs.filter.weatherInfo

import org.junit.Test
import org.junit.Assert.assertEquals
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.model.types.Weather

class StartDayFilterTest {

    private val weathers = listOf(
        WeatherInfo(Weather.SUNNY, 30, Day.MON, "Jakarta"),
        WeatherInfo(Weather.CLOUDY, 20, Day.MON, "Bangalore"),
        WeatherInfo(Weather.RAINY, 22, Day.TUE, "Jakarta"),
        WeatherInfo(Weather.SUNNY, 33, Day.WED, "Jakarta"),
        WeatherInfo(Weather.FOGGY, 12, Day.THU, "Jakarta"),
        WeatherInfo(Weather.SUNNY, 30, Day.FRI, "Jakarta"),
        WeatherInfo(Weather.WINDY, 23, Day.SAT, "Jakarta")
    )

    private val filter = StartDayFilter()

    @Test
    fun `given weathers when StartDayFilter filter start Tuesday then get 5 results of consecutive days starting from Tuesday`() {
        val result = filter.filter(weathers, "Tuesday")
        assertEquals(5, result.size)
        assertEquals(Day.TUE, result[0].day)
        assertEquals(Day.WED, result[1].day)
        assertEquals(Day.THU, result[2].day)
        assertEquals(Day.FRI, result[3].day)
        assertEquals(Day.SAT, result[4].day)
    }

}