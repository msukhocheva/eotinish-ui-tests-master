package tests


import helpers.createAppealInDB
import helpers.switchOnUser
import org.testng.annotations.Test
import kotlin.test.assertTrue
import lists.*
import pages.*


class CancelAllResolutions (private var assert: Boolean = true) {
    private val asideToggle = AsideToggle()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val inWorkAppealsListPage = InWorkAppealsListPage()
    private val appealCardPage = AppealCardPage()


    @Test
    fun cancelAllResolutions() {
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

        org1Chief1.page.click(appealCardPage.sendToWork_btn)
        org1Chief1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor1)
        org1Chief1.page.click(appealCardPage.addCoExecutor)

        org1Chief1.page.click(appealCardPage.coExecutorOrg_dropdown)
        org1Chief1.page.click(appealCardPage.org1)
        org1Chief1.page.click(appealCardPage.coExecutor_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor2)

        org1Chief1.page.click(appealCardPage.appoint_btn)
        org1Chief1.page.waitForSelector(appealCardPage.statusSendToWorkFromChief1ToExec1AndExec2Text)


        org1Registrar1.page.bringToFront()
        if (!org1Registrar1.page.isVisible(asideToggle.asideToggleFix_btn)) {
            Login(org1Registrar1,false).loginTest()
        }
        org1Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org1Registrar1.page.click(asideToggle.onExecution)
        org1Registrar1.page.click(asideToggle.asideToggleFix_btn)

        org1Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
        org1Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Registrar1.page.keyboard().press(enter_btn)

        org1Registrar1.page.click(registeredAppealsListPage.firstAppealInList)

        org1Registrar1.page.click(appealCardPage.changeExecutor)
        org1Registrar1.page.click(appealCardPage.newStructuralSubdivision_dropdown)
        org1Registrar1.page.click(appealCardPage.org1)
        org1Registrar1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Registrar1.page.click(appealCardPage.org1_Executor3)
        org1Registrar1.page.click(appealCardPage.appoint_btn)
        org1Registrar1.page.waitForSelector(appealCardPage.statusSendToWorkFromReg1ToChief1Text)


        switchOnUser(org1Executor1)

        org1Executor1.page.click(asideToggle.asideToggleFix_btn)
        org1Executor1.page.click(asideToggle.incomingTasks)
        org1Executor1.page.click(asideToggle.inWork)
        org1Executor1.page.click(asideToggle.asideToggleFix_btn)
        org1Executor1.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Executor1.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Executor1.page.keyboard().press(enter_btn)
        org1Executor1.page.reload()
        org1Executor1.page.keyboard().press(enter_btn)
        if (assert) {
            assertTrue(!org1Executor1.page.isVisible(inWorkAppealsListPage.appealInList))
        }

        switchOnUser(org1Executor2)

        org1Executor2.page.click(asideToggle.asideToggleFix_btn)
        org1Executor2.page.click(asideToggle.incomingTasks)
        org1Executor2.page.click(asideToggle.inWork)
        org1Executor2.page.click(asideToggle.asideToggleFix_btn)
        org1Executor2.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Executor2.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Executor2.page.keyboard().press(enter_btn)
        org1Executor2.page.reload()
        org1Executor2.page.keyboard().press(enter_btn)
        if (assert) {
            assertTrue(!org1Executor2.page.isVisible(inWorkAppealsListPage.appealInList))
            println("Test 3.2.8   passed ($appealTypeName ЖТ-2022-$appealNumber)")
        }
    }
}