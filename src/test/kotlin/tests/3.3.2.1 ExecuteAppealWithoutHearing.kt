package tests

import configs.slowMo
import helpers.createAppealInDB
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import java.lang.Thread.sleep
import helpers.sign
import helpers.switchOnUser
import lists.*
import pages.*


//Исполнение обращений первой группы (Запросы, Сообщение, Отклик, Предложение) с заслушиванием

class ExecuteAppealsGroupOneWithoutHearing {
    val assert:Boolean = true
    private val asideToggle = AsideToggle()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val inWorkAppealsListPage = InWorkAppealsListPage()
    private val appealCardPage = AppealCardPage()
    private val typesOfCreatedAppeals = mutableListOf<String>()
    private val regNumbersOfCreatedAppeals = mutableListOf<String>()

    @Test
    fun executeAppealsGroupOneWithoutHearing() {
        for (i in listOfAppealsGroup1.indices) {

            //Создаем обращение Регистратором
            switchOnUser(org1Registrar1)
            val appealTypeName = listOfAppealsGroup1[i]
            val appealNumber = createAppealInDB(appealTypeName)

            //Открываем боковое меню, открываем вкладку "Зарегистрированы и ожидают маршрутизации", закрываем боковое меню
            org1Registrar1.page.click(asideToggle.asideToggleFix_btn)
            org1Registrar1.page.click(asideToggle.registeredAppeals)
            org1Registrar1.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер обращения, ищем и открываем его
            org1Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
            org1Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, appealNumber.substring(3))
            org1Registrar1.page.keyboard().press(enter_btn)
            org1Registrar1.page.click(registeredAppealsListPage.firstAppealInList)

            //Нажимаем кнопку "Направить в работу, выбираем Исполнителя и направляем ему в работу"
            org1Registrar1.page.click(appealCardPage.sendToWork_btn)
            org1Registrar1.page.click(appealCardPage.responsibleSpecialist_dropdown)
            org1Registrar1.page.click(appealCardPage.org1_Executor1)
            org1Registrar1.page.click(appealCardPage.appoint_btn)
            typesOfCreatedAppeals.add(appealTypeName)
            regNumbersOfCreatedAppeals.add(appealNumber)
        }

        //Логинимся под Исполнителем, принимаем решения по всем созданным обращениям и отправляем на согласование и подписание
        //Проверяем залогинен ли Исполнитель, если нет, то логинимся под ним
        switchOnUser(org1Executor1)

        //Проходимся по каждому полученному в работу обращению
        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем боковое меню, открываем вкладку "Находятся в работе", закрываем боковое меню
            org1Executor1.page.waitForSelector(asideToggle.asideToggleFix_btn)
            org1Executor1.page.click(asideToggle.asideToggleFix_btn)
            org1Executor1.page.click(asideToggle.incomingTasks)
            org1Executor1.page.click(asideToggle.inWork)
            org1Executor1.page.click(asideToggle.asideToggleFix_btn)

            //В поле поиска вставляем номер обращения, ищем и открываем его
            org1Executor1.page.click(inWorkAppealsListPage.appealsSearch_input)
            org1Executor1.page.fill(inWorkAppealsListPage.appealsSearch_input, regNumbersOfCreatedAppeals[i].substring(3))
            org1Executor1.page.keyboard().press(enter_btn)
            org1Executor1.page.click(inWorkAppealsListPage.appealInList)

            //Нажимаем кнопку "Принять решение", указываем категорию и подкатегорию
            org1Executor1.page.click(appealCardPage.takeDecision_btn)
            org1Executor1.page.click(appealCardPage.selectCategory_dropdown)
            org1Executor1.page.click(appealCardPage.category)
            org1Executor1.page.click(appealCardPage.categorySection)
            org1Executor1.page.click(appealCardPage.subCategory_dropdown)
            org1Executor1.page.click(appealCardPage.subCategory)

            //Выбираем что заслушивание не будет проводиться и указываем причину
            org1Executor1.page.click(appealCardPage.hearingHeld_dropdown)
            org1Executor1.page.click(appealCardPage.hearingHeldNo)
            org1Executor1.page.fill(appealCardPage.hearingNotHeldReason_input, appealCardPage.hearingNotHeldReason)
            org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)


            //Проверяем корректно ли отображаются типы решений и типы причин и характеров
            if (assert) {
                org1Executor1.page.mouse().wheel(0.0, 1000.0)

                org1Executor1.page.click(appealCardPage.decisionType1)
                assertTrue(!org1Executor1.page.isVisible(appealCardPage.reasonSelect_dropdown))
                assertTrue(!org1Executor1.page.isVisible(appealCardPage.characterSelect_dropdown))

                org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType2)
                org1Executor1.page.click(appealCardPage.reasonSelect_dropdown)
                org1Executor1.page.waitForSelector(appealCardPage.reasonType1)
                org1Executor1.page.waitForSelector(appealCardPage.reasonType2)
                org1Executor1.page.waitForSelector(appealCardPage.reasonType3)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reasonType1))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reasonType2))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reasonType3))

                org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType3)
                org1Executor1.page.click(appealCardPage.characterSelect_dropdown)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.answerCharacter1))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.answerCharacter2))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.answerCharacter3))
            }

            //Вводим текст ответа, после чего сохраняем решение
            org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)
            org1Executor1.page.click(appealCardPage.decisionType2)
            org1Executor1.page.click(appealCardPage.reasonSelect_dropdown)
            org1Executor1.page.click(appealCardPage.reasonType1)
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
        }

        //Логинимся под Подписантом, согласовываем и подписываем все полученные на согласование и подписание обращения
        //Проверяем залогинен ли Подписант, если нет, то логинимся под ним
        switchOnUser(org1Chief1)

        //Проходимся по каждому полученному на согласование и подписание обращению и согласовываем и подписываем
        for (i in regNumbersOfCreatedAppeals.indices) {
            org1Chief1.page.click(asideToggle.asideToggleFix_btn)
            org1Chief1.page.click(asideToggle.incomingTasks)
            org1Chief1.page.click(asideToggle.approve)
            org1Chief1.page.click(asideToggle.asideToggleFix_btn)
            org1Chief1.page.click(inWorkAppealsListPage.appealsSearch_input)
            org1Chief1.page.fill(inWorkAppealsListPage.appealsSearch_input, regNumbersOfCreatedAppeals[i].substring(3))
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
        }

        //Проверям находится ли исполненное обращение во вкладке "Завершенные" и отображается ли статус "Исполнено" в статусах обращения
        if (assert) {
            for (i in regNumbersOfCreatedAppeals.indices){
                org1Chief1.page.click(asideToggle.asideToggleFix_btn)
                org1Chief1.page.click(asideToggle.AUTOTESTORG1)
                org1Chief1.page.click(asideToggle.finished)
                org1Chief1.page.click(asideToggle.asideToggleFix_btn)
                org1Chief1.page.click(inWorkAppealsListPage.appealsSearch_input)
                org1Chief1.page.fill(inWorkAppealsListPage.appealsSearch_input, regNumbersOfCreatedAppeals[i].substring(3))
                org1Chief1.page.keyboard().press(enter_btn)
                if (!org1Chief1.page.isVisible(inWorkAppealsListPage.appealInList)){
                    org1Chief1.page.reload()
                }
                org1Chief1.page.click(inWorkAppealsListPage.appealInList)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealFinished), statusAppealFinished)
            }

            println("Test 3.3.2.1 passed (${typesOfCreatedAppeals[0]}, ЖТ-2022-${regNumbersOfCreatedAppeals[0]})")
            for (i in 1 until typesOfCreatedAppeals.size) {
                println("                    (${typesOfCreatedAppeals[i]}, ЖТ-2022-${regNumbersOfCreatedAppeals[i]})")
            }
        }
    }
}
