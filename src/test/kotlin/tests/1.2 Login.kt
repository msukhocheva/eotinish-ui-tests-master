package tests

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import org.sikuli.basics.Settings
import java.lang.Thread.sleep
import configs.*
import helpers.*
import lists.*
import pages.*


class LoginWithEDS (
    private val user: User = org1Chief2,
    private var assert: Boolean = true,
) {
    private val mainPage = MainPage()
    private val asideToggle = AsideToggle()
    private val loginPage = LoginPage()

    @Test
    fun loginTest() {
        Settings.ActionLogs = false
        user.page.setViewportSize(viewportWidth, viewportHeight)
        user.page.navigate(baseURL)
        testTimeout

        user.page.bringToFront()
        sleep(800)
        if (user.page.isVisible(mainPage.user_avatar)) {
            logout()
        }
        sleep(800)
        if (user.page.isVisible(loginPage.ok_btn)) user.page.click(loginPage.ok_btn)
        sleep(500)
        if (user.page.isVisible(loginPage.ok_btn)) user.page.click(loginPage.ok_btn)
        user.page.click(mainPage.language_ru_text)
        user.page.click(loginPage.eotinish_gov_kz_btn)
        user.page.fill(loginPage.login_input, user.IIN)
        user.page.fill(loginPage.password_input, user.password)
        user.page.click(loginPage.login_ru_btn)
        user.page.click(loginPage.selectCert_ru_btn)

        auth()

        user.page.waitForSelector(asideToggle.asideToggleFix_btn)
        if (assert) {
            assertTrue(user.page.isVisible(mainPage.user_name))
            assertTrue(user.page.isVisible(asideToggle.asideToggleFix_btn))
        }

        user.page.click(mainPage.user_avatar)
        user.page.click(mainPage.logout_text)

        user.page.click(loginPage.eotinish_gov_kz_btn)
        user.page.click(loginPage.loginPassword_ru_text)
        user.page.click(loginPage.selectCert_ru_btn)

        auth()

        user.page.fill(loginPage.login_input, user.IIN)
        user.page.fill(loginPage.password_input, user.password)
        user.page.click(loginPage.login_ru_btn)

        user.page.waitForSelector(asideToggle.asideToggleFix_btn)
        if (assert) {
            assertTrue(user.page.isVisible(mainPage.user_name))
            assertTrue(user.page.isVisible(asideToggle.asideToggleFix_btn))
            println("Test 1.2     passed")
        }
    }
}
