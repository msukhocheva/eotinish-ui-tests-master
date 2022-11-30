package tests

import helpers.Dates
import helpers.sign
import helpers.switchOnUser
import lists.*
import org.testng.annotations.Test
import pages.*
import kotlin.test.assertEquals


class CreateComplaintByTSONOperator (
    private var assert:Boolean = true,
    private var complaintType: String = listOfComplaintTypes[3],
) {
    private val createComplaintPage = CreateComplaintPage()
    private val appealCardPage = AppealCardPage()
    private val mainPage = MainPage()
    private val appealsRegistryTsonPage = AppealsRegistryTsonPage()

    @Test
    fun createComplaintTest() {
        switchOnUser(TSONOperator)

        TSONOperator.page.waitForNavigation { TSONOperator.page.click(mainPage.create_appeal_btn) }
        TSONOperator.page.click(createComplaintPage.complainType_dropdown)
        TSONOperator.page.click("text=$complaintType")
        TSONOperator.page.fill(createComplaintPage.findAppeal_input, applicantsIIN)
        TSONOperator.page.keyboard().press(enter_btn)
        TSONOperator.page.click(createComplaintPage.createComplain_btn)

        TSONOperator.page.click(createComplaintPage.complainForm_dropdown)
        TSONOperator.page.click(createComplaintPage.complainForm)
        TSONOperator.page.click(createComplaintPage.complainLanguage_dropdown)
        TSONOperator.page.click(createComplaintPage.complainLanguage)

        TSONOperator.page.click(createComplaintPage.region_dropdown1)
        TSONOperator.page.click(createComplaintPage.country1)
        TSONOperator.page.click(createComplaintPage.adresat_dropdown1_TSON)
        TSONOperator.page.click(createComplaintPage.adresat1)

        TSONOperator.page.click(createComplaintPage.region_dropdown2)
        TSONOperator.page.click(createComplaintPage.country2)
        TSONOperator.page.click(createComplaintPage.region2)
        TSONOperator.page.click(createComplaintPage.adresat_dropdown2)
        TSONOperator.page.click(createComplaintPage.adresat2)

        TSONOperator.page.click(createComplaintPage.complainTo_dropdown)
        TSONOperator.page.click(createComplaintPage.complainTo)

        TSONOperator.page.click(createComplaintPage.desciption_textarea)
        TSONOperator.page.fill(createComplaintPage.desciption_textarea, complainDescription)
        TSONOperator.page.click(createComplaintPage.complainCharacter_dropdown)
        TSONOperator.page.click(createComplaintPage.appealCharacter)
        TSONOperator.page.fill(createComplaintPage.IIN_input, applicantsIIN)
        TSONOperator.page.fill(createComplaintPage.surname_input, applicantsSurname)
        TSONOperator.page.fill(createComplaintPage.name_input, applicantsName)
        TSONOperator.page.fill(createComplaintPage.address, applicantsAddress)
        TSONOperator.page.fill(createComplaintPage.mobilePhone_input, applicantsMobilePhone)
        TSONOperator.page.click(createComplaintPage.send_btn)
        TSONOperator.page.click(createComplaintPage.NUTS_btn)

        sign()

        complaintNumber = TSONOperator.page.innerText(createComplaintPage.complainNumber_text)
        TSONOperator.page.waitForNavigation { TSONOperator.page.click(createComplaintPage.goToRegistry_btn) }

        if (assert) {
            TSONOperator.page.fill(appealsRegistryTsonPage.appealsSearchTSON_input, complaintNumber)
            TSONOperator.page.keyboard().press(enter_btn)
            TSONOperator.page.waitForNavigation { TSONOperator.page.click(appealsRegistryTsonPage.appealInListTSON) }
            assertEquals(TSONOperator.page.innerText(appealCardPage.cardHead_text), "$complaintType №$complaintNumber")
            assertEquals(TSONOperator.page.innerText(appealCardPage.deadlineOnTSONCard), Dates().calculateAppealDeadline(complaintType))
            println("Test 3.1.2.2 passed ($complaintType $complaintNumber)")
        }
    }
}
