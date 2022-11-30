package pages

import lists.*


class AssignmentCardPage {
    val assignmentApprove1_btn = "text=Cогласовать ответ >> nth=0"
    val assignmentApprove2_btn = "text=Cогласовать ответ"
    val approve_btn_popup = "button:has-text(\"Согласовать\")"
    val sign_btn = "button:has-text(\"Подписать\")"
    val sendToWork_btn = "text=Направить в работу"
    val answerOnAssignment_btn = "text=Ответить на поручение"
    val noted_btn = "text=Принято к сведению"
    val assignmentDeadline = "#mat-tab-content-1-0 > div > div:nth-child(1) > div.field.col-lg-4.ng-star-inserted > div.field__value"
    val createAdditionalAssignment_btn = "#kt_content > div > div > app-view > div.row > div.col-md-7.col-xxl-8 > div > div > div.d-flex.border-top.flex-wrap.pt-10 > app-create-assignment > button"
    val approveAdditionalAssignment_btn = "text=Cогласовать"
    val additionalAssignmentDeadline = "#kt_content > div > div > app-view > div.row > div.col-md-7.col-xxl-8 > app-additional-assignment-list > div:nth-child(1) > div > section > div:nth-child(1) > div:nth-child(3) > div.field__value"
    val innerDeadline = "#kt_content > div > div > app-view > div.row > div.col-md-7.col-xxl-8 > div > div > div:nth-child(4) > div:nth-child(2) > div.field__value"

    //Send to work popup
    val responsibleExecutor_dropdown = ":nth-match(:text(\"Ответственный специалистВыбрать исполнителя\"), 1)"
    val responsibleCoExecutor1_dropdown = ":nth-match(:text(\"Ответственный специалистВыбрать исполнителя\"), 2)"
    val responsibleCoExecutor2_dropdown = ":nth-match(:text(\"Ответственный специалистВыбрать исполнителя\"), 3)"
    val org2_Executor1 = "div[role=\"option\"]:has-text(\"${org2Executor1.name}\")"
    val org2un1_Executor1 = "div[role=\"option\"]:has-text(\"${org2un1Executor1.name}\")"
    val org3_Chief1 = "div[role=\"option\"]:has-text(\"${org3Chief1.name}\")"
    val org3_Executor1 = "div[role=\"option\"]:has-text(\"${org3Executor1.name}\")"
    val org3ch1_Executor1 = "div[role=\"option\"]:has-text(\"${org3ch1Executor1.name}\")"
    val org3un1_Executor1 = "div[role=\"option\"]:has-text(\"${org3un1Executor1.name}\")"
    val executorForOrg3_dropdown = "text=Выбрать исполнителя×AUTOTEST ORG 3 >> input[type=\"text\"]"
    val addCoExecutor_btn = "text=Добавить соисполнителя"
    val coExecutor1Org_dropdown =  "text=Соисполнитель 1УдалитьСтруктурное подразделениеВыбрать исполнителяОтветственный  >> input[type=\"text\"]"
    val coExecutor2Org_dropdown = "text=Соисполнитель 1УдалитьСтруктурное подразделениеВыбрать исполнителя×AUTOTEST ORG  >> :nth-match(input[type=\"text\"], 3)"
    val coExecutorOrg = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 2 (Unit 1)\")"
    val org3 = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 3\")"
    val org3ch1 = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 3 (Child 1)\")"
    val org3un1 = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 3 (Unit 1)\")"
    val assignmentInnerDeadline_input = "#kt_body > ngb-modal-window > div > div > div.modal-body > div > div:nth-child(4) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(1) > div > input"
    val removeReadonly = "(el, value) => el.removeAttribute(\"readonly\")"
    val assign_btn = "text=Назначить"


    //Answer to assignment popup
    val requestToProlong_btn = "label:has-text(\"Запрос на продление срока\")"
    val answerText_input = "textarea"
    val answerFromOrg2Executor1 = "Answer from org2Executor1"
    val answerFromOrg2Un1Executor1 = "Answer from org2un1Executor1"
    val requestToProlongFromOrg2Executor1 = "Request to prolong from org2Executor1"
    val requestToProlongFromOrg2Un1Executor1 = "Request to prolong from org2un1Executor1"
    val answersFromCoExecutors = "text=Ответы соисполнителей"
    val attachFile_btn = "text=Прикрепить документы"
    val fileName_input = "[placeholder=\"Название\"]"
    val fileFromOrg2Executor1 = "File from org2Executor1"
    val sendToApprove_btn = "text=Отправить на согласование ответ на поручение"
    val send_btn = "text=Отправить"


    //Send to approve and sign popup
    val approvers_dropdown = "text=Выбрать согласующихВыбрать согласующих >> span"
    val approverOrg2Chief1 = "div[role=\"option\"]:has-text(\"${org2Chief1.name}\")"
    val signers_dropdown = "text=Выберите подписантаВыбрать подписанта >> span"
    val signerOrg2Chief1 = "[aria-label=\"Options list\"] >> text=${org2Chief1.name}"
    val sendToApproveAndSign_btn = "div[role=\"document\"] >> text=Отправить"
    val NUTS_btn = "text=НУЦ РК"

    //Statuses
    val statusAssignmentCreated = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--CREATED_DRAFT.is--DRAFT > div.i2-timeline__status"
    val statusAssignmentApproved = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--APPROVE_DRAFT.is--DRAFT > div.i2-timeline__status"
    val statusAssignmentSigned = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--CHECK.is--SIGN_DRAFT > div.i2-timeline__status"
    val statusAssignmentChecked = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--CHECKED > div.i2-timeline__status"
    val statusAdditionalAssignmentCreated = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--CREATED_ADDITIONAL_ASSIGNMENT > div.i2-timeline__status"
    val statusAdditionalAssignmentApproved = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--APPROVE_ADDITIONAL_ASSIGNMENT > div.i2-timeline__status"
    val statusAdditionalAssignmentSigned = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--SIGN_ADDITIONAL_ASSIGNMENT > div.i2-timeline__status"


    //Create additional assignment popup
    val region_dropdown = "app-location-picker >> text=Выберите регион"
    val country = "text=Республика Казахстан"
    val adresat_dropdown = "text=Выберите ГО*Выберите адресат >> span"
    val adresat = "[aria-label=\"Options\\ list\"] >> text=Агентство по защите и развитию конкуренции (АЗРК)"
    val addCoExecutor_text = "text=Добавить организацию-соисполнителя"
    val region2_dropdown = ":nth-match(:text(\"Выберите регион\"), 3)"
    val country2 = ":nth-match(:text(\"Республика Казахстан\"), 2)"
    val adresat2_dropdown = ".ng-custom-select.ng-select.ng-select-single.ng-select-searchable.ng-select-clearable.ng-untouched .ng-select-container"
    val adresat2 = "[aria-label=\"Options\\ list\"] >> text=Министерство финансов Республики Казахстан"
    val deadline_input = "#kt_body > ngb-modal-window > div > div > div.modal-body > form > div:nth-child(2) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(1) > div > input"
    val changeMonth_btn = "#kt_body > ngb-modal-window > div > div > div.modal-body > form > div:nth-child(2) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(2) > div > dp-day-calendar > div > dp-calendar-nav > div > div.dp-nav-btns-container > div.dp-calendar-nav-container-right"
    val appointSigner_text = "text=Назначить себя"
    val approver = "div[role=\"option\"]:has-text(\"Замакима 5\")" //"div[role=\"option\"]:has-text(\"Аким Карагандинской области\")"
}
