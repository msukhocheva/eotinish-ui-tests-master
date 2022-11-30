package tests

import org.testng.annotations.Test
import kotlin.test.assertEquals
import lists.*
import configs.*
import helpers.*
import pages.*


class CancelAppealExecutionAfterRevoke (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[2],
) {
    private val appealCardPage = AppealCardPage()
    private val asideToggle = AsideToggle()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val inWorkAppealsListPage = InWorkAppealsListPage()


    @Test
    fun cancelAppealExecutionAfterRevokeTest() {
        testTimeout

        //Создаем обращение Регистратором
        switchOnUser(org1Registrar1)
        val appealNumber = createAppealInDB(appealType)

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
        org1Registrar1.page.click(appealCardPage.org1_Executor1)
        org1Registrar1.page.click(appealCardPage.appoint_btn)
        org1Registrar1.page.waitForSelector(appealCardPage.statusSendToWorkFromReg1ToExec1Text)


        //Нажимаем кнопку "Отозвать"
        org1Registrar1.page.click(appealCardPage.revokeAppeal_btn)
        org1Registrar1.page.click(appealCardPage.revokeComment_input)

        org1Registrar1.page.fill(appealCardPage.revokeComment_input, revokeComment)
        org1Registrar1.page.click(appealCardPage.attachRevokeDocs_btn)

        screen.click()
        Thread.sleep(500)
        screen.click()
        screen.keyDown("t")
        screen.keyUp("t")
        Thread.sleep(800)
        screen.type("\n")

        org1Registrar1.page.click(appealCardPage.createRevoke_btn)
        org1Registrar1.page.click(appealCardPage.NUTS_btn)

        sign()

        switchOnUser(org1Executor1)

        org1Executor1.page.click(asideToggle.asideToggleFix_btn)
        org1Executor1.page.click(asideToggle.incomingTasks)
        org1Executor1.page.click(asideToggle.revokedByApplicant)
        org1Executor1.page.click(asideToggle.asideToggleFix_btn)
        org1Executor1.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Executor1.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Executor1.page.keyboard().press(enter_btn)
        if (!org1Executor1.page.isVisible(inWorkAppealsListPage.appealInList)){
            org1Executor1.page.reload()
        }
        org1Executor1.page.click(inWorkAppealsListPage.appealInList)
        org1Executor1.page.click(appealCardPage.takeDecision_btn)

        //Выбираем что заслушивание не будет проводиться, указываем решение и причину
        org1Executor1.page.click(appealCardPage.hearingHeld_dropdown)
        org1Executor1.page.click(appealCardPage.hearingHeldNo)
        org1Executor1.page.fill(appealCardPage.hearingNotHeldReason_input, appealCardPage.hearingNotHeldReason)
        org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)
        org1Executor1.page.click(appealCardPage.decisionType2)
        org1Executor1.page.click(appealCardPage.reasonSelect_dropdown)
        org1Executor1.page.click(appealCardPage.reasonType4)

        //Вводим текст ответа, после чего сохраняем решение
        org1Executor1.page.click(appealCardPage.answerText_input)
        org1Executor1.page.fill(appealCardPage.answerText_input, appealCardPage.answerText)
        org1Executor1.page.click(appealCardPage.saveDecision_btn)

        //Нажимаем кнопку "Отправить на согласование", выбираем согласующих и подписанта и отправляем
        org1Executor1.page.click(appealCardPage.sendToApprove_btn)
        org1Executor1.page.click(appealCardPage.selectApprovers_dropdown)
        org1Executor1.page.click(appealCardPage.org1_Chief1)
        org1Executor1.page.click(appealCardPage.selectSigner_dropdown)
        org1Executor1.page.click(appealCardPage.org1_Chief1)
        org1Executor1.page.click(appealCardPage.sendToApproveAndSign_btn)

        switchOnUser(org1Chief1)

        //Проходимся по каждому полученному на согласование и подписание обращению и согласовываем и подписываем
        org1Chief1.page.click(asideToggle.asideToggleFix_btn)
        org1Chief1.page.click(asideToggle.incomingTasks)
        org1Chief1.page.click(asideToggle.approve)
        org1Chief1.page.click(asideToggle.asideToggleFix_btn)
        org1Chief1.page.click(inWorkAppealsListPage.appealsSearch_input)
        org1Chief1.page.fill(inWorkAppealsListPage.appealsSearch_input, appealNumber.substring(3))
        org1Chief1.page.keyboard().press(enter_btn)
        if (!org1Chief1.page.isVisible(inWorkAppealsListPage.appealInList)){
            org1Chief1.page.reload()
        }
        org1Chief1.page.click(inWorkAppealsListPage.appealInList)

        org1Chief1.page.click(appealCardPage.approve_btn)
        org1Chief1.page.click(appealCardPage.approveConfirm_btn)
        org1Chief1.page.click(appealCardPage.signDecision_btn)
        org1Chief1.page.click(appealCardPage.signDecisionConfirm_btn)
        org1Chief1.page.click(appealCardPage.NUTS_btn)

        sign()

        if (assert) {
            assertEquals(org1Chief1.page.innerText(appealCardPage.statusRevokedByExecutor), statusAppealRevoked)
            println("Test 3.10.2  passed ($appealType ЖТ-2022-$appealNumber)")
        }
    }
}
