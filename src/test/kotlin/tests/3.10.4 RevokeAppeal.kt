package tests

import org.testng.annotations.Test
import kotlin.test.assertEquals
import lists.*
import configs.*
import helpers.*
import pages.*


class RevokeAppealByTSONOperator (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[2],
) {
    private val appealCardPage = AppealCardPage()
    private val asideToggle = AsideToggle()
    private val appealsRegistryTsonPage = AppealsRegistryTsonPage()


    @Test
    fun revokeAppealByTSONOperatorTest() {
        testTimeout

        //Создаем обращение Регистратором
        switchOnUser(TSONOperator)
        TSONOperator.page.bringToFront()
        val appealNumber = createAppealInDB(appealType)

        //Открываем боковое меню, открываем вкладку "Реестр обращений", закрываем боковое меню
        TSONOperator.page.click(asideToggle.asideToggleFix_btn)
        TSONOperator.page.click(asideToggle.TSONAppealRegistry)
        TSONOperator.page.click(asideToggle.asideToggleFix_btn)

        //В поле поиска вставляем номер обращения, ищем и открываем его
        TSONOperator.page.click(appealsRegistryTsonPage.appealsSearchTSON_input)
        TSONOperator.page.fill(appealsRegistryTsonPage.appealsSearchTSON_input, appealNumber)
        TSONOperator.page.keyboard().press(enter_btn)
        TSONOperator.page.click(appealsRegistryTsonPage.appealInListTSON)

        //Нажимаем кнопку "Отозвать"
        TSONOperator.page.click(appealCardPage.revokeAppeal_btn)
        TSONOperator.page.click(appealCardPage.revokeComment_input)

        TSONOperator.page.fill(appealCardPage.revokeComment_input, revokeComment)
        TSONOperator.page.click(appealCardPage.attachRevokeDocs_btn)

        attachFile()

        TSONOperator.page.click(appealCardPage.createRevoke_btn)
        TSONOperator.page.click(appealCardPage.NUTS_btn)

        sign()

        if (assert) {
            assertEquals(TSONOperator.page.innerText(appealCardPage.statusRevokeByTSONOperator), statusAppealRevoked)
            println("Test 3.10.4  passed ($appealType ЖТ-2022-$appealNumber)")
        }
    }
}

