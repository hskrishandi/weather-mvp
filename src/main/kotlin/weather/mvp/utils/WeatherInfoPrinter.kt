package weather.mvp.utils

import weather.mvp.data.model.WeatherInfo
import weather.mvp.data.model.types.Day


class WeatherInfoPrinter {

    fun arrangeByCity(weathers: List<WeatherInfo>): Map<String, List<WeatherInfo>> {

        val resultMap = mutableMapOf<String, MutableList<WeatherInfo>>()

        for(weather in weathers){

            val location = weather.location

            if(resultMap.containsKey(location)){

                val weatherList = resultMap[location]

                if(weatherList != null)
                    weatherList.add(weather)
                else
                    resultMap[location] = mutableListOf(weather)
            } else {
                resultMap.put(location, mutableListOf(weather))
            }

        }
        return resultMap
    }

    fun printByCity(weathersOfCity: Map<String, List<WeatherInfo>>) {

        for((city, weathers) in weathersOfCity){
            println(city)
            println("----------")
            println("Day\tWeather\tTemperature")

            for(weather in weathers) {
                print(weather.day)
                print("\t" + weather.weather)
                print("\t" + weather.temperature + " C")
                println("")
            }

            println("")
        }
    }

    fun arrangeByDay(weathers: List<WeatherInfo>): Map<Day, List<WeatherInfo>> {

        val resultMap = mutableMapOf<Day, MutableList<WeatherInfo>>()

        for(weather in weathers){
            val day = weather.day

            if(resultMap.containsKey(day)){
                val weatherList = resultMap[day]

                if(weatherList != null)
                    weatherList.add(weather)
                else
                    resultMap[day] = mutableListOf(weather)
            } else {
                resultMap.put(day, mutableListOf(weather))
            }

        }
        return resultMap
    }

    fun printByDay(citiesOfWeather: Map<Day, List<WeatherInfo>>) {

        for((day, weathers) in citiesOfWeather){
            println(day.day.toUpperCase())
            println("----------")
            println("City\tWeather\tTemperature")

            for(weather in weathers) {
                print(weather.location.substring(0, 5))
                print("\t" + weather.weather)
                print("\t" + weather.temperature + " C")
                println("")
            }
            println("")
        }
    }
}