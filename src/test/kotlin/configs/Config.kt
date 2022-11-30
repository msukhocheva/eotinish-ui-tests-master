package configs

import com.microsoft.playwright.*
import com.microsoft.playwright.options.ScreenshotType
import com.sun.jna.platform.unix.X11
import org.sikuli.script.App
import org.sikuli.script.Screen

val NCALayer = App("NCALayer")
val screen = Screen()
const val viewportWidth = 1650
const val viewportHeight = 1080
const val timeout = 50000.0
var slowMo = 100.0
val playWrite: Playwright = Playwright.create()
var browser: Browser = playWrite.chromium().launch(BrowserType.LaunchOptions().setHeadless(false).setSlowMo(slowMo))
val process: Process = Runtime.getRuntime().exec("ssh -L 127.0.0.1:3333:s2166.j:5432 arystan.amirov@s2684.j")


val org1Executor1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org1Executor2BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org1Executor3BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org1Executor4BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org1Chief1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org1Chief2BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val TSONOperatorBrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org1Controller1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org1Registrar1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))

val org2Registrar1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org2Chief1PageBrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org2Executor1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org2un1Executor1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))

val org3Registrar1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org3Chief1PageBrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org3Executor1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org3ch1Executor1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))
val org3un1Executor1BrowserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(0,0))



val org1Executor1Page: Page = org1Executor1BrowserContext.newPage()
val org1Executor2Page: Page = org1Executor2BrowserContext.newPage()
val org1Executor3Page: Page = org1Executor3BrowserContext.newPage()
val org1Executor4Page: Page = org1Executor4BrowserContext.newPage()
val org1Chief1Page: Page = org1Chief1BrowserContext.newPage()
val org1Chief2Page: Page = org1Chief2BrowserContext.newPage()
val TSONOperatorPage: Page = TSONOperatorBrowserContext.newPage()
val org1ControllerPage: Page = org1Controller1BrowserContext.newPage()
val org1Registrar1Page: Page = org1Registrar1BrowserContext.newPage()

val org2Registrar1Page: Page = org2Registrar1BrowserContext.newPage()
val org2Chief1Page: Page = org2Chief1PageBrowserContext.newPage()
val org2Executor1Page: Page = org2Executor1BrowserContext.newPage()
val org2un1Executor1Page: Page = org2un1Executor1BrowserContext.newPage()

val org3Registrar1Page: Page = org3Registrar1BrowserContext.newPage()
val org3Chief1Page: Page = org3Chief1PageBrowserContext.newPage()
val org3Executor1Page: Page = org3Executor1BrowserContext.newPage()
val org3ch1Executor1Page: Page = org3ch1Executor1BrowserContext.newPage()
val org3un1Executor1Page: Page = org3un1Executor1BrowserContext.newPage()



var org1Chief1Timeout = org1Chief1BrowserContext.setDefaultTimeout(timeout)
var org1Chief2Timeout = org1Chief2BrowserContext.setDefaultTimeout(timeout)
var org1Executor1Timeout = org1Executor1BrowserContext.setDefaultTimeout(timeout)
var org1Executor2Timeout = org1Executor2BrowserContext.setDefaultTimeout(timeout)
var org1Executor3Timeout = org1Executor3BrowserContext.setDefaultTimeout(timeout)
var org1Executor4Timeout = org1Executor4BrowserContext.setDefaultTimeout(timeout)
var org1Registrar1Timeout = org1Registrar1BrowserContext.setDefaultTimeout(timeout)
var TSONOperatorBrowserContextTimeout = TSONOperatorBrowserContext.setDefaultTimeout(timeout)

var org2Registrar1Timeout = org2Registrar1BrowserContext.setDefaultTimeout(timeout)
var org2Chief1Timeout = org2Chief1PageBrowserContext.setDefaultTimeout(timeout)
var org2Executor1Timeout = org2Executor1BrowserContext.setDefaultTimeout(timeout)
var org2un1Executor1Timeout = org2un1Executor1BrowserContext.setDefaultTimeout(timeout)

var org3Registrar1Timeout = org3Registrar1BrowserContext.setDefaultTimeout(timeout)
var org3Chief1Timeout = org3Chief1PageBrowserContext.setDefaultTimeout(timeout)
var org3Executor1Timeout = org3Executor1BrowserContext.setDefaultTimeout(timeout)
var org3ch1Executor1Timeout = org3ch1Executor1BrowserContext.setDefaultTimeout(timeout)
var org3un1Executor1Timeout = org3un1Executor1BrowserContext.setDefaultTimeout(timeout)

val testTimeout = listOf(
    org1Chief1Timeout,
    org1Chief2Timeout,
    org1Executor1Timeout,
    org1Executor2Timeout,
    org1Executor3Timeout,
    org1Executor4Timeout,
    org1Registrar1Timeout,
    org2Registrar1Timeout,
    org2Chief1Timeout,
    org2Executor1Timeout,
    org2un1Executor1Timeout,
    org3Registrar1Timeout,
    org3Chief1Timeout,
    org3Executor1Timeout,
    org3ch1Executor1Timeout,
    org3un1Executor1Timeout,
    TSONOperatorBrowserContextTimeout
)

//const val baseURL = "https://backoffice.dev.eotinish.btsdapps.net/auth/login"
//const val baseURL = "http://localhost:4200/auth/login"
//const val baseURL = "https://backoffice.stg.eotinish.btsdapps.net/auth/login"
const val baseURL = "https://demo.e-otinish.kz/auth/login"

