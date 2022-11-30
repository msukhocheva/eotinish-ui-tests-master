package helpers

import lists.org1Registrar1
import pages.*
import java.lang.Thread.sleep

private val mainPage = MainPage()
private val loginPage = LoginPage()

fun logout() {
    if (org1Registrar1.page.isVisible(mainPage.user_avatar)) {
        org1Registrar1.page.click(mainPage.user_avatar)
        org1Registrar1.page.click(mainPage.logout_text)
        sleep(1000)
        org1Registrar1.page.waitForSelector(loginPage.welcome_text)
    } else {
        org1Registrar1.page.click(mainPage.TSONOperator_avatar)
        org1Registrar1.page.click(mainPage.logout_text)
        sleep(1000)
        org1Registrar1.page.waitForSelector(loginPage.welcome_text)
    }
}
