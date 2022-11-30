//package tests
//
//
//import configs.*
//import helpers.DateFormatChanger
//import helpers.sign
//import lists.*
//import org.testng.annotations.Test
//import pages.*
//import java.lang.Thread.sleep
//import kotlin.test.assertEquals
//
//
//var additionalAssignmentDeadline = ""
//
//class CreateAdditionalAssignment (private var assert:Boolean = true) {
//    private val assignmentCardPage = AssignmentCardPage()
//    private val assignmentProjectCardPage = AssignmentProjectCardPage()
//
//
//    @Test
//    fun createAdditionalAssignmentTest() {
//        CreateAssignment(false).createAssignmentTest()
//        org1Registrar1.page.click(assignmentCardPage.createAdditionalAssignment_btn)
//
//        org1Registrar1.page.click(assignmentCardPage.region_dropdown)
//        org1Registrar1.page.click(assignmentCardPage.country)
//        org1Registrar1.page.click(assignmentCardPage.adresat_dropdown)
//        org1Registrar1.page.click(assignmentCardPage.adresat)
//
//        org1Registrar1.page.click(assignmentCardPage.addCoExecutor_text)
//
//        org1Registrar1.page.click(assignmentCardPage.region2_dropdown)
//        org1Registrar1.page.click(assignmentCardPage.country2)
//        org1Registrar1.page.click(assignmentCardPage.adresat2_dropdown)
//        org1Registrar1.page.click(assignmentCardPage.adresat2)
//
//        org1Registrar1.page.click(assignmentCardPage.deadline_input)
//        org1Registrar1.page.click(assignmentCardPage.changeMonth_btn)
//        org1Registrar1.page.click(assignmentCardPage.date_btn)
//        additionalAssignmentDeadline = org1Registrar1.page.inputValue(assignmentCardPage.deadline_input)
//
//        org1Registrar1.page.click(assignmentCardPage.appointSigner_text)
//        org1Registrar1.page.click(assignmentCardPage.approvers_dropdown)
//        org1Registrar1.page.click(assignmentCardPage.approver)
//        org1Registrar1.page.click(assignmentCardPage.send_btn)
//
//        org1Registrar1.page.click(assignmentCardPage.approveAdditionalAssignment_btn)
//        org1Registrar1.page.click(assignmentCardPage.approve_btn_popup)
//        org1Registrar1.page.click(assignmentCardPage.sign_btn)
//        org1Registrar1.page.click(assignmentCardPage.NUTS_btn)
//
//        sign()
//
//        sleep(1000)
//        org1Registrar1.page.click(assignmentProjectCardPage.checked_btn)
//        org1Registrar1.page.click(assignmentProjectCardPage.confirm_btn)
//
//        if (assert) {
//            assertEquals(DateFormatChanger().dateFormatChange(org1Registrar1.page.innerText(assignmentCardPage.additionalAssignmentDeadline)), additionalAssignmentDeadline)
//            assertEquals(org1Registrar1.page.innerText(assignmentCardPage.statusAdditionalAssignmentCreated), statusAdditionalAssignmentCreated)
//            assertEquals(org1Registrar1.page.innerText(assignmentCardPage.statusAdditionalAssignmentApproved), statusAdditionalAssignmentApproved)
//            assertEquals(org1Registrar1.page.innerText(assignmentCardPage.statusAdditionalAssignmentSigned), statusAdditionalAssignmentSigned)
//        }
//    }
//}
