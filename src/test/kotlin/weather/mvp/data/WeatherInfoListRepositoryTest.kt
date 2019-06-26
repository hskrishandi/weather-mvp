package weather.mvp.data

import org.junit.Assert.assertEquals
import org.junit.Test
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day
import weather.mvp.data.model.types.Weather
import weather.mvp.data.specs.filter.weatherInfo.CityFilter

class WeatherInfoListRepositoryTest {

    private val weathers = listOf(
        WeatherInfo(Weather.SUNNY, 30, Day.MON, "Jakarta"),
        WeatherInfo(Weather.CLOUDY, 20, Day.TUE, "Bangalore"),
        WeatherInfo(Weather.SUNNY, 33, Day.WED, "Jakarta")
    )

    private val repo = WeatherInfoListRepository()

    @Test
    fun `given a weatherInfo when adding one instance then querying with no specification gives one and same result`(){
        repo.add(weathers[0])
        val result = repo.query()
        assertEquals(1, result.size)
    }

    @Test
    fun `given list of weatherInfo when adding list then querying with no specification gives all result`(){
        repo.add(weathers)
        val result = repo.query()
        assertEquals(3, result.size)
    }

    @Test
    fun `given list of weatherInfo added to repo when and querying with a specification then return filtered result`(){
        repo.add(weathers)

        val result = repo.query(CityFilter(), "Jakarta")
        assertEquals(2, result.size)
        assertEquals("Jakarta", result[0].location)
    }

}