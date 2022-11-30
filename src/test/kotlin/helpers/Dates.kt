package helpers

import lists.holidays
import lists.listOfAppealAndComplaintDeadlines
import lists.listOfAppealTypes
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*


class Dates {
    private var calendar = getInstance()

    private val sdfFullDate = SimpleDateFormat("yyyy-MM-dd 03:01:00.000")
    private val sdfDate = SimpleDateFormat("dd-MM-yyyy")
    private val sdfTime = SimpleDateFormat("HH:mm:ss")

    private val currentTimeString = sdfTime.format(calendar.time)
    private val workEndTimeString = "18:29:59"
    private val currentTime = sdfTime.parse(currentTimeString)
    private val workEndTime = sdfTime.parse(workEndTimeString)


    fun calculateAppealDeadline(appealType: String? = listOfAppealTypes[0]) : String {
        if (currentTime.after(workEndTime)) {
            calendar.add(DAY_OF_YEAR,1)
        }

        val deadline: String

        if (appealType == listOfAppealTypes[1] || appealType == listOfAppealTypes[2] || appealType == listOfAppealTypes[4] || appealType == listOfAppealTypes[8]) {
            deadline = getDateWithHolidays(listOfAppealAndComplaintDeadlines.getValue(appealType))
        } else {
            deadline = getDateWithoutHolidays(listOfAppealAndComplaintDeadlines.getValue(appealType!!))
        }
        return ("до ${dateFormatChange(deadline)}")
    }

    private fun getDateWithHolidays(days: Int) : String {
        for (i in 1 until days) {
            calendar.add(DAY_OF_YEAR, 1)
        }
        while (holidays.contains(sdfDate.format(calendar.time))) {
            calendar.add(DAY_OF_YEAR,1)
        }
        return sdfDate.format(calendar.time)
    }

    private fun getDateWithoutHolidays(days: Int) : String {
        var deadline = days
        for (i in 1 until deadline) {
            calendar.add(DAY_OF_YEAR, 1)
            if (holidays.contains(sdfDate.format(calendar.time))) {
                deadline += 1
            }
        }
        return sdfDate.format(calendar.time)
    }

    fun getStartDate() : String {
        while (holidays.contains(sdfDate.format(calendar.time))) {
            calendar.add(DAY_OF_YEAR,1)
        }
        if (currentTime.after(workEndTime)) {
            calendar.add(DAY_OF_YEAR,1)
        }
        return sdfFullDate.format(calendar.time)
    }

    fun transformDate(deadlineString: String) : String {
        val deadline = dateFormatChange(deadlineString.substring(3))
        val parseDeadline = sdfDate.parse(deadline)

        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
        return sdf.format(parseDeadline)
    }

    fun getNextWorkingDateFromToday() : String{
        calendar.add(DAY_OF_YEAR,1)
        while (holidays.contains(sdfDate.format(calendar.time))) {
            calendar.add(DAY_OF_YEAR,1)
        }
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        return sdf.format(calendar.time)
    }


    fun getNextWorkingDateFromDeadline(appealType: String?) : String {
        val deadline: String = Dates().calculateAppealDeadline(appealType).substring(3)
        val parseDeadline = sdfDate.parse(dateFormatChange(deadline))
        calendar.time = parseDeadline
        calendar.add(DAY_OF_YEAR,1)
        while (holidays.contains(sdfDate.format(calendar.time))) {
            calendar.add(DAY_OF_YEAR,1)
        }
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(calendar.time)
    }

    fun dateFormatChange (date: String) : String {
        return when {
            date.contains("/") -> date.replace("/", "-")
            date.contains(".") -> date.replace(".", "-")
            date.contains("-") -> date.replace("-", ".")
            else -> date
        }
    }

    fun getCurrentDate() : String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
        sdf.timeZone = TimeZone.getTimeZone("GMT 0:00")
        return sdf.format(Date())
    }
}
