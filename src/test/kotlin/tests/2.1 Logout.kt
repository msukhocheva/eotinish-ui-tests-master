package tests

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import lists.org1Registrar1
import pages.*
import java.lang.Thread.sleep


class Logout (private var assert:Boolean = true) {
    private val mainPage = MainPage()
    private val loginPage = LoginPage()

    @Test
    fun logoutTest() {
        org1Registrar1.page.bringToFront()
        if (!org1Registrar1.page.isVisible(mainPage.user_avatar)) {
            Login(assert = false).loginTest()
            org1Registrar1.page.click(mainPage.user_avatar)
            org1Registrar1.page.click(mainPage.logout_text)
        } else {
            org1Registrar1.page.click(mainPage.user_avatar)
            org1Registrar1.page.click(mainPage.logout_text)
        }

        sleep(1000)
        if (assert) {
            assertTrue(org1Registrar1.page.isVisible(loginPage.welcome_text))
            println("Test 2.1     passed")
        }
    }
}
