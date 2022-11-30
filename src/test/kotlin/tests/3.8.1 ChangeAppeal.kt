package tests

import org.testng.annotations.Test
import java.util.ArrayList
import kotlin.test.assertEquals
import helpers.*
import lists.*
import pages.*

//Редактирование обращения Регистратором

class ChangeAppealByRegistrar (private var assert: Boolean = true) {
    private val appealCardPage = AppealCardPage()
    private val changeAppealPage = ChangeAppealPage()

    private val asideToggle = AsideToggle()
    private val registeredAppealsListPage = RegisteredAppealsListPage()

    @Test
    fun changeAppealByRegistrarTest() {
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

        //Нажимаем на редактирование обращения, меняем не подписываемые данные (поочередно меняем все виды обращения),
        //после каждого сохраняемся, проверяем изменения и дедлайны
        for (i in listOfAppealAndComplaintDeadlines) {
            org1Registrar1.page.click(appealCardPage.editAppeal_btn)
            org1Registrar1.page.click(appealCardPage.ok)
            org1Registrar1.page.click(changeAppealPage.appealType_dropdown)
            org1Registrar1.page.click("text=${i.key}")
            org1Registrar1.page.click(changeAppealPage.saveChanges_btn)
            assertEquals(org1Registrar1.page.innerText(appealCardPage.deadline2), Dates().calculateAppealDeadline(i.key))
        }

        //Нажимаем на редактирование обращения, меняем не подписываемые данные (форма подачи, язык, категорию/подкатегорию),
        //сохраняемся и проверяем изменения
        org1Registrar1.page.click(appealCardPage.editAppeal_btn)
        org1Registrar1.page.click(appealCardPage.ok)
        org1Registrar1.page.click(changeAppealPage.appealForm_dropdown)
        org1Registrar1.page.click(electronic)
        org1Registrar1.page.click(changeAppealPage.appealLanguage_dropdown)
        org1Registrar1.page.click(changeAppealPage.appealLanguage)
        org1Registrar1.page.click(changeAppealPage.appealCategoryForRegistrar_dropdown)
        org1Registrar1.page.click(changeAppealPage.appealCategoryForRegistrar)
        org1Registrar1.page.click(changeAppealPage.appealSubCategoryForRegistrar)

        org1Registrar1.page.click(changeAppealPage.saveChanges_btn)
        org1Registrar1.page.click(appealCardPage.editAppeal_btn)
        org1Registrar1.page.click(appealCardPage.ok)

        //Нажимаем на редактирование обращения, меняем подписываемые данные (суть вопроса, ИИН и адрес заявителя),
        //сохраняемся и проверяем изменения
        org1Registrar1.page.click(changeAppealPage.desciption_textarea)
        org1Registrar1.page.fill(changeAppealPage.desciption_textarea, appealDescriptionChanged)
        org1Registrar1.page.click(changeAppealPage.IIN_input)
        org1Registrar1.page.fill(changeAppealPage.IIN_input, applicantsIINChanged)
        org1Registrar1.page.click(changeAppealPage.address)
        org1Registrar1.page.fill(changeAppealPage.address, applicantsAddressChanged)

        org1Registrar1.page.click(changeAppealPage.saveChanges_btn)
        org1Registrar1.page.click(appealCardPage.ok)
        org1Registrar1.page.click(appealCardPage.NUTS_btn)

        sign()

        if (assert) {
            println("Test 3.8.1   passed (Сообщение, ЖТ-2022-$appealNumber)")
        }
    }
}
