package helpers

import configs.screen
import lists.User
import pages.AsideToggle
import pages.MainPage
import tests.Login
import java.lang.Thread.sleep


fun attachFile() {
    sleep(500)
    screen.click()
    sleep(500)
    screen.click()
    screen.keyDown("t")
    screen.keyUp("t")
    sleep(800)
    screen.type("\n")
}
