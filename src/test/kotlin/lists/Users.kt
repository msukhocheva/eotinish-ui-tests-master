package lists

import com.microsoft.playwright.Page
import configs.*


data class User (
    val name: String,
    val IIN: String,
    val password: String,
    val page: Page
)

//Org.1
val org1Registrar1 = User(
    "Регистратор-1 (Org.1)",
    "111100000001",
    "111100000001",
    org1Registrar1Page
)

val org1Chief1 = User(
    "Руководитель-1 (Org.1)",
    "111100000002",
    "111100000002",
    org1Chief1Page
)

val org1Chief2 = User(
    "Руководитель-2 (Org.1)",
    "800329300581",
    "800329300581",
    org1Chief2Page
)


val org1Executor1 = User(
    "Исполнитель-1 (Org.1)",
    "111100000003",
    "111100000003",
    org1Executor1Page
)

val org1Executor2 = User(
    "Исполнитель-2 (Org.1)",
    "111100000033",
    "111100000033",
    org1Executor2Page
)

val org1Executor3 = User(
    "Исполнитель-3 (Org.1)",
    "111100000333",
    "111100000333",
    org1Executor3Page
)

val org1Executor4 = User(
    "Исполнитель-4 (Org.1)",
    "111100003333",
    "111100003333",
    org1Executor4Page
)

val org1Controller1 = User(
    "Контролер-1 (Org.1)",
    "111100000004",
    "111100000004",
    org1ControllerPage
)

val TSONOperator = User(
    "Оператор ЦОНа",
    "111100000005",
    "111100000005",
    TSONOperatorPage
)

//Org.2
val org2Registrar1 = User(
    "Регистратор-1 (Org.2)",
    "222200000001",
    "222200000001",
    org2Registrar1Page
)

val org2Chief1 = User(
    "Руководитель-1 (Org.2)",
    "222200000002",
    "222200000002",
    org2Chief1Page
)

val org2Executor1 = User(
    "Исполнитель-1 (Org.2)",
    "222200000003",
    "222200000003",
    org2Executor1Page
)

//Org.2 Un.1
val org2un1Executor1 = User(
    "Исполнитель-1 (Org.2 Un.1)",
    "222230000003",
    "222230000003",
    org2un1Executor1Page
)

//Org.3
val org3Registrar1 = User(
    "Регистратор-1 (Org.3)",
    "333300000001",
    "333300000001",
    org3Registrar1Page
)

val org3Chief1 = User(
    "Руководитель-1 (Org.3)",
    "333300000002",
    "333300000002",
    org3Chief1Page
)

val org3Executor1 = User(
    "Исполнитель-1 (Org.3)",
    "333300000003",
    "333300000003",
    org3Executor1Page
)

//Org.3 Ch.1
val org3ch1Executor1 = User(
    "Исполнитель-1 (Org.3 Ch.1)",
    "333310000003",
    "333310000003",
    org3ch1Executor1Page
)

//Org.3 Un.1
val org3un1Executor1 = User(
    "Исполнитель-1 (Org.3 Un.1)",
    "333330000003",
    "333330000003",
    org3un1Executor1Page
)