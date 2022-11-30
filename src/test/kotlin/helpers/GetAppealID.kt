package helpers

import org.testng.annotations.Test
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class GetAppealID {

    fun getRandomId() : String  = UUID.randomUUID().toString()


    fun getAppealAndTicketNumbers(): List<String> {
        val fileName = "src/test/java/tests/Appeal"
        val file = File(fileName)
        val prefix = "ЖТ-2022"
        val lastNumber = file.readText().toInt() + 1
        val counter = lastNumber.toString().padStart(8, '0')
        file.writeText(counter.trimStart('0'))
        val appealNumber = "$prefix-$counter"

        val calendar = Calendar.getInstance()
        val currentDate = SimpleDateFormat("yyMMdd").format(calendar.time)
        val ticketNumber = "$currentDate$counter".replaceFirst("2", "5")

        return listOf(appealNumber, ticketNumber)
    }


    @Test
    fun test() {
        println(getRandomId())
        val list = getAppealAndTicketNumbers()
        println(list[0])
        println(list[1])
    }
}