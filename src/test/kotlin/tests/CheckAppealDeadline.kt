package tests



import lists.*
import org.testng.annotations.Test
import java.lang.Thread.sleep
import kotlin.test.assertEquals

var createdAppealsDeadline = mutableListOf<String>()
var partlyForwardedAppealDeadlines = mutableListOf<String>()
var fullyForwardedAppealDeadlines = mutableListOf<String>()

class CheckAppealDeadline {

    @Test
    fun checkAppealDeadlineTest() {
//        for (i in listOfComplainTypes) {
//            CreateComplain(true, i).createComplainTest()
//            SendToWork().sendToWorkTest()
//            Logout(false).logoutTest()
//        }
//
//        for (i in listOfAppealTypes) {
//            CreateAppeal(true, i).createAppealTest()
//            SendToWork().sendToWorkTest()
//            Logout(false).logoutTest()
//        }

//        for (i in listOfComplaintTypes) {
//            ForwardComplain(true, i).forwardComplainTest()
//            Logout(false).logoutTest()
//            sleep(2000)
//        }

//        for (i in listOfAppealTypes) {
//            ForwardAppeal(true, i).forwardAppealTest()
//            Logout(false).logoutTest()
//            sleep(2000)
//        }

        assertEquals(createdAppealsDeadline, partlyForwardedAppealDeadlines)
        assertEquals(partlyForwardedAppealDeadlines, fullyForwardedAppealDeadlines)
        assertEquals(createdAppealsDeadline, fullyForwardedAppealDeadlines)

        println("Сроки по созданным обращениям \n ${createdAppealsDeadline.toString().replace(",", "")} \n")
        println("Сроки по частично переадресованным обращениям \n ${partlyForwardedAppealDeadlines.toString().replace(",", "")} \n")
        println("Сроки по полностью переадресованным обращениям \n ${fullyForwardedAppealDeadlines.toString().replace(",", "")} \n")
    }
}
