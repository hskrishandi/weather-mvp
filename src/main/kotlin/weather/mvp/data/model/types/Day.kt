package weather.mvp.data.model.types

enum class Day(val day: String){
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),
    SUN("Sunday");

    companion object {
        private val map = Day.values().associateBy(Day::day)
        fun fromName(name: String) = map[name]
    }
}