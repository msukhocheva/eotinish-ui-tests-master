package tests

import helpers.Dates
import helpers.sign
import helpers.switchOnUser
import lists.*
import org.testng.annotations.Test
import pages.*
import kotlin.test.assertEquals


var complaintNumber = ""
var complaintTypeName = ""

class CreateComplaintByRegistrar (
    private var assert:Boolean = true,
    private var complaintType: String = listOfComplaintTypes[1]
) {
    private val createComplaintPage = CreateComplaintPage()
    private val createAppealPage = CreateAppealPage()
    private val appealCardPage = AppealCardPage()
    private val mainPage = MainPage()
    private val registeredAppealsListPage = RegisteredAppealsListPage()

    @Test
    fun createComplaintTest() {
        switchOnUser(org1Registrar1)

        org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(mainPage.create_appeal_btn) }
        org1Registrar1.page.click(createComplaintPage.complainType_dropdown)
        org1Registrar1.page.click("text=$complaintType")
        complaintTypeName = complaintType

        org1Registrar1.page.fill(createComplaintPage.findAppeal_input, applicantsIIN)
        org1Registrar1.page.keyboard().press(enter_btn)
        org1Registrar1.page.click(createComplaintPage.createComplain_btn)

        org1Registrar1.page.click(createComplaintPage.complainForm_dropdown)
        org1Registrar1.page.click(createComplaintPage.complainForm)
        org1Registrar1.page.click(createComplaintPage.complainLanguage_dropdown)
        org1Registrar1.page.click(createComplaintPage.complainLanguage)

        org1Registrar1.page.click(createComplaintPage.region_dropdown2)
        org1Registrar1.page.click(createComplaintPage.country2)
        org1Registrar1.page.click(createComplaintPage.region2)
        org1Registrar1.page.click(createComplaintPage.adresat_dropdown2)
        org1Registrar1.page.click(createComplaintPage.adresat2)

        org1Registrar1.page.click(createComplaintPage.complainTo_dropdown)
        org1Registrar1.page.click(createComplaintPage.complainTo)

        org1Registrar1.page.click(createComplaintPage.desciption_textarea)
        org1Registrar1.page.fill(createComplaintPage.desciption_textarea, complainDescription)

        org1Registrar1.page.click(createAppealPage.appealCategory_dropdown)
        org1Registrar1.page.click(createAppealPage.appealCategory)
        org1Registrar1.page.click(createAppealPage.appealSubCategory)

        org1Registrar1.page.click(createComplaintPage.complainCharacter_dropdown)
        org1Registrar1.page.click(createComplaintPage.appealCharacter)
        org1Registrar1.page.fill(createComplaintPage.IIN_input, applicantsIIN)
        org1Registrar1.page.fill(createComplaintPage.surname_input, applicantsSurname)
        org1Registrar1.page.fill(createComplaintPage.name_input, applicantsName)
        org1Registrar1.page.fill(createComplaintPage.address, applicantsAddress)
        org1Registrar1.page.fill(createComplaintPage.mobilePhone_input, applicantsMobilePhone)
        org1Registrar1.page.click(createComplaintPage.send_btn)
        org1Registrar1.page.click(createComplaintPage.NUTS_btn)

        sign()

        complaintNumber = org1Registrar1.page.innerText(createComplaintPage.complainNumber_text)
        org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(createComplaintPage.goToRegistry_btn) }

        if (assert) {
            org1Registrar1.page.click(registeredAppealsListPage.appealsSearch_input)
            org1Registrar1.page.fill(registeredAppealsListPage.appealsSearch_input, complaintNumber.substring(3))
            org1Registrar1.page.keyboard().press(enter_btn)
            org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(registeredAppealsListPage.firstAppealInList) }
            assertEquals(org1Registrar1.page.innerText(appealCardPage.cardHead_text), "$complaintType №$complaintNumber")
            assertEquals(org1Registrar1.page.innerText(appealCardPage.deadline), Dates().calculateAppealDeadline(complaintType))
            println("Test 3.1.2.1 passed ($complaintTypeName $complaintNumber)")
        }
    }
}
