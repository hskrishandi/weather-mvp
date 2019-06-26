package weather.mvp.data.model.types

import org.junit.Assert.assertEquals
import org.junit.Test

class DayTest {

    @Test
    fun `given Friday when getting Day enum from name then return FRI`(){
        val day = "Friday"
        assertEquals(Day.FRI, Day.fromName(day))
    }

}