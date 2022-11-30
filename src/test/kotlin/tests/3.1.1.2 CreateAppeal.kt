package tests

import lists.*
import org.testng.annotations.Test
import helpers.Dates
import helpers.sign
import pages.*
import kotlin.test.assertEquals


class CreateAppealByTSONOperator (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[1],
) {
    private val createAppealPage = CreateAppealPage()
    private val appealCardPage = AppealCardPage()
    private val mainPage = MainPage()
    private val appealsRegistryTsonPage = AppealsRegistryTsonPage()

    @Test
    fun createAppealTest() {
        TSONOperator.page.bringToFront()

        if (!TSONOperator.page.isVisible(mainPage.create_appeal_btn)) {
            Login(TSONOperator, false).loginTest()
        }

        TSONOperator.page.waitForNavigation { TSONOperator.page.click(mainPage.create_appeal_btn) }
        TSONOperator.page.click(createAppealPage.appealType_dropdown)
        TSONOperator.page.click("text=$appealType")
        appealTypeName = appealType

        TSONOperator.page.click(createAppealPage.appealForm_dropdown)
        TSONOperator.page.click(paper)
        TSONOperator.page.click(createAppealPage.appealLanguage_dropdown)
        TSONOperator.page.click(createAppealPage.appealLanguage)

        TSONOperator.page.click(createAppealPage.region_dropdown)
        TSONOperator.page.click(createAppealPage.country)
        TSONOperator.page.click(createAppealPage.adresat_dropdown)
        TSONOperator.page.click(createAppealPage.adresat)

        TSONOperator.page.click(createAppealPage.desciption_textarea)
        TSONOperator.page.fill(createAppealPage.desciption_textarea, appealDescription)
        TSONOperator.page.click(createAppealPage.appealCharacter_dropdown)
        TSONOperator.page.click(createAppealPage.appealCharacter)
        TSONOperator.page.fill(createAppealPage.IIN_input, applicantsIIN)
        TSONOperator.page.fill(createAppealPage.surname_input, applicantsSurname)
        TSONOperator.page.fill(createAppealPage.name_input, applicantsName)
        TSONOperator.page.fill(createAppealPage.address, applicantsAddress)
        TSONOperator.page.fill(createAppealPage.mobilePhone_input, applicantsMobilePhone)
        TSONOperator.page.click(createAppealPage.send_btn)
        TSONOperator.page.click(createAppealPage.NUTS_btn)

        sign()

        appealNumber = TSONOperator.page.innerText(createAppealPage.appealNumber_text)
        TSONOperator.page.waitForNavigation { TSONOperator.page.click(createAppealPage.goToRegistry_btn) }

        if (assert) {
            TSONOperator.page.fill(appealsRegistryTsonPage.appealsSearchTSON_input, appealNumber)
            TSONOperator.page.keyboard().press(enter_btn)
            TSONOperator.page.waitForNavigation { TSONOperator.page.click(appealsRegistryTsonPage.appealInListTSON) }
            assertEquals(TSONOperator.page.innerText(appealCardPage.cardHead_text), "$appealTypeName №$appealNumber")
            assertEquals(TSONOperator.page.innerText(appealCardPage.deadlineOnTSONCard), Dates().calculateAppealDeadline(appealType))
            println("Test 3.1.1.2 passed ($appealTypeName $appealNumber)")
        }
    }
}
