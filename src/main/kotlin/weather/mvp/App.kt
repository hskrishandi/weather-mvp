package weather.mvp

import weather.mvp.ui.main.WeatherInfoView
import java.util.*

class App {
    private val view = WeatherInfoView()

    fun accept(city: String, day: String){
        view.onSubmit(city, day)
    }

    fun stop(){
        view.onDestroy()
    }
}

fun main() {
    val app = App()
    val running = true
    val scanner = Scanner(System.`in`)

    while(running){
        println("Input the name of the city: ")
        val city = scanner.nextLine()

        println("Input the start day:")
        val date = scanner.nextLine()

        println("")
        app.accept(city, date)
    }

    app.stop()

}
