package weather.mvp.data

import weather.mvp.data.specs.Specification

interface Repository<T> {
    fun add(item: T)

    fun add(iterable: Iterable<T>)

    fun query(specification: Specification? = null, vararg keywords: String): List<T>
}