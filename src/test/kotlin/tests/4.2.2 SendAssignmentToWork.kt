package tests

import helpers.*
import lists.*
import pages.*
import org.testng.annotations.Test
import java.lang.Thread.sleep


class SendAssignmentToWork2(private var assert: Boolean = true) {
    private val asideToggle = AsideToggle()
    private val waitingForRoutingPage = WaitingForRoutingPage()
    private val assignmentCardPage = AssignmentCardPage()

    @Test
    fun sendAssignmentToWorkTest() {
        //Создаем обращение регистратором Org.1 и направляем в работу в Org.2 и в Org.3
        CreateAssignmentByRegistrar(assert = false).createAssignmentByRegistrarTest()

        //Логинимся под регистратором Org.2 и открываем поручение
        switchOnUser(org2Registrar1)
        org2Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org2Registrar1.page.click(asideToggle.incomingAssignments)
        org2Registrar1.page.click(asideToggle.waitingForRouting)
        org2Registrar1.page.click(asideToggle.asideToggleFix_btn)
        org2Registrar1.page.click(waitingForRoutingPage.assignmentSearch_input)
        org2Registrar1.page.fill(waitingForRoutingPage.assignmentSearch_input, assignmentNumber)
        org2Registrar1.page.keyboard().press(enter_btn)
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

        //Направляем поручение в работу Исполнителю из подведомственной организации в Org.3
        org3Registrar1.page.click(assignmentCardPage.sendToWork_btn)
        org3Registrar1.page.click(assignmentCardPage.executorForOrg3_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3ch1)
        org3Registrar1.page.click(assignmentCardPage.responsibleExecutor_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3ch1_Executor1)

        //Указываем внутренний срок и нажимаем кнопку "Назначить"
        org3Registrar1.page.click(assignmentCardPage.assignmentInnerDeadline_input)
        org3Registrar1.page.locator(assignmentCardPage.assignmentInnerDeadline_input).evaluate(assignmentCardPage.removeReadonly)
        org3Registrar1.page.fill(assignmentCardPage.assignmentInnerDeadline_input, Dates().getNextWorkingDateFromToday())
        org3Registrar1.page.keyboard().press(enter_btn)
        assignmentInnerDeadlineForExecutor2 = org3Registrar1.page.inputValue(assignmentCardPage.assignmentInnerDeadline_input)
        org3Registrar1.page.click(assignmentCardPage.assign_btn)

        if (assert) {
            println("Test 4.2.2   passed ($assignmentNumber)")
        }
    }
}