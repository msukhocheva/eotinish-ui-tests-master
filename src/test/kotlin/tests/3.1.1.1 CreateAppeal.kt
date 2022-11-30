package tests

import org.testng.annotations.Test
import kotlin.test.assertEquals
import lists.*
import configs.*
import helpers.*
import pages.*


var appealNumber = ""
var appealTypeName = ""

class CreateAppealByRegistrar (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[6],
) {
    private val createAppealPage = CreateAppealPage()
    private val appealCardPage = AppealCardPage()
    private val mainPage = MainPage()
    private val registeredAppealsListPage = RegisteredAppealsListPage()

    @Test
    fun createAppealTest() {
        testTimeout
        org1Registrar1.page.bringToFront()

        if (!org1Registrar1.page.isVisible(mainPage.create_appeal_btn)) {
            Login(assert = false).loginTest()
        }
//        org1Registrar1Page.screenshot(Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + ".png")))
//        org1Registrar1.page.locator("xpath=/html/body/app-layout/div/div/div/app-header/div").evaluate("(el, value) => el.innerText = value", "className")

        org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(mainPage.create_appeal_btn) }
        org1Registrar1.page.click(createAppealPage.appealType_dropdown)
        org1Registrar1.page.click("text=$appealType")
        appealTypeName = appealType

        org1Registrar1.page.click(createAppealPage.appealForm_dropdown)
        org1Registrar1.page.click(paper)
        org1Registrar1.page.click(createAppealPage.appealLanguage_dropdown)
        org1Registrar1.page.click(createAppealPage.appealLanguage)

        org1Registrar1.page.click(createAppealPage.desciption_textarea)
        org1Registrar1.page.fill(createAppealPage.desciption_textarea, appealDescription)

        org1Registrar1.page.click(createAppealPage.appealCategory_dropdown)
        org1Registrar1.page.click(createAppealPage.appealCategory)
        org1Registrar1.page.click(createAppealPage.appealSubCategory)

        org1Registrar1.page.click(createAppealPage.appealCharacter_dropdown)
        org1Registrar1.page.click(createAppealPage.appealCharacter)
        org1Registrar1.page.fill(createAppealPage.IIN_input, applicantsIIN)
        org1Registrar1.page.fill(createAppealPage.surname_input, applicantsSurname)
        org1Registrar1.page.fill(createAppealPage.name_input, applicantsName)
        org1Registrar1.page.fill(createAppealPage.address, applicantsAddress)
        org1Registrar1.page.fill(createAppealPage.mobilePhone_input, applicantsMobilePhone)
        org1Registrar1.page.click(createAppealPage.send_btn)
        org1Registrar1.page.click(createAppealPage.NUTS_btn)

        sign()

        appealNumber = org1Registrar1.page.innerText(createAppealPage.appealNumber_text)
        org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(createAppealPage.goToRegistry_btn) }

        if (assert) {
            org1Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
            org1Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, appealNumber.substring(3))
            org1Registrar1.page.keyboard().press(enter_btn)
            org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(registeredAppealsListPage.firstAppealInList) }
            assertEquals(org1Registrar1.page.innerText(appealCardPage.cardHead_text), "$appealTypeName №$appealNumber")
            assertEquals(org1Registrar1.page.innerText(appealCardPage.deadline), Dates().calculateAppealDeadline(appealType))
            println("Test 3.1.1.1 passed ($appealTypeName $appealNumber)")
        }
    }
}
