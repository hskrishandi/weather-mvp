package weather.mvp.ui.main

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import weather.mvp.data.WeatherInfoListRepository

class WeatherInfoPresenterTest {

    private val items = weatherList

    @Mock
    private lateinit var view: WeatherInfoPresenter.View

    @Mock
    private lateinit var repo: WeatherInfoListRepository

    private lateinit var presenter: WeatherInfoPresenter


    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = WeatherInfoPresenter(view, repo)
    }

    @Test
    fun `given presenter when presenter onCreate then repo calls add predefined weather items`() {
        presenter.onCreate()
        Mockito.verify(repo).add(items)

    }
}
