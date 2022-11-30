package tests

import helpers.*
import lists.*
import okhttp3.internal.trimSubstring
import pages.*
import org.testng.annotations.Test
import java.lang.Thread.sleep
import kotlin.test.assertTrue

var assignmentInnerDeadlineForExecutor1 = ""
var assignmentInnerDeadlineForExecutor2 = ""


class SendAssignmentToWork1(private var assert: Boolean = true) {
    private val asideToggle = AsideToggle()
    private val waitingForRoutingPage = WaitingForRoutingPage()
    private val assignmentCardPage = AssignmentCardPage()
    private val myTasksPage = MyTasksPage()
    private val onApprovePage = OnApprovePage()

    @Test
    fun sendAssignmentToWorkTest() {

        //Создаем обращение регистратором Org.1 и направляем в работу в Org.2 и в Org.3
        CreateAssignmentByRegistrar(assert = false).createAssignmentByRegistrarTest()

        //Логинимся под регистратором Org.2 и открываем поручение
        switchOnUser(org2Registrar1)
        while (!org2Registrar1.page.isVisible(waitingForRoutingPage.firstAssignmentInList)){
            org2Registrar1.page.click(asideToggle.asideToggleFix_btn)
            org2Registrar1.page.click(asideToggle.incomingAssignments)
            org2Registrar1.page.click(asideToggle.waitingForRouting)
            org2Registrar1.page.click(asideToggle.asideToggleFix_btn)
            org2Registrar1.page.click(waitingForRoutingPage.assignmentSearch_input)
            org2Registrar1.page.fill(waitingForRoutingPage.assignmentSearch_input, assignmentNumber)
            org2Registrar1.page.keyboard().press(enter_btn)
            sleep(500)
        }
        org2Registrar1.page.click(waitingForRoutingPage.firstAssignmentInList)

        //Направляем поручение в работу Исполнителю из Org.2
        org2Registrar1.page.click(assignmentCardPage.sendToWork_btn)
        org2Registrar1.page.click(assignmentCardPage.responsibleExecutor_dropdown)
        org2Registrar1.page.click(assignmentCardPage.org2_Executor1)

        //Направляем поручение в работу Соисполнителю из структурного подразделения в Org.2
        org2Registrar1.page.click(assignmentCardPage.addCoExecutor_btn)
        org2Registrar1.page.click(assignmentCardPage.coExecutor1Org_dropdown)
        org2Registrar1.page.click(assignmentCardPage.coExecutorOrg)
        org2Registrar1.page.click(assignmentCardPage.responsibleCoExecutor1_dropdown)
        org2Registrar1.page.click(assignmentCardPage.org2un1_Executor1)

        //Указываем внутренний срок и нажимаем кнопку "Назначить"
        org2Registrar1.page.click(assignmentCardPage.assignmentInnerDeadline_input)
        org2Registrar1.page.locator(assignmentCardPage.assignmentInnerDeadline_input).evaluate(assignmentCardPage.removeReadonly)
        org2Registrar1.page.fill(assignmentCardPage.assignmentInnerDeadline_input, Dates().getNextWorkingDateFromToday())
        org2Registrar1.page.keyboard().press(enter_btn)
        assignmentInnerDeadlineForExecutor1 = org2Registrar1.page.inputValue(assignmentCardPage.assignmentInnerDeadline_input)
        org2Registrar1.page.click(assignmentCardPage.assign_btn)


        //Логинимся под регистратором Org.3 и открываем поручение
        switchOnUser(org3Registrar1)
        org3Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org3Registrar1.page.click(asideToggle.incomingAssignments)
        org3Registrar1.page.click(asideToggle.waitingForRouting)
        org3Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org3Registrar1.page.click(waitingForRoutingPage.assignmentSearch_input)
        org3Registrar1.page.fill(waitingForRoutingPage.assignmentSearch_input, assignmentNumber)
        org3Registrar1.page.keyboard().press(enter_btn)
        org3Registrar1.page.click(waitingForRoutingPage.firstAssignmentInList)

        //Направляем поручение в работу Исполнителю из Org.3
        org3Registrar1.page.click(assignmentCardPage.sendToWork_btn)
        org3Registrar1.page.click(assignmentCardPage.responsibleExecutor_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3_Executor1)

        //Направляем поручение в работу Соисполнителю из подведомственной организации в Org.3
        org3Registrar1.page.click(assignmentCardPage.addCoExecutor_btn)
        org3Registrar1.page.click(assignmentCardPage.coExecutor1Org_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3ch1)
        org3Registrar1.page.click(assignmentCardPage.responsibleCoExecutor1_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3ch1_Executor1)

        //Направляем поручение в работу Соисполнителю из структурного подразделения в Org.3
        org3Registrar1.page.click(assignmentCardPage.addCoExecutor_btn)
        org3Registrar1.page.click(assignmentCardPage.coExecutor2Org_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3un1)
        org3Registrar1.page.click(assignmentCardPage.responsibleCoExecutor2_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3un1_Executor1)

        //Указываем внутренний срок и нажимаем кнопку "Назначить"
        org3Registrar1.page.click(assignmentCardPage.assignmentInnerDeadline_input)
        org3Registrar1.page.locator(assignmentCardPage.assignmentInnerDeadline_input).evaluate(assignmentCardPage.removeReadonly)
        org3Registrar1.page.fill(assignmentCardPage.assignmentInnerDeadline_input, Dates().getNextWorkingDateFromToday())
        org3Registrar1.page.keyboard().press(enter_btn)
        assignmentInnerDeadlineForExecutor2 = org3Registrar1.page.inputValue(assignmentCardPage.assignmentInnerDeadline_input)
        org3Registrar1.page.click(assignmentCardPage.assign_btn)

        //Логинимся под Исполнителем из Org.2 и открываем поручение
        switchOnUser(org2Executor1)
        org2Executor1.page.click(asideToggle.asideToggleFix_btn)
        org2Executor1.page.click(asideToggle.incomingAssignments)
        org2Executor1.page.click(asideToggle.myTasks)
        org2Executor1.page.click(asideToggle.asideToggleFix_btn)
        org2Executor1.page.click(myTasksPage.assignmentSearch_input)
        org2Executor1.page.fill(myTasksPage.assignmentSearch_input, assignmentNumber)
        org2Executor1.page.keyboard().press(enter_btn)
        org2Executor1.page.click(myTasksPage.firstAssignmentInList)

        //Проверяем что у него есть кнопки "Ответить на поручение" и "Направить в работу"
        if (assert) {
            org2Executor1.page.waitForSelector(assignmentCardPage.sendToWork_btn)
            org2Executor1.page.waitForSelector(assignmentCardPage.answerOnAssignment_btn)
            assertTrue(org2Executor1.page.isVisible(assignmentCardPage.sendToWork_btn))
            assertTrue(org2Executor1.page.isVisible(assignmentCardPage.answerOnAssignment_btn))
        }

        //Нажимаем кнопку "Ответить на поручение", выбираем опцию "Ответить на поручение", пишем текст ответа, прикрепляем файл и вводим название файла
        org2Executor1.page.click(assignmentCardPage.answerOnAssignment_btn)
        org2Executor1.page.fill(assignmentCardPage.answerText_input, assignmentCardPage.answerFromOrg2Executor1)
        org2Executor1.page.click(assignmentCardPage.attachFile_btn)

        attachFile()

        org2Executor1.page.fill(assignmentCardPage.fileName_input, assignmentCardPage.fileFromOrg2Executor1)
        org2Executor1.page.click(assignmentCardPage.send_btn)

        //Нажимаем кнопку "Отправить на согласование", выбираем согласующим и подписантом Руководителя из Org.2
        org2Executor1.page.click(assignmentCardPage.sendToApprove_btn)
        org2Executor1.page.click(assignmentCardPage.approvers_dropdown)
        org2Executor1.page.click(assignmentCardPage.approverOrg2Chief1)
        org2Executor1.page.click(assignmentCardPage.signers_dropdown)
        org2Executor1.page.click(assignmentCardPage.signerOrg2Chief1)
        org2Executor1.page.click(assignmentCardPage.sendToApproveAndSign_btn)

        //Нажимаем кнопку "Ответить на поручение", выбираем опцию "Запрос на продление срока", пишем текст ответа, прикрепляем файл и вводим название файла
        org2Executor1.page.click(assignmentCardPage.answerOnAssignment_btn)
        org2Executor1.page.click(assignmentCardPage.requestToProlong_btn)
        org2Executor1.page.fill(assignmentCardPage.answerText_input, assignmentCardPage.requestToProlongFromOrg2Executor1)
        org2Executor1.page.click(assignmentCardPage.attachFile_btn)

        attachFile()

        org2Executor1.page.fill(assignmentCardPage.fileName_input, assignmentCardPage.fileFromOrg2Executor1)
        org2Executor1.page.click(assignmentCardPage.send_btn)

        //Нажимаем кнопку "Отправить на согласование", выбираем согласующим и подписантом Руководителя из Org.2
        org2Executor1.page.click(assignmentCardPage.sendToApprove_btn)
        org2Executor1.page.click(assignmentCardPage.approvers_dropdown)
        org2Executor1.page.click(assignmentCardPage.approverOrg2Chief1)
        org2Executor1.page.click(assignmentCardPage.signers_dropdown)
        org2Executor1.page.click(assignmentCardPage.signerOrg2Chief1)
        org2Executor1.page.click(assignmentCardPage.sendToApproveAndSign_btn)

        //Логинимся под Руководителем из Org.2
        switchOnUser(org2Chief1)

        //Открываем поручение
        org2Chief1.page.click(asideToggle.asideToggleFix_btn)
        org2Chief1.page.click(asideToggle.incomingAssignments)
        org2Chief1.page.click(asideToggle.myTasks)
        org2Chief1.page.click(asideToggle.asideToggleFix_btn)
        org2Chief1.page.click(myTasksPage.assignmentSearch_input)
        org2Chief1.page.fill(myTasksPage.assignmentSearch_input, assignmentNumber)
        org2Chief1.page.keyboard().press(enter_btn)
        org2Chief1.page.click(myTasksPage.firstAssignmentInList)

        //Нажимаем кнопку "Согласовать" и "Подписать" Ответ на поручение
        org2Chief1.page.click(assignmentCardPage.assignmentApprove1_btn)
        org2Chief1.page.click(assignmentCardPage.approve_btn_popup)
        org2Chief1.page.click(assignmentCardPage.sign_btn)
        org2Chief1.page.click(assignmentCardPage.NUTS_btn)

        sign()

        //Нажимаем кнопку "Согласовать" и "Подписать" Запрос на продление срока
        org2Chief1.page.click(assignmentCardPage.assignmentApprove2_btn)
        org2Chief1.page.click(assignmentCardPage.approve_btn_popup)
        org2Chief1.page.reload()
        org2Chief1.page.reload()
        org2Chief1.page.click(assignmentCardPage.sign_btn)
        org2Chief1.page.click(assignmentCardPage.NUTS_btn)

        sign()


        //Логинимся под Соисполнителем из структурного подразделения в Org.2 и открываем поручение
        switchOnUser(org2un1Executor1)
        org2un1Executor1.page.click(asideToggle.asideToggleFix_btn)
        org2un1Executor1.page.click(asideToggle.incomingAssignments)
        org2un1Executor1.page.click(asideToggle.myTasks)
        org2un1Executor1.page.click(asideToggle.asideToggleFix_btn)
        org2un1Executor1.page.click(myTasksPage.assignmentSearch_input)
        org2un1Executor1.page.fill(myTasksPage.assignmentSearch_input, assignmentNumber)
        org2un1Executor1.page.keyboard().press(enter_btn)
        org2un1Executor1.page.click(myTasksPage.firstAssignmentInList)

        //Проверяем что у него есть кнопки "Ответить на поручение" и "Направить в работу"
        if (assert) {
            org2un1Executor1.page.waitForSelector(assignmentCardPage.sendToWork_btn)
            org2un1Executor1.page.waitForSelector(assignmentCardPage.answerOnAssignment_btn)
            org2un1Executor1.page.waitForSelector(assignmentCardPage.noted_btn)
            assertTrue(org2un1Executor1.page.isVisible(assignmentCardPage.sendToWork_btn))
            assertTrue(org2un1Executor1.page.isVisible(assignmentCardPage.answerOnAssignment_btn))
            assertTrue(org2un1Executor1.page.isVisible(assignmentCardPage.noted_btn))
        }

        //Нажимаем кнопку "Ответить на поручение" и пишем текст ответа
        org2un1Executor1.page.click(assignmentCardPage.answerOnAssignment_btn)
        org2un1Executor1.page.fill(assignmentCardPage.answerText_input, assignmentCardPage.answerFromOrg2Un1Executor1)
        org2un1Executor1.page.click(assignmentCardPage.send_btn)

        //Нажимаем кнопку "Ответы от соисполнителей"
        org2un1Executor1.page.click(assignmentCardPage.answersFromCoExecutors)

        //Нажимаем кнопку "Отправить на согласование", выбираем согласующим и подписантом Руководителя из Org.2
        org2un1Executor1.page.click(assignmentCardPage.sendToApprove_btn)
        org2un1Executor1.page.click(assignmentCardPage.approvers_dropdown)
        org2un1Executor1.page.click(assignmentCardPage.approverOrg2Chief1)
        org2un1Executor1.page.click(assignmentCardPage.signers_dropdown)
        org2un1Executor1.page.click(assignmentCardPage.signerOrg2Chief1)
        org2un1Executor1.page.click(assignmentCardPage.sendToApproveAndSign_btn)


        //Логинимся под Руководителем из Org.2 и открываем поручение
        switchOnUser(org2Chief1)
        while (!org2Chief1.page.isVisible(onApprovePage.firstAssignmentInList)){
            org2Chief1.page.click(asideToggle.asideToggleFix_btn)
            org2Chief1.page.click(asideToggle.incomingAssignments)
            org2Chief1.page.click(asideToggle.onApprove)
            org2Chief1.page.click(asideToggle.asideToggleFix_btn)
            org2Chief1.page.click(onApprovePage.assignmentSearch_input)
            org2Chief1.page.fill(onApprovePage.assignmentSearch_input, assignmentNumber)
            org2Chief1.page.keyboard().press(enter_btn)
            sleep(500)
        }
        org2Chief1.page.click(onApprovePage.firstAssignmentInList)

        //Нажимаем кнопку "Ответы от соисполнителей"
        org2Chief1.page.click(assignmentCardPage.answersFromCoExecutors)

        //Нажимаем кнопку "Согласовать" и "Подписать"
        org2Chief1.page.click(assignmentCardPage.assignmentApprove2_btn)
        org2Chief1.page.click(assignmentCardPage.approve_btn_popup)
        org2Chief1.page.click(assignmentCardPage.sign_btn)
        org2Chief1.page.click(assignmentCardPage.NUTS_btn)

        sign()

        if (assert) {
            println("Test 4.2.1   passed ($assignmentNumber)")
        }
    }
}