package weather.mvp.data

import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.specs.Specification
import weather.mvp.data.specs.filter.FilterSpecification

class WeatherInfoListRepository : Repository<WeatherInfo> {

    private val weatherInfos = mutableListOf<WeatherInfo>()

    override fun add(item: WeatherInfo) {
        weatherInfos.add(item)
    }

    override fun add(iterable: Iterable<WeatherInfo>) {
        weatherInfos.addAll(iterable)
    }

    override fun query(specification: Specification?, vararg keywords: String): List<WeatherInfo> {

        if(specification == null) return weatherInfos

        val spec = specification as FilterSpecification<WeatherInfo>

        return spec.filter(weatherInfos, *keywords)

    }

}