package tests

import org.testng.annotations.Test
import kotlin.test.assertEquals
import lists.*
import configs.*
import helpers.*
import pages.*


class RevokeAppealByRegistrar (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[2],
) {
    private val appealCardPage = AppealCardPage()
    private val asideToggle = AsideToggle()
    private val registeredAppealsListPage = RegisteredAppealsListPage()


    @Test
    fun revokeAppealByRegistrarTest() {
        testTimeout

        //Создаем обращение Регистратором
        switchOnUser(org1Registrar1)
        org1Registrar1.page.bringToFront()
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

        if (assert) {
            assertEquals(org1Registrar1.page.innerText(appealCardPage.statusRevokedByRegistrar), statusAppealRevoked)
            println("Test 3.10.1  passed ($appealType ЖТ-2022-$appealNumber)")
        }
    }
}

