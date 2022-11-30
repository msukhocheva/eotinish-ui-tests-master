package tests

import helpers.*
import lists.*
import org.testng.annotations.Test
import pages.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

//Редактирование обращения Исполнителем

class ChangeAppealByExecutor (private var assert: Boolean = true) {
    private val appealCardPage = AppealCardPage()
    private val changeAppealPage = ChangeAppealPage()
    private val inWorkAppealsListPage = InWorkAppealsListPage()
    private val asideToggle = AsideToggle()
    private val registeredAppealsListPage = RegisteredAppealsListPage()

    @Test
    fun changeAppealByExecutorTest() {
        //Создаем обращение Регистратором
        switchOnUser(org1Registrar1)
        val appealNumber = createAppealInDB(ArrayList(listOfAppealAndComplaintDeadlines.keys)[0])

        //Открываем боковое меню, открываем вкладку "Зарегистрированы и ожидают маршрутизации", закрываем боковое меню
        org1Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org1Registrar1.page.click(asideToggle.registeredAppeals)
        org1Registrar1.page.click(asideToggle.asideToggleFix_btn)

        //В поле поиска вставляем номер обращения, ищем и открываем его
        org1Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
        org1Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Registrar1.page.keyboard().press(enter_btn)
        org1Registrar1.page.click(registeredAppealsListPage.firstAppealInList)

        //Направляем в работу Исполнителю
        org1Registrar1.page.click(appealCardPage.sendToWork_btn)
        org1Registrar1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Registrar1.page.click(appealCardPage.org1_Chief1)
        org1Registrar1.page.click(appealCardPage.appoint_btn)
        org1Registrar1.page.waitForSelector(appealCardPage.statusSendToWorkFromReg1ToChief1Text)

        //Переключаемся на Исполнителя, находим обращение и открываем его
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

        //Нажимаем на редактирование обращения, меняем не подписываемые данные (поочередно меняем все виды обращения),
        //после каждого сохраняемся, проверяем изменения и дедлайны
        for (i in listOfAppealAndComplaintDeadlines) {
            org1Chief1.page.click(appealCardPage.editAppeal_btn)
            org1Chief1.page.click(appealCardPage.ok)
            org1Chief1.page.click(changeAppealPage.appealType_dropdown)
            org1Chief1.page.click("text=${i.key}")
            org1Chief1.page.click(changeAppealPage.saveChanges_btn)
            assertEquals(org1Chief1.page.innerText(appealCardPage.deadlineOnExecitorCard), Dates().calculateAppealDeadline(i.key))
        }

        //Нажимаем на редактирование обращения, меняем не подписываемые данные (форма подачи, язык, категорию/подкатегорию),
        //сохраняемся и проверяем изменения
        org1Chief1.page.click(appealCardPage.editAppeal_btn)
        org1Chief1.page.click(appealCardPage.ok)
        org1Chief1.page.click(changeAppealPage.appealForm_dropdown)
        org1Chief1.page.click(electronic)
        org1Chief1.page.click(changeAppealPage.appealLanguage_dropdown)
        org1Chief1.page.click(changeAppealPage.appealLanguage)
        org1Chief1.page.click(changeAppealPage.appealCategoryForExecutor_dropdown)
        org1Chief1.page.click(changeAppealPage.appealCategoryForExecutor)
        org1Chief1.page.click(changeAppealPage.appealCategory1ForExecutor)
        org1Chief1.page.click(changeAppealPage.appealSubCategoryForExecutor_dropdown)
        org1Chief1.page.click(changeAppealPage.appealSubCategoryForExecutor)
        org1Chief1.page.click(changeAppealPage.saveChanges_btn)

        //Продлеваем срок обращения и подписываем продление
        org1Chief1.page.click(appealCardPage.prolongDeadline_btn)
        org1Chief1.page.locator(appealCardPage.dateInput).evaluate(appealCardPage.removeReadonly)
        org1Chief1.page.fill(appealCardPage.dateInput, Dates().getNextWorkingDateFromDeadline(listOfAppealTypes[11]))
        org1Chief1.page.click(appealCardPage.prolongReason_input)
        org1Chief1.page.fill(appealCardPage.prolongReason_input, appealCardPage.prolongReason)
        org1Chief1.page.click(appealCardPage.prolongApprovers_dropdown)
        org1Chief1.page.click(appealCardPage.prolongApprover)
        org1Chief1.page.click(appealCardPage.prolongSigner_dropdown)
        org1Chief1.page.click(appealCardPage.prolongSigner)
        org1Chief1.page.click(appealCardPage.send_btn)
        org1Chief1.page.click(appealCardPage.prolongAppove_btn)
        org1Chief1.page.click(appealCardPage.prolongApproveConfirmation_btn)
        org1Chief1.page.click(appealCardPage.prolongSign_btn)
        org1Chief1.page.click(appealCardPage.NUTS_btn)

        sign()

        //Пытаемся после продления срока изменить вид обращения (не должно давать)
        org1Chief1.page.click(appealCardPage.editAppeal_btn)
        org1Chief1.page.click(appealCardPage.ok)
        org1Chief1.page.click("text=${listOfAppealTypes[11]}")
        org1Chief1.page.click("text=${listOfAppealTypes[1]}")
        org1Chief1.page.click(changeAppealPage.saveChanges_btn)
        assertTrue(org1Chief1.page.isVisible(changeAppealPage.saveChanges_btn))

        if (assert) {
            println("Test 3.8.2   passed (Сообщение, ЖТ-2022-$appealNumber)")
        }
    }
}
