package weather.mvp.data.specs.filter

import weather.mvp.data.specs.Specification

interface FilterSpecification<T> : Specification {

    fun filter(weathers: List<T>, vararg keyword: String): List<T>

}