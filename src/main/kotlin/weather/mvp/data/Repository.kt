package main.kotlin.weather.mvp.data

import main.kotlin.weather.mvp.data.specs.Specification

interface Repository<T> {
    fun add(item: T)

    fun add(iterable: Iterable<T>)

    fun query(specification: Specification, vararg keywords: String): List<T>
}