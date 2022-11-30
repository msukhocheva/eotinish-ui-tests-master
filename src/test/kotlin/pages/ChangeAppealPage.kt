package pages


class ChangeAppealPage {
    val appealType_dropdown = "#kt_content > div > div > app-appeal-new > div.card.card-custom.gutter-b > div > form > div:nth-child(1) > div:nth-child(1) > div > app-select > div > div.pseudo-select"
    val appealForm_dropdown = "text=Выбрать Бумажная (нарочно) >> div[role=\"combobox\"]"
    val appealLanguage_dropdown = "text=Государственный"
    val appealLanguage = "text=Иной"
    val appealCategoryForRegistrar_dropdown = "text=Вопросы в сфере оказания государственных услуг"
    val appealCategoryForExecutor_dropdown = "text=Раздел / Категория*Введите название категории... Вопросы в сфере оказания госуда >> span"
    val appealCategoryForRegistrar = "button:has-text(\"ВОПРОСЫ ГОСУДАРСТВЕННОЙ СЛУЖБЫ, КАДРОВОГО ОБЕСПЕЧЕНИЯ И ЗАНЯТОСТИ НАСЕЛЕНИЯ\")"
    val appealCategoryForExecutor = "text=ВОПРОСЫ ГОСУДАРСТВЕННОЙ СЛУЖБЫ, КАДРОВОГО ОБЕСПЕЧЕНИЯ И ЗАНЯТОСТИ НАСЕЛЕНИЯ"
    val appealCategory1ForExecutor = "text=Занятость населения"
    val appealSubCategoryForRegistrar = "div[role=\"tabpanel\"] >> text=Вопросы государственной службы"
    val appealSubCategoryForExecutor_dropdown = "text=Подкатегория*Выбрать >> span"
    val appealSubCategoryForExecutor = "text=Занятость молодежи"
    val desciption_textarea = "textarea"
    val IIN_input = "[placeholder=ИИН]"
    val address = "textarea[name=personFactAddress]"
    val mobilePhone_input = "text=Мобильный телефон СМС об ответе придет на указанный номер >> [placeholder=\"+7 000 000 00 00\"]"
    val send_btn = "text=Отправить"
    val NUTS_btn = "text=НУЦ РК"
    val saveChanges_btn = "text=Сохранить изменения"
}


