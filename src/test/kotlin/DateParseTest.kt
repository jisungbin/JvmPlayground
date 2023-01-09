@file:Suppress("NonAsciiCharacters")

import java.util.Calendar
import kotlin.test.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.withNotNull
import util.buildDate

class DateParseTest {
    @Test
    fun `오전 시간`() {
        val dateString = "2021-12-25 18:52:27"
        val actual = dateFormatter.parse(dateString)
        val expected = buildDate(
            year = 2021,
            month = 11,
            day = 25,
            hour = 18,
            minute = 52,
            second = 27,
        )

        expectThat(actual).withNotNull {
            val expectCal = Calendar.getInstance().apply { time = subject }
            val actualCal = Calendar.getInstance().apply { time = expected }

            get { expectCal.get(Calendar.YEAR) } isEqualTo actualCal.get(Calendar.YEAR)
            get { expectCal.get(Calendar.DAY_OF_YEAR) } isEqualTo actualCal.get(Calendar.DAY_OF_YEAR)
            get { expectCal.get(Calendar.HOUR_OF_DAY) } isEqualTo actualCal.get(Calendar.HOUR_OF_DAY)
            get { expectCal.get(Calendar.MINUTE) } isEqualTo actualCal.get(Calendar.MINUTE)
            get { expectCal.get(Calendar.SECOND) } isEqualTo actualCal.get(Calendar.SECOND)
            get { expectCal.get(Calendar.MILLISECOND) } isEqualTo actualCal.get(Calendar.MILLISECOND)
        }
    }

    @Test
    fun `오후 시간`() {
        val dateString = "2021-12-25 8:52:27"
        val actual = dateFormatter.parse(dateString)
        val expect = buildDate(
            year = 2021,
            month = 11,
            day = 25,
            hour = 8,
            minute = 52,
            second = 27,
        )

        expectThat(actual).withNotNull {
            val expectCal = Calendar.getInstance().apply { time = subject }
            val actualCal = Calendar.getInstance().apply { time = expect }

            get { expectCal.get(Calendar.YEAR) } isEqualTo actualCal.get(Calendar.YEAR)
            get { expectCal.get(Calendar.DAY_OF_YEAR) } isEqualTo actualCal.get(Calendar.DAY_OF_YEAR)
            get { expectCal.get(Calendar.HOUR_OF_DAY) } isEqualTo actualCal.get(Calendar.HOUR_OF_DAY)
            get { expectCal.get(Calendar.MINUTE) } isEqualTo actualCal.get(Calendar.MINUTE)
            get { expectCal.get(Calendar.SECOND) } isEqualTo actualCal.get(Calendar.SECOND)
            get { expectCal.get(Calendar.MILLISECOND) } isEqualTo actualCal.get(Calendar.MILLISECOND)
        }
    }
}