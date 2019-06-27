package weather.mvp

import weather.mvp.ui.main.WeatherInfoView
import java.util.*

fun main() {
    val view = WeatherInfoView()
    val running = true
    val scanner = Scanner(System.`in`)

    while(running){
        println("Input the name of the city: ")
        val city = scanner.nextLine()

        println("Input the start day:")
        val date = scanner.nextLine()

        println("")
        view.onSubmit(city, date)
    }

    view.onDestroy()

}
