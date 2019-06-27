package weather.mvp.ui.main

import org.junit.Before
import org.junit.Test
import org.mockito.*
import weather.mvp.data.WeatherInfoListRepository
import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.specs.filter.FilterSpecification
import weather.mvp.data.specs.filter.weatherInfo.AndFilter
import weather.mvp.data.specs.filter.weatherInfo.CityFilter
import weather.mvp.data.specs.filter.weatherInfo.StartDayFilter

class WeatherInfoPresenterTest {

    private val items = weatherList

    @Mock
    private lateinit var mockItems: List<WeatherInfo>

    @Mock
    private lateinit var view: WeatherInfoPresenter.View

    @Mock
    private lateinit var repo: WeatherInfoListRepository

    private lateinit var filter: FilterSpecification<WeatherInfo>

    private lateinit var presenter: WeatherInfoPresenter

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        filter = AndFilter(CityFilter(), StartDayFilter())
        presenter = WeatherInfoPresenter(view, repo, filter)
    }

    @Test
    fun `given presenter when presenter onCreate then repo calls add predefined weather items`() {
        presenter.onCreate()
        Mockito.verify(repo).add(items)
    }

    @Test
    fun `given presenter when presenter processInput then repo queries result and view prints result`() {
        val city = "Jakarta"
        val day = "Monday"
        val results = repo.query(filter, city, day)

        presenter.processInput(city, day)
        Mockito.verify(view).printResult(results)
    }
}
