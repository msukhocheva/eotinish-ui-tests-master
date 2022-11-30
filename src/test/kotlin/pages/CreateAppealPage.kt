package pages


class CreateAppealPage {
    val appealType_dropdown = "#kt_content > div > div > app-appeal-new > div.card.card-custom.gutter-b > div > form > div:nth-child(1) > div:nth-child(1) > div > app-select > div > div.pseudo-select"
    val appealSubCategory = "text=Вопросы в сфере оказания государственных услуг"
    val appealForm_dropdown = "text=Форма обращения*Выбрать >> span"
    val appealCategory = "text=АДМИНИСТРАТИВНЫЕ ПРАВОНАРУШЕНИЯ, ОБЩЕСТВЕННАЯ И ДОРОЖНАЯ БЕЗОПАСНОСТЬ"
    val appealLanguage_dropdown = "text=Выбрать Государственный Официальный Иной >> div"
    val appealLanguage = "text=Официальный"
    val appealCategory_dropdown = "text=Введите название категории..."
    val region_dropdown = "text=Выберите регион"
    val country = "text=Республика Казахстан"
    val adresat_dropdown = "text=Адресат*Выберите адресат >> div[role=\"combobox\"]"
    val adresat = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 1\")"
    val desciption_textarea = "textarea"
    val appealCharacter_dropdown = "text=Характер обращения*Выбрать >> :nth-match(div, 2)"
    val appealCharacter = "text=Индивидуальное"
    val IIN_input = "[placeholder=ИИН]"
    val surname_input = "[placeholder=Фамилия]"
    val name_input = "[placeholder=Имя]"
    val address = "textarea[name=personFactAddress]"
    val mobilePhone_input = "text=Мобильный телефон СМС об ответе придет на указанный номер >> [placeholder=\"+7 000 000 00 00\"]"
    val send_btn = "text=Отправить"
    val NUTS_btn = "text=НУЦ РК"
    val goToRegistry_btn = "text=Перейти в реестр"
    val appealNumber_text = "#kt_body > ngb-modal-window > div > div > div.modal-body > div > div:nth-child(2)"
    val saveChanges_btn = "text=Сохранить изменения"
}


