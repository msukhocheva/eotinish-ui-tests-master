package helpers

import configs.NCALayer

import configs.password
import configs.screen

import java.lang.Thread.sleep


fun sign() {
    NCALayer.focus()
    sleep(500)
    screen.type("RSA.p12")
    sleep(300)
    screen.type("\n")
    sleep(300)
    screen.type(password)
    screen.type("\n")
    screen.type("\n")
    NCALayer.reset()
}

fun auth() {
    NCALayer.focus()
    sleep(500)
    screen.type("AUTH.p12")
    sleep(300)
    screen.type("\n")
    sleep(300)
    screen.type(password)
    screen.type("\n")
    screen.type("\n")
    NCALayer.reset()
}
