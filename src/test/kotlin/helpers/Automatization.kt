package helpers

import lists.listOfAppealTypes
import lists.listOfComplaintTypes
import org.junit.Test
import tests.*

class Automatization {

    @Test
    fun createAllTypeOfAppeals() {
        for (i in listOfAppealTypes) {
            CreateAppealByRegistrar(appealType = i, assert = false).createAppealTest()
            println("$appealTypeName $appealNumber")
        }
    }

    @Test
    fun createAllTypeOfComplaints() {
        for (i in listOfComplaintTypes) {
            CreateComplaintByRegistrar(complaintType = i, assert = false).createComplaintTest()
            println("$complaintTypeName $complaintNumber")
        }
    }
}