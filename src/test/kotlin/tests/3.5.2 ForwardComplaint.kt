package tests

import org.testng.annotations.Test
import kotlin.test.assertEquals
import helpers.*
import lists.*
import pages.*


class ForwardComplaint (private var assert: Boolean = true, private var complaintType: String = listOfComplaintTypes[0]) {
    private val appealCardPage = AppealCardPage()
    private val asideToggle = AsideToggle()
    private val inWorkAppealsListPage = InWorkAppealsListPage()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val typesOfCreatedAppeals = mutableListOf<String>()
    private val regNumbersOfCreatedAppeals = mutableListOf<String>()


    @Test
    fun forwardComplaintTest() {
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

            //Нажимаем кнопку "Направить в работу, выбираем Исполнителя и направляем ему в работу"
            org1Registrar1.page.click(appealCardPage.sendToWork_btn)
            org1Registrar1.page.click(appealCardPage.responsibleSpecialist_dropdown)
            org1Registrar1.page.click(appealCardPage.org1_Chief1)
            org1Registrar1.page.click(appealCardPage.appoint_btn)
            typesOfCreatedAppeals.add(complaintTypeName)
            regNumbersOfCreatedAppeals.add(complaintNumber)
        }

        //Проверяем залогинен ли Руководитель, если нет, то логинимся под ним,
        // переадресовываем подготавливаем к частичной переадресации все созданные жалобы и отправляем их на согласование и подписание
            switchOnUser(org1Chief1)

        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем боковое меню, открываем вкладку "Находятся в работе", закрываем боковое меню
            org1Chief1.page.click(asideToggle.asideToggleFix_btn)
            org1Chief1.page.click(asideToggle.incomingTasks)
            org1Chief1.page.click(asideToggle.inWork)
            org1Chief1.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер обращения, ищем и открываем его
            org1Chief1.page.click(inWorkAppealsListPage.appealsSearch_input)
            org1Chief1.page.fill(inWorkAppealsListPage.appealsSearch_input, regNumbersOfCreatedAppeals[i].substring(3))
            org1Chief1.page.keyboard().press(enter_btn)
            if (!org1Chief1.page.isVisible(inWorkAppealsListPage.appealInList)){
                org1Chief1.page.reload()
            }
            org1Chief1.page.click(inWorkAppealsListPage.appealInList)

            //Нажимаем кнопку "Переадресация в другой ГО", выбираем ГО для переадресации, указываем согласующего и подписанта, ставим галочку "Переадресовать в части"
            org1Chief1.page.click(appealCardPage.forward_btn)
            org1Chief1.page.click(appealCardPage.region_dropdown)
            org1Chief1.page.click(appealCardPage.country)
            org1Chief1.page.click(appealCardPage.adresat_dropdown)
            org1Chief1.page.click(appealCardPage.org2)
            org1Chief1.page.click(appealCardPage.approvers_dropdown)
            org1Chief1.page.click(appealCardPage.approver)
            org1Chief1.page.click(appealCardPage.appointMyself_text)
            org1Chief1.page.click(appealCardPage.forwardPartly_checkbox)
            org1Chief1.page.click(appealCardPage.send_btn)

            //Согласовываем и подписываем переадресацию
            org1Chief1.page.click(appealCardPage.approveForwarding_btn)
            org1Chief1.page.click(appealCardPage.approveForwarding_btn_popup)
            org1Chief1.page.click(appealCardPage.signForwarding_btn)
            org1Chief1.page.click(appealCardPage.sign_btn)
            org1Chief1.page.click(appealCardPage.NUTS_btn)

            sign()

            //Проверяем статусы согласования и подписания переадресации, а также срок исполнения в карточке обращения
            if (assert) {
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwarding), statusAppealForwarding)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingApproved), statusAppealForwardingApproved)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingSigned), statusAppealForwardingSigned)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardedPartly), statusAppealForwardedPartly)
                assertEquals(org1Chief1.page.innerText(appealCardPage.deadlineOnExecitorCard), Dates().calculateAppealDeadline(typesOfCreatedAppeals[i]))
            }

            //Нажимаем кнопку "Переадресация в другой ГО", выбираем ГО для переадресации, указываем согласующего и подписанта, ставим галочку "Переадресовать полностью"
            org1Chief1.page.click(appealCardPage.forward_btn)
            org1Chief1.page.click(appealCardPage.region_dropdown)
            org1Chief1.page.click(appealCardPage.country)
            org1Chief1.page.click(appealCardPage.adresat_dropdown)
            org1Chief1.page.click(appealCardPage.org2)
            org1Chief1.page.click(appealCardPage.approvers_dropdown)
            org1Chief1.page.click(appealCardPage.approver)
            org1Chief1.page.click(appealCardPage.appointMyself_text)
            org1Chief1.page.click(appealCardPage.forwardFully_checkbox)
            org1Chief1.page.click(appealCardPage.send_btn)

            //Согласовываем и подписываем переадресацию
            org1Chief1.page.click(appealCardPage.approveForwarding_btn)
            org1Chief1.page.click(appealCardPage.approveForwarding_btn_popup)
            org1Chief1.page.click(appealCardPage.signForwarding_btn)
            org1Chief1.page.click(appealCardPage.sign_btn)
            org1Chief1.page.click(appealCardPage.NUTS_btn)

            sign()

            //Проверяем статусы согласования и подписания переадресации, а также срок исполнения в карточке Жалобы
            if (assert) {
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwarding), statusAppealForwarding)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingApproved), statusAppealForwardingApproved)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingSigned), statusAppealForwardingSigned)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardedFully), statusAppealForwardedFully)
                assertEquals(org1Chief1.page.innerText(appealCardPage.deadlineOnExecitorCard), Dates().calculateAppealDeadline(typesOfCreatedAppeals[i]))
            }
        }

        //Проверяем залогинен ли Регистратор адресата, если нет, то логинимся под ним,
        // проверяем наличие переадресованных жалоб, а также сроки исполнения в карточке Жалобы
        org2Registrar1.page.bringToFront()
        if (!org2Registrar1.page.isVisible(asideToggle.asideToggleFix_btn)) {
            Login(org2Registrar1, false).loginTest()
        }

        for (i in regNumbersOfCreatedAppeals.indices) {

            //Открываем боковое меню, открываем вкладку "Зарегистрированы и ожидают маршрутизации", закрываем боковое меню
            org2Registrar1.page.click(asideToggle.asideToggleFix_btn)
            org2Registrar1.page.click(asideToggle.registeredAppeals)
            org2Registrar1.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер жалобы, ищем и открываем его
            org2Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
            org2Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, regNumbersOfCreatedAppeals[i].substring(3))
            org2Registrar1.page.keyboard().press(enter_btn)
            org2Registrar1.page.click(registeredAppealsListPage.firstAppealInList)

            //Проверяем срок исполнения в карточке жалобы
            if (assert) {
                assertEquals(org2Registrar1.page.innerText(appealCardPage.deadline2), Dates().calculateAppealDeadline(typesOfCreatedAppeals[i]))
            }

            //Открываем боковое меню, открываем вкладку "Зарегистрированы и ожидают маршрутизации", закрываем боковое меню
            org2Registrar1.page.click(asideToggle.asideToggleFix_btn)
            org2Registrar1.page.click(asideToggle.registeredAppeals)
            org2Registrar1.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер жалобы, ищем его и открываем второе по списку с дробью
            org2Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
            org2Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, regNumbersOfCreatedAppeals[i].substring(3))
            org2Registrar1.page.keyboard().press(enter_btn)
            org2Registrar1.page.click(registeredAppealsListPage.secondAppealInList)

            if (assert) {
                assertEquals(org2Registrar1.page.innerText(appealCardPage.deadline2), Dates().calculateAppealDeadline(typesOfCreatedAppeals[i]))
            }
        }

        if (assert) {
            println("Test 3.5.2   passed (${typesOfCreatedAppeals[0]}, ЖТ-2022-${regNumbersOfCreatedAppeals[0]}, ЖТ-2022-${regNumbersOfCreatedAppeals[0]}/1)")
            for (i in 1 until typesOfCreatedAppeals.size) {
                println("                    (${typesOfCreatedAppeals[i]}, ЖТ-2022-${regNumbersOfCreatedAppeals[i]}, ЖТ-2022-${regNumbersOfCreatedAppeals[i]}/1)")
            }
        }
    }
}
