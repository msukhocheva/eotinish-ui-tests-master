package helpers

import lists.User
import pages.AsideToggle
import pages.MainPage
import tests.Login
import java.lang.Thread.sleep


fun switchOnUser(user: User) {
    user.page.bringToFront()
    if (!user.page.isVisible(AsideToggle().asideToggleFix_btn) && !user.page.isVisible(MainPage().user_avatar)){
        user.page.reload()
        sleep(500)
        if (!user.page.isVisible(AsideToggle().asideToggleFix_btn) && !user.page.isVisible(MainPage().user_avatar)){
            Login(user, false).loginTest()
        }
    }
}
