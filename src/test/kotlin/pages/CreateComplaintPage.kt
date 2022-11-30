package pages


class CreateComplaintPage {
    val complainType_dropdown = "text=Выбрать"
    val findAppeal_input = "[placeholder=\"Введите\\ ИИН\\ или\\ номер\\ обращения\"]"
    val createComplain_btn = "button:has-text(\"Создать\")"

    val complainCategory_dropdown = "ng-select div:has-text(\"Введите название категории...\")"
    val complainCategory = "text=АДМИНИСТРАТИВНЫЕ ПРАВОНАРУШЕНИЯ, ОБЩЕСТВЕННАЯ И ДОРОЖНАЯ БЕЗОПАСНОСТЬ"
    val complainSubCategory = "text=Вопросы в сфере оказания государственных услуг"
    val complainForm_dropdown = "text=Форма обращения*Выбрать >> div"
    val complainForm = "text=Бумажная (нарочно)"
    val complainLanguage_dropdown = "text=Выбрать Государственный Официальный Иной >> div"
    val complainLanguage = "text=Официальный"

    val region_dropdown1 = "text=Выберите регион"
    val country1 = "text=Республика Казахстан"
    val region1 = "text=Карагандинская область"
    val adresat_dropdown1 = "text=Наименование органа*Выберите адресат >> span"
    val adresat_dropdown1_TSON = "text=Адресат*Выберите адресат >> input[type=\"text\"]"
    val adresat1 = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 1\")"
    val region_dropdown2 = "#kt_content > div > div > app-appeal-new > div.card.card-custom.gutter-b > div > form > div:nth-child(9) > div:nth-child(1) > div > app-location-picker > div > div"
    val country2 = "text=Выберите регионРеспублика Казахстан >> :nth-match(div, 5)"
    val region2 = "text=Павлодарская область"
    val adresat_dropdown2 = "#kt_content > div > div > app-appeal-new > div.card.card-custom.gutter-b > div > form > div:nth-child(9) > div:nth-child(2) > div > nat-nested-select > div > ng-select > div > div"
    val adresat2 = "div[role=\"option\"]:has-text(\"ГУ Аппарат акима Павлодарской области\")"

    val complainTo_dropdown = "text=Жалоба подается на*Жалоба подается на >> div"
    val complainTo = "text=Административное действие (бездействие), не связанное с принятием административн"
    val desciption_textarea = "textarea"
    val complainCharacter_dropdown = "text=Характер обращения*Выбрать >> div[role=\"combobox\"]"
    val appealCharacter = "text=Индивидуальное"
    val IIN_input = "[placeholder=ИИН]"
    val surname_input = "[placeholder=Фамилия]"
    val name_input = "[placeholder=Имя]"
    val address = "textarea[name=personFactAddress]"
    val mobilePhone_input = "text=Мобильный телефон СМС об ответе придет на указанный номер >> [placeholder=\"+7 000 000 00 00\"]"
    val send_btn = "text=Отправить"
    val NUTS_btn = "text=НУЦ РК"
    val goToRegistry_btn = "text=Перейти в реестр"
    val complainNumber_text = "#kt_body > ngb-modal-window > div > div > div.modal-body > div > div:nth-child(2)"
}


