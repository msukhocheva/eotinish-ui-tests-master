package tests

import org.testng.annotations.Test
import kotlin.test.assertEquals
import helpers.*
import lists.*
import pages.*


class SendToWorkByRegistrarToChief(private var assert: Boolean = true) {
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
        org1Registrar1.page.click(appealCardPage.org1_Chief1)
        org1Registrar1.page.click(appealCardPage.appoint_btn)
        org1Registrar1.page.waitForSelector(appealCardPage.statusSendToWorkFromReg1ToChief1Text)

        switchOnUser(org1Chief1)

        org1Chief1.page.click(asideToggle.asideToggleFix_btn)
        org1Chief1.page.click(asideToggle.incomingTasks)
        org1Chief1.page.click(asideToggle.inWork)
        org1Chief1.page.click(asideToggle.asideToggleFix_btn)
        org1Chief1.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Chief1.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Chief1.page.keyboard().press(enter_btn)
        if (!org1Chief1.page.isVisible(inWorkAppealsListPage.appealInList)){
            org1Chief1.page.reload()
        }
        org1Chief1.page.click(inWorkAppealsListPage.appealInList)

        if (assert) {
            assertEquals(org1Chief1.page.innerText(appealCardPage.cardHead_text), "$appealTypeName ???????-2022-$appealNumber")
            println("Test 3.2.1   passed ($$appealTypeName ????-2022-$appealNumber)")
        }
    }
}