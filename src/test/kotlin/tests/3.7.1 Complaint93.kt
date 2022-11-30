package tests

import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import helpers.*
import lists.*
import pages.*



class Complaint93TSON (private var assert: Boolean = true, private var appealType: String = listOfComplaintTypes[0]) {
    private val appealCardPage = AppealCardPage()
    private val asideToggle = AsideToggle()
    private val inWorkAppealsListPage = InWorkAppealsListPage()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val appealsRegistryTsonPage = AppealsRegistryTsonPage()
    private val typesOfCreatedAppeals = mutableListOf<String>()
    private val regNumbersOfCreatedAppeals = mutableListOf<String>()


    @Test
    fun complaint93TSONTest() {
        for (i in listOfComplaintTypes.indices) {

            //Создаем Жалобу Регистратором
            switchOnUser(org1Registrar1)
            org1Registrar1.page.bringToFront()
            val complaintTypeName = listOfComplaintTypes[i]
            val complaintNumber = createAppealInDB(complaintTypeName)

            //Открываем боковое меню, открываем вкладку "Зарегистрированы и ожидают маршрутизации", закрываем боковое меню
            org1Registrar1.page.click(asideToggle.asideToggleFix_btn)
            org1Registrar1.page.click(asideToggle.registeredAppeals)
            org1Registrar1.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер жалобы, ищем и открываем его
            org1Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
            org1Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, complaintNumber.substring(3))
            org1Registrar1.page.keyboard().press(enter_btn)
            org1Registrar1.page.click(registeredAppealsListPage.firstAppealInList)

            //Нажимаем кнопку "Направить в работу", выбираем Исполнителя и направляем ему в работу
            org1Registrar1.page.click(appealCardPage.sendToWork_btn)
            org1Registrar1.page.click(appealCardPage.responsibleSpecialist_dropdown)
            org1Registrar1.page.click(appealCardPage.org1_Executor1)
            org1Registrar1.page.click(appealCardPage.appoint_btn)
            typesOfCreatedAppeals.add(complaintTypeName)
            regNumbersOfCreatedAppeals.add(complaintNumber)
        }

        //Проверяем залогинен ли Исполнитель, если нет, то логинимся под ним,
        switchOnUser(org1Executor1)

        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем боковое меню, открываем вкладку "Находятся в работе", закрываем боковое меню
            org1Executor1.page.click(asideToggle.asideToggleFix_btn)
            org1Executor1.page.click(asideToggle.incomingTasks)
            org1Executor1.page.click(asideToggle.inWork)
            org1Executor1.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер жалобы, ищем и открываем его
            org1Executor1.page.click(inWorkAppealsListPage.appealsSearch_input)
            org1Executor1.page.fill(inWorkAppealsListPage.appealsSearch_input, regNumbersOfCreatedAppeals[i].substring(3))
            org1Executor1.page.keyboard().press(enter_btn)
            org1Executor1.page.click(inWorkAppealsListPage.appealInList)

            //Нажимаем кнопку "Не соответствует статье 93", выбираем причину и указываем срок
            org1Executor1.page.click(appealCardPage.complaint93)
            org1Executor1.page.fill(appealCardPage.complaint93Reasons_input, appeal93Reason)
            org1Executor1.page.click(appealCardPage.complaint93Deadline_input)
            org1Executor1.page.locator(appealCardPage.complaint93Deadline_input).evaluate(appealCardPage.removeReadonly)
            org1Executor1.page.fill(appealCardPage.complaint93Deadline_input, Dates().getNextWorkingDateFromToday())
            org1Executor1.page.keyboard().press(enter_btn)
            org1Executor1.page.click(appealCardPage.sendNotice93_btn)
        }

        //Проверяем залогинен ли Оператор ЦОНа, если нет, то логинимся под ним,
        TSONOperator.page.bringToFront()
        if (!TSONOperator.page.isVisible(asideToggle.asideToggleFix_btn)) {
            Login(TSONOperator, false).loginTest()
        }

        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем боковое меню, открываем вкладку "Реестр обращений", закрываем боковое меню
            TSONOperator.page.click(asideToggle.asideToggleFix_btn)
            TSONOperator.page.click(asideToggle.TSONAppealRegistry)
            TSONOperator.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер жалобы, ищем и открываем его
            TSONOperator.page.click(appealsRegistryTsonPage.appealsSearchTSON_input)
            TSONOperator.page.fill(appealsRegistryTsonPage.appealsSearchTSON_input, regNumbersOfCreatedAppeals[i])
            TSONOperator.page.keyboard().press(enter_btn)
            TSONOperator.page.click(appealsRegistryTsonPage.appealInListTSON)

            //Нажимаем кнопку "Дополнить данные", заполняем новыми данными, отправляем и подписываем
            TSONOperator.page.click(appealCardPage.addAdditionalData_btn)
            TSONOperator.page.fill(appealCardPage.additionalData_input, aligned)
            TSONOperator.page.click(appealCardPage.sendAppeal_btn)
            TSONOperator.page.click(appealCardPage.NUTS_btn)

            sign()
        }

        //Проверяем залогинен ли Исполнитель, если нет, то логинимся под ним,
        switchOnUser(org1Executor1)

        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем боковое меню, открываем вкладку "Находятся в работе", закрываем боковое меню
            org1Executor1.page.click(asideToggle.asideToggleFix_btn)
            org1Executor1.page.click(asideToggle.incomingTasks)
            org1Executor1.page.click(asideToggle.inWork)
            org1Executor1.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер жалобы, ищем и открываем его
            org1Executor1.page.click(inWorkAppealsListPage.appealsSearch_input)
            org1Executor1.page.fill(inWorkAppealsListPage.appealsSearch_input, regNumbersOfCreatedAppeals[i].substring(3))
            org1Executor1.page.keyboard().press(enter_btn)
            if (!org1Executor1.page.isVisible(inWorkAppealsListPage.appealInList)){
                org1Executor1.page.reload()
            }
            org1Executor1.page.click(inWorkAppealsListPage.appealInList)
            org1Executor1.page.mouse().wheel(0.0, 1000.0)

            //Убеждаемся что отображается статус "Приведено в соответствие" и кнопка "Принять решение"
            if (assert) {
                org1Executor1.page.waitForSelector(appealCardPage.statusAligned)
                assertEquals(org1Executor1.page.innerText(appealCardPage.statusAligned), statusAppealAligned)
                assertTrue(org1Executor1.page.isVisible("text=$aligned")
                )
                org1Executor1.page.waitForSelector(appealCardPage.takeDecision_btn)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.takeDecision_btn))
            }
        }


        if (assert) {
            println("Test 3.7.1   passed (${typesOfCreatedAppeals[0]}, ЖТ-2022-${regNumbersOfCreatedAppeals[0]})")
            for (i in 1 until typesOfCreatedAppeals.size) {
                println("                    (${typesOfCreatedAppeals[i]}, ЖТ-2022-${regNumbersOfCreatedAppeals[i]})")

            }
        }
    }
}
