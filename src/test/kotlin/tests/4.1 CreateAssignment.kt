package tests


import pages.*
import helpers.*
import lists.*
import okhttp3.internal.trimSubstring
import org.testng.annotations.Test
import java.lang.Thread.sleep
import kotlin.test.assertEquals


var assignmentDeadline = ""
var assignmentNumber = ""

class CreateAssignmentByRegistrar (private var assert:Boolean = true) {
    private val appealCardPage = AppealCardPage()
    private val asideToggle = AsideToggle()
    private val allOutgoingAssignmentsPage = AllOutgoingAssignmentsPage()
    private val waitingForCheckAssignmentsPage = WaitingForCheckAssignmentsPage()
    private val assignmentProjectCardPage = AssignmentProjectCardPage()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val assignmentCardPage = AssignmentCardPage()


    @Test
    fun createAssignmentByRegistrarTest() {
        //Логинимся под Регистратором и создаем обращение
        switchOnUser(org1Registrar1)
        val appealTypeName = listOfAppealTypes[0]
        val appealNumber = createAppealInDB(appealTypeName)

        //Находим созданное обращение во вкладке "Зарегистрированы и ожидают маршрутизации" и открываем его
        org1Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org1Registrar1.page.click(asideToggle.registeredAppeals)
        org1Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org1Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
        org1Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Registrar1.page.keyboard().press(enter_btn)
        org1Registrar1.page.click(registeredAppealsListPage.firstAppealInList)

        //Нажимаем кнопку "Поручение/запрос в другой ГО" и назначаем ГО-исполнителя Org.2 и ГО-соисполнителя Org.3
        org1Registrar1.page.click(appealCardPage.createAssignment_btn)
        org1Registrar1.page.click(appealCardPage.region_dropdown)
        org1Registrar1.page.click(appealCardPage.country)
        org1Registrar1.page.click(appealCardPage.adresat_dropdown)
        org1Registrar1.page.click(appealCardPage.org2)

        org1Registrar1.page.click(appealCardPage.addCoExecutor_text)

        org1Registrar1.page.click(appealCardPage.region2_dropdown)
        org1Registrar1.page.click(appealCardPage.country2)
        org1Registrar1.page.click(appealCardPage.adresat2_dropdown)
        org1Registrar1.page.click(appealCardPage.org3)

        //Указываем срок исполнения
        org1Registrar1.page.click(appealCardPage.deadline_input)
        org1Registrar1.page.locator(appealCardPage.deadline_input).evaluate(appealCardPage.removeReadonly)
        org1Registrar1.page.fill(appealCardPage.deadline_input, Dates().getNextWorkingDateFromToday())
        org1Registrar1.page.keyboard().press(enter_btn)
        assignmentDeadline = org1Registrar1.page.inputValue(appealCardPage.deadline_input)

        //Выбираем согласующих, подписанта, ответственного сотрудника и отправляем
        org1Registrar1.page.click(appealCardPage.signer_dropdown)
        org1Registrar1.page.click(appealCardPage.signer)
        org1Registrar1.page.click(appealCardPage.approvers_dropdown)
        org1Registrar1.page.click(appealCardPage.approver)
        org1Registrar1.page.click(appealCardPage.responsibleWorker_dropdown)
        org1Registrar1.page.click(appealCardPage.responsibleWorker)
        org1Registrar1.page.click(appealCardPage.send_btn)

        //Логинимся под Руководителем
        switchOnUser(org1Chief1)
        org1Chief1.page.bringToFront()

        //Открываем поручение во вкладке "Исходящие поручения" -> "Все исходящие"
        org1Chief1.page.click(asideToggle.asideToggleFix_btn)
        org1Chief1.page.click(asideToggle.outgoingAssignments)
        org1Chief1.page.waitForNavigation { org1Chief1.page.click(asideToggle.allOutgoingAssignments) }
        org1Chief1.page.click(asideToggle.asideToggleFix_btn)
        org1Chief1.page.click(allOutgoingAssignmentsPage.assignmentSearch_input)
        org1Chief1.page.fill(allOutgoingAssignmentsPage.assignmentSearch_input, appealNumber.substring(3))
        org1Chief1.page.keyboard().press(enter_btn)
        org1Chief1.page.click(allOutgoingAssignmentsPage.firstAssignmentInList)

        //Нажимаем кнопку "Согласовать", "Подписать", согласовываем и подписываем поручение
        org1Chief1.page.click(assignmentProjectCardPage.approve_btn)
        org1Chief1.page.click(assignmentProjectCardPage.approve_btn_popup)
        org1Chief1.page.click(assignmentProjectCardPage.sign_btn)
        org1Chief1.page.click(assignmentProjectCardPage.NUTS_btn)

        sign()

        if (assert) {
            assertEquals(org1Chief1.page.innerText(assignmentCardPage.statusAssignmentSigned), statusAssignmentSigned)
        }

        //Логинимся под Контролером
        switchOnUser(org1Controller1)
        org1Controller1.page.bringToFront()

        //Открываем поручение во вкладке "Поручения" -> "Ожидают проверки"
        org1Controller1.page.click(asideToggle.asideToggleFix_btn)
        org1Controller1.page.click(asideToggle.assignments)
        org1Controller1.page.waitForNavigation { org1Controller1.page.click(asideToggle.waitingForCheckAssignments) }
        org1Controller1.page.click(asideToggle.asideToggleFix_btn)
        org1Controller1.page.click(waitingForCheckAssignmentsPage.assignmentSearch_input)
        org1Controller1.page.fill(waitingForCheckAssignmentsPage.assignmentSearch_input, appealNumber.substring(3))
        org1Controller1.page.keyboard().press(enter_btn)
        while (!org1Controller1.page.isVisible(waitingForCheckAssignmentsPage.firstAssignmentInList)){
            org1Controller1.page.click(asideToggle.asideToggleFix_btn)
            org1Controller1.page.click(asideToggle.assignments)
            org1Controller1.page.waitForNavigation { org1Controller1.page.click(asideToggle.waitingForCheckAssignments) }
            org1Controller1.page.click(asideToggle.asideToggleFix_btn)
            org1Controller1.page.click(waitingForCheckAssignmentsPage.assignmentSearch_input)
            org1Controller1.page.fill(waitingForCheckAssignmentsPage.assignmentSearch_input, appealNumber.substring(3))
            org1Controller1.page.keyboard().press(enter_btn)
            sleep(500)
        }
        org1Controller1.page.click(waitingForCheckAssignmentsPage.firstAssignmentInList)

        //Нажимаем кнопку "Проверено"
        org1Controller1.page.click(assignmentProjectCardPage.checked_btn)
        org1Controller1.page.click(assignmentProjectCardPage.confirm_btn)
        assignmentNumber = org1Controller1.page.innerText(assignmentProjectCardPage.assignmentNumber).trimSubstring(19,29)

        //Проверяем статусы "Создан проект", "Согласован проект", "Подписан проект", "Проверен проект"
        if (assert) {
            assertEquals(Dates().dateFormatChange(org1Controller1.page.innerText(assignmentCardPage.assignmentDeadline)), assignmentDeadline)
            assertEquals(org1Controller1.page.innerText(assignmentCardPage.statusAssignmentCreated), statusAssignmentCreated)
            assertEquals(org1Controller1.page.innerText(assignmentCardPage.statusAssignmentApproved), statusAssignmentApproved)
            assertEquals(org1Controller1.page.innerText(assignmentCardPage.statusAssignmentSigned), statusAssignmentSigned)
            assertEquals(org1Controller1.page.innerText(assignmentCardPage.statusAssignmentChecked), statusAssignmentChecked)
            println("Test 4.1     passed ($appealTypeName ЖТ-2022-$appealNumber)")
        }
    }
}
