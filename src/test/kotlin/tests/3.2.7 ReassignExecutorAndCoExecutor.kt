package tests


import helpers.createAppealInDB
import helpers.switchOnUser
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import lists.*
import pages.*
import java.lang.Thread.sleep


class ReassignExecutorAndCoExecutor(private var assert: Boolean = true) {
    private val asideToggle = AsideToggle()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val inWorkAppealsListPage = InWorkAppealsListPage()
    private val appealCardPage = AppealCardPage()


    @Test
    fun reassignExecutorAndCoExecutor() {
        //Создаем новое обращение Регистратором и направляем его в работу Руководителю
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

        //Проверяем залогинен ли Руководитель, если нет, то логинимся под ним и направляем в работу Исполнителю-1 и Исполнителю-2(Соисполнителю-1)
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


        //Проверяем залогинен ли Исполнитель-1, если нет, то логинимся под ним и проверяем есть ли обращение
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
        }

        //Проверяем залогинен ли Исполнитель-2(Соисполнитель-1), если нет, то логинимся под ним и проверяем есть ли обращение
        switchOnUser(org1Executor2)

        org1Executor2.page.click(asideToggle.asideToggleFix_btn)
        org1Executor2.page.click(asideToggle.incomingTasks)
        org1Executor2.page.click(asideToggle.inWork)
        org1Executor2.page.click(asideToggle.asideToggleFix_btn)
        org1Executor2.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Executor2.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Executor2.page.keyboard().press(enter_btn)
        org1Executor2.page.click(inWorkAppealsListPage.appealInList)
        sleep(1000)
        org1Executor2.page.mouse().wheel(0.0, 1000.0)
        sleep(1000)

        if (assert) {
            assertEquals(org1Executor2.page.innerText(appealCardPage.cardHead_text), "$appealTypeName №ЖТ-2022-$appealNumber")
            assertTrue(org1Executor2.page.isVisible(appealCardPage.coExecutorsComment_btn))
        }

        //Проверяем залогинен ли Руководитель, если нет, то логинимся под ним и направляем в работу Исполнителю-3 и Исполнителю-4(Соисполнителю-2)
        switchOnUser(org1Chief1)

        org1Chief1.page.click(asideToggle.asideToggleFix_btn)
        org1Chief1.page.click(asideToggle.AUTOTESTORG1)
        org1Chief1.page.click(asideToggle.allAppeals)
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
        org1Chief1.page.click(appealCardPage.org1_Executor3)

        org1Chief1.page.click(appealCardPage.deleteCoExecutor_btn)

        org1Chief1.page.click(appealCardPage.addCoExecutor)

        org1Chief1.page.click(appealCardPage.coExecutorOrg_dropdown)
        org1Chief1.page.click(appealCardPage.org1)
        org1Chief1.page.click(appealCardPage.coExecutor_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor4)

        org1Chief1.page.click(appealCardPage.appoint_btn)
        org1Chief1.page.waitForSelector(appealCardPage.statusSendToWorkFromChief1ToExec1AndExec3Text)

        //Проверяем залогинен ли Исполнитель-3, если нет, то логинимся под ним и проверяем есть ли обращение
        switchOnUser(org1Executor3)

        org1Executor3.page.click(asideToggle.asideToggleFix_btn)
        org1Executor3.page.click(asideToggle.incomingTasks)
        org1Executor3.page.click(asideToggle.inWork)
        org1Executor3.page.click(asideToggle.asideToggleFix_btn)
        org1Executor3.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Executor3.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Executor3.page.keyboard().press(enter_btn)
        if (!org1Executor3.page.isVisible(inWorkAppealsListPage.appealInList)){
            org1Executor3.page.reload()
        }
        org1Executor3.page.click(inWorkAppealsListPage.appealInList)

        if (assert) {
            assertEquals(org1Executor3.page.innerText(appealCardPage.cardHead_text), "$appealTypeName №ЖТ-2022-$appealNumber")
        }

        //Проверяем залогинен ли Исполнитель-4(Соисполнитель-2), если нет, то логинимся под ним и проверяем есть ли обращение
        switchOnUser(org1Executor4)

        org1Executor4.page.click(asideToggle.asideToggleFix_btn)
        org1Executor4.page.click(asideToggle.incomingTasks)
        org1Executor4.page.click(asideToggle.inWork)
        org1Executor4.page.click(asideToggle.asideToggleFix_btn)
        org1Executor4.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Executor4.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Executor4.page.keyboard().press(enter_btn)
        if (!org1Executor4.page.isVisible(inWorkAppealsListPage.appealInList)){
            org1Executor4.page.reload()
        }
        org1Executor4.page.click(inWorkAppealsListPage.appealInList)

        if (assert) {
            assertEquals(org1Executor4.page.innerText(appealCardPage.cardHead_text), "$appealTypeName №ЖТ-2022-$appealNumber")
            assertTrue(org1Executor4.page.isVisible(appealCardPage.coExecutorsComment_btn))
            println("Test 3.2.7   passed ($appealTypeName ЖТ-2022-$appealNumber)")
        }
    }
}