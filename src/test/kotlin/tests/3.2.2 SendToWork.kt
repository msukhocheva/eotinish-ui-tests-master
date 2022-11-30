package tests

import helpers.createAppealInDB
import helpers.switchOnUser
import org.testng.annotations.Test
import kotlin.test.assertEquals
import lists.*
import pages.*

class SendToWorkByRegistrarToExecutor(private var assert: Boolean = true) {
    private val asideToggle = AsideToggle()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val inWorkAppealsListPage = InWorkAppealsListPage()
    private val appealCardPage = AppealCardPage()


    @Test
    fun sendToWorkTest() {
        switchOnUser(org1Registrar1)
        val appealTypeName = listOfAppealTypes[0]
        val appealNumber = createAppealInDB(appealTypeName)

        org1Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org1Registrar1.page.click(asideToggle.registeredAppeals)
        org1Registrar1.page.click(asideToggle.asideToggleFix_btn)

        org1Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
        org1Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Registrar1.page.keyboard().press(enter_btn)

        org1Registrar1.page.click(registeredAppealsListPage.firstAppealInList)
        org1Registrar1.page.click(appealCardPage.sendToWork_btn)
        org1Registrar1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Registrar1.page.click(appealCardPage.org1_Executor1)
        org1Registrar1.page.click(appealCardPage.appoint_btn)
        org1Registrar1.page.waitForSelector(appealCardPage.statusSendToWorkFromReg1ToExec1Text)

        switchOnUser(org1Executor1)

        org1Executor1.page.click(asideToggle.asideToggleFix_btn)
        org1Executor1.page.click(asideToggle.incomingTasks)
        org1Executor1.page.click(asideToggle.inWork)
        org1Executor1.page.click(asideToggle.asideToggleFix_btn)
        org1Executor1.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Executor1.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Executor1.page.keyboard().press(enter_btn)
        if (!org1Executor1.page.isVisible(inWorkAppealsListPage.appealInList)){
            org1Executor1.page.reload()
        }
        org1Executor1.page.click(inWorkAppealsListPage.appealInList)

        if (assert) {
            assertEquals(org1Executor1.page.innerText(appealCardPage.cardHead_text), "$appealTypeName №ЖТ-2022-$appealNumber")
            println("Test 3.2.2   passed ($appealTypeName ЖТ-2022-$appealNumber)")
        }
    }
}