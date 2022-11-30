package pages

import lists.*

class AppealCardPage {
    val cardHead_text = "#kt_subheader > div > div > h5"
    val takeDecision_btn = "text=Принять решение"
    val editAppeal_btn = "text=Редактировать"
    val createAssignment_btn = "text=Поручение/запрос в другой ГО"
    val deadline = "xpath=/html/body/app-layout/div/div/div/div/div/div/app-appeal-registrar-view/div[2]/div[1]/div/div/div[4]/div[5]/div[2]/div[2]"
    val deadline2 = "xpath=/html/body/app-layout/div/div/div/div/div/div/app-appeal-registrar-view/div[2]/div[1]/div/div/div[4]/div[4]/div[2]/div[2]"
    val deadlineOnTSONCard = "xpath=/html/body/app-layout/div/div/div/div/div/div/app-appeal-view/div[2]/div[1]/div/div/div[3]/div[5]/div[2]/div[2]"
    val deadlineOnExecitorCard = "xpath=/html/body/app-layout/div/div/div/div/div/div/app-executor-appeal-view/div[2]/div[1]/div/div/div[4]/div[4]/div[2]/div[2]"
    val sendToWork_btn = "text=Направить в работу"
    val forward_btn = "text=Переадресация в другой ГО"
    val coExecutorsComment_btn = "text=Сформировать ответ"
    val appeal63_btn = "text=Не соответствует 63-й статье"
    val complaint93 = "text=Не соответствует 93-й статье"
    val addAdditionalData_btn = "text=Дополнить данные"
    val changeExecutor = "text=Изменить исполнителя"
    val prolongDeadline_btn = "text= Продлить срок рассмотрения"
    val revokeAppeal_btn = "text=Отозвать обращение"
    val continueExecution_btn = "text=Продолжить рассмотрение"
    val NUTS_btn = "text=НУЦ РК"

    //Common popups
    val region_dropdown = "app-location-picker >> text=Выберите регион"
    val country = "div[role=\"document\"] >> text=Республика Казахстан"
    val adresat_dropdown = "text=Выберите ГО*Выберите адресат >> span"
    val org1 = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 1\")"
    val org2 = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 2\")"
    val org3 = "div[role=\"option\"]:has-text(\"AUTOTEST ORG 3\")"
    val send_btn = "button:has-text(\"Отправить\")"
    val approvers_dropdown = "text=Выбрать согласующихВыбрать согласующих >> span"
    val approver = "div[role=\"option\"]:has-text(\"${org1Chief1.name}\")"
    val appointMyself_text = "text=Назначить себя"
    val signer_dropdown = "text=Выберите подписантаВыбрать подписанта >> div"
    val signer = "div[role=\"option\"]:has-text(\"${org1Chief1.name}\")"

    //Take decision popup
    val selectCategory_dropdown = "#kt_body > ngb-modal-window > div > div > div > div.modal-body > div.mb-12 > div:nth-child(3) > app-category-select > div > div"
    val category = "button:has-text(\"АДМИНИСТРАТИВНЫЕ ПРАВОНАРУШЕНИЯ, ОБЩЕСТВЕННАЯ И ДОРОЖНАЯ БЕЗОПАСНОСТЬ\")"
    val categorySection = "div[role=\"tabpanel\"] >> text=Вопросы в сфере оказания государственных услуг"
    val subCategory_dropdown = "text=Выбрать В сфере дорожного движения >> div[role=\"combobox\"]"
    val subCategory = "div[role=\"option\"]:has-text(\"В сфере дорожного движения\")"
    val hearingWays_input = "textarea[name=\"hearingWay\"]"
    val hearingWaysDescription = "Hearing ways description"
    val attachPreDecision_btn = "text=Прикрепить предв. решение"
    val attachedFilename_input = "[placeholder=\"Название\"]"
    val attachedFilename = "Predecision file"
    val sendNotice_btn = "text=Отправить извещение"
    val sendNoticeConfirmation_btn = "text=Принять решениеВы уверены, что хотите отправить извещение?Отправить извещениеОтм >> button"
    val hearingHeld_btn = "text=Заслушивание проведено"
    val attachFile_btn = "text=Прикрепить файл"
    val hearingHeld_dropdown = "text=Будете проводить заслушивание участника адм. процедуры?* Да >> span"
    val hearingHeldNo = "text=Нет"
    val hearingNotHeldReason_input = "textarea[name=\"hearingNotHeldReason\"]"
    val hearingNotHeldReason = "Hearing not held reason"
    val takeFinalDecision = "text=Принять окончательное решение"
    val decisionSelectForHearing_dropdown = "#kt_body > ngb-modal-window > div > div > div > div.modal-body > div:nth-child(4) > div > div > ng-select > div > span"
    val decisionSelectForNotHearing_dropdown = "#kt_body > ngb-modal-window > div > div > div > div.modal-body > div:nth-child(7) > div > div > ng-select > div > span"
    val answerText_input = "textarea[name=\"message\"]"
    val answerText = "Answer text"
    val saveDecision_btn = "text=Сохранить"
    val sendToApprove_btn = "text=Отправить на согласование"
    val selectApprovers_dropdown = "text=Выбрать согласующегоВыбрать >> span"
    val selectSigner_dropdown = "text=Выбрать подписантаВыбрать× >> :nth-match(span, 3)"
    val sendToApproveAndSign_btn = "div[role=\"document\"] button:has-text(\"Отправить\")"
    val approve_btn = "button:has-text(\"Согласовать\")"
    val approveConfirm_btn = "div[role=\"document\"] button:has-text(\"Согласовать\")"
    val signDecision_btn = "button:has-text(\"Подписать\")"
    val signDecisionConfirm_btn = "div[role=\"document\"] button:has-text(\"Подписать\")"
    //for appeals
    val decisionType1 = "div[role=\"option\"]:has-text(\"Принять к сведению\")"
    val decisionType2 = "div[role=\"option\"]:has-text(\"Прекратить рассмотрение\")"
    val decisionType3 = "div[role=\"option\"]:has-text(\"Предоставить ответ\")"
    val decisionType4 = "div[role=\"option\"]:has-text(\"Принять благоприятный административный акт\")"
    val decisionType5 = "div[role=\"option\"]:has-text(\"Принять обременяющий административный акт\")"
    val reasonSelect_dropdown = "text=ПричинаВыбрать >> span"
    val reasonType1 = "text=в сообщении, предложении, отклике, запросе не изложена суть вопроса"
    val reasonType2 = "text=в повторных сообщениях, предложениях, откликах, запросах не приводятся новые доводы или вновь открывшиеся обстоятельства, а в материалах предыдущих сообщения, предложения, отклика, запроса имеются необходимые материалы проверок и заявителю в установленном порядке давались ответы"
    val reasonType3 = "text=в сообщении, предложении, отклике, запросе невозможно установить авторство, отсутствуют подпись, в том числе электронная цифровая подпись, почтовый адрес заявителя, за исключением случаев, когда в них содержатся сведения о готовящихся или совершенных уголовных правонарушениях либо об угрозе государственной или общественной безопасности, которые подлежат немедленному перенаправлению в государственные органы в соответствии с их компетенцией"
    val reasonType4 = "text=административным органом, должностным лицом принят отзыв сообщения, предложения, отклика, запроса от заявителя"
    val reasonType5 = "text=административным органом, должностным лицом возвращено обращение"
    val reasonType6 = "text=административным органом, должностным лицом принят отзыв обращения от заявителя"
    val reasonType7 = "text=имеется вступивший в законную силу судебный акт, вынесенный в отношении того же лица, о том же предмете и по тем же основаниям"
    val reasonType8 = "text=имеется решение административного органа, должностного лица по административному делу в отношении участника административной процедуры о том же предмете и по тем же основаниям, которые указаны в обращении"
    val reasonType9 = "text=имеются иные основания, предусмотренные законами Республики Казахстан"
    val answerCharacter1 = "text=Разъяснено"
    val answerCharacter2 = "text=Удовлетворено"
    val answerCharacter3 = "text=Отказано"
    val characterSelect_dropdown = "text=Характер ответаХарактер ответа >> span"
    //for complaints
    val basisForDecisionSelect_dropdown = "text=Основание для вынесения решенияВыбрать >> span"
    val decisionType6 = "div[role=\"option\"]:has-text(\"Направить административное дело в административный орган, должностному лицу, чьи административный акт, административное действие (бездействие) обжалуются, для осуществления административной процедуры с указанием допущенных нарушений и предложениями по их устранению\")"
    val decisionType7 = "div[role=\"option\"]:has-text(\"Оставить жалобу без удовлетворения\")"
    val decisionType8 = "div[role=\"option\"]:has-text(\"О совершении административного действия\")"
    val decisionType9 = "div[role=\"option\"]:has-text(\"Отменить административный акт и принять новый административный акт\")"
    val decisionType10 = "div[role=\"option\"]:has-text(\"Отменить административный акт\")"
    val decisionType11 = "div[role=\"option\"]:has-text(\"Оставить жалобу без рассмотрения\")"
    val decisionType12 = "div[role=\"option\"]:has-text(\"Принять благоприятный административный акт, совершено административное действие, полностью удовлетворяющие требования, указанные в жалобе\")"
    val basisForDecision1 = "text=неправильное определение и выяснение круга обстоятельств, имеющих значение для правильного рассмотрения административного дела"
    val basisForDecision2 = "text=несоответствие содержания административного акта, административного действия (бездействия) материалам административного дела"
    val basisForDecision3 = "text=нарушение или неправильное применение законодательства Республики Казахстан"
    val reason10 = "text=имеется вступивший в законную силу судебный акт, вынесенный в отношении того же лица, о том же предмете и по тем же основаниям"
    val reason11 = "text=органом, рассматривающим жалобу, возвращена жалоба"
    val reason12 = "text=органом, рассматривающим жалобу, принят отзыв жалобы от заявителя"
    val reason13 = "text=имеется решение органа, рассматривающего жалобу, по результатам рассмотрения жалобы в отношении участника административной процедуры о том же предмете и по тем же основаниям, указанным в жалобе"


    //Assignment create Popup
    val addCoExecutor_text = "text=Добавить организацию-соисполнителя"
    val region2_dropdown = ":nth-match(:text(\"Выберите регион\"), 3)"
    val country2 = ":nth-match(:text(\"Республика Казахстан\"), 3)"
    val adresat2_dropdown = ".ng-custom-select.ng-select.ng-select-single.ng-select-searchable.ng-select-clearable.ng-untouched .ng-select-container"
    val deadline_input = "#kt_body > ngb-modal-window > div > div > div.modal-body > form > div:nth-child(2) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(1) > div > input"
    val responsibleWorker_dropdown = "text=Ответственный сотрудникВыбрать ответственного сотрудника >> input[type=\"text\"]"
    val responsibleWorker = "div[role=\"option\"]:has-text(\"${org1Chief1.name}\")"

    //Appeal send to work Popup
    val responsibleSpecialist_dropdown = "text=Ответственный специалистВыбрать исполнителя >> input[type=\"text\"]"
    val newStructuralSubdivision_dropdown = "text=Структурное подразделениеВыбрать исполнителя >> input[type=\"text\"]"
    val addCoExecutor = "text=Добавить соисполнителя"
    val deleteCoExecutor_btn = "text=Удалить"
    val coExecutorOrg_dropdown = "text=Соисполнитель 1УдалитьСтруктурное подразделениеВыбрать исполнителяОтветственный  >> input[type=\"text\"]"
    val coExecutor_dropdown = "app-add-executor-list >> text=Ответственный специалистВыбрать исполнителя >> input[type=\"text\"]"
    val org1_Chief1 = "div[role=\"option\"]:has-text(\"${org1Chief1.name}\")"
    val org1_Executor1 = "div[role=\"option\"]:has-text(\"${org1Executor1.name}\")"
    val org1_Executor2 = "div[role=\"option\"]:has-text(\"${org1Executor2.name}\")"
    val org1_Executor3 = "div[role=\"option\"]:has-text(\"${org1Executor3.name}\")"
    val org1_Executor4 = "div[role=\"option\"]:has-text(\"${org1Executor4.name}\")"
    val appoint_btn = "text=Назначить"


    //Appeal forward Popup
    val forwardPartly_checkbox = "text=Перенаправить в части >> span"
    val forwardFully_checkbox = "text=Перенаправить полностью >> span"
    val approveForwarding_btn = "text=Согласовать переадресацию"
    val approveForwarding_btn_popup = "div[role=\"document\"] button:has-text(\"Согласовать\")"
    val signForwarding_btn = "text=Подписать переадресацию"
    val sign_btn = "#kt_body > ngb-modal-window > div > div > div > div.modal-footer.justify-content-center.pb-10.pt-0.border-0 > button.btn.btn-primary.mr-4.pl-10.pr-10"

    //Edit Popup
    val ok = "text=Хорошо"

    //Appeal63 popup
    val appeal63Reasons_input = "textarea[name=\"message\"]"
    val appeal63Deadline_input = "#kt_body > ngb-modal-window > div > div > div.modal-body > div > div:nth-child(2) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(1) > div > input"
    val sendNotice63_btn = "text=Отправить извещение"

    val complaint93Reasons_input = "textarea[name=\"message\"]"
    val complaint93Deadline_input = "#kt_body > ngb-modal-window > div > div > div.modal-body > div > div:nth-child(2) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(1) > div > input"
    val sendNotice93_btn = "text=Отправить извещение"

    val additionalData_input = "textarea[name=\"message\"]"
    val sendAppeal_btn = "text=Отправить обращение"

    //Prolong deadline popup
    val dateInput = "xpath=/html/body/ngb-modal-window/div/div/div[1]/form/div[1]/div/div/div/dp-date-picker/div[1]/div/input"
    val removeReadonly = "(el, value) => el.removeAttribute(\"readonly\")"
    val prolongReason_input = "textarea"
    val prolongReason = "Prolong reason"
    val prolongApprovers_dropdown = "text=Выбрать согласующихВыбрать согласующих >> span"
    val prolongApprover = "div[role=\"option\"]:has-text(\"${org1Chief1.name}\")"
    val prolongSigner_dropdown = "text=Выберите подписантаВыбрать подписанта >> span"
    val prolongSigner = "div[role=\"option\"]:has-text(\"${org1Chief1.name}\")"
    val prolongAppove_btn = "text=Согласовать продление срока"
    val prolongApproveConfirmation_btn = "div[role=\"document\"] button:has-text(\"Согласовать\")"
    val prolongSign_btn = "text=Подписать продление срока"

    //Appeal revoke popup
    val revokeComment_input = "textarea"
    val attachRevokeDocs_btn = "text=Прикрепить документы"
    val createRevoke_btn = "button:has-text(\"Создать\")"
    val reasonOfRevokeCancellation_input = "textarea"
    val reasonOfRevokeCancellation = "Reason of revoke cancellation"
    val yes_btn = "button:has-text(\"Да\")"





    //Statuses
    val statusAppealForwarding = "#kt_content > div > div > app-executor-appeal-view > div.row > div.col-md-5.col-xxl-4 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--IN_PROGRESS.is--START_FORWARD > div.i2-timeline__status"
    val statusAppealForwardingApproved = "#kt_content > div > div > app-executor-appeal-view > div.row > div.col-md-5.col-xxl-4 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--APPROVE_FORWARD.is--IN_PROGRESS > div.i2-timeline__status"
    val statusAppealForwardingSigned = "#kt_content > div > div > app-executor-appeal-view > div.row > div.col-md-5.col-xxl-4 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--FORWARD_SIGNED.is--IN_PROGRESS > div.i2-timeline__status"
    val statusAppealForwardedPartly = "#kt_content > div > div > app-executor-appeal-view > div.row > div.col-md-5.col-xxl-4 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--FORWARD_PARTIAL.is--IN_PROGRESS > div.i2-timeline__status"
    val statusAppealForwardedFully = "#kt_content > div > div > app-executor-appeal-view > div.row > div.col-md-5.col-xxl-4 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--FORWARD.is--IN_PROGRESS > div.i2-timeline__status"
    val statusAppealFinished = "#kt_content > div > div > app-executor-appeal-view > div.row > div.col-md-5.col-xxl-4 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--CHANGE_STATUS.is--FINISHED > div.i2-timeline__status"
    val statusSendToWorkFromReg1ToChief1Text = "text= Автор резолюции: Регистратор-1 (Org.1) ( - AUTOTEST ORG 1) \n" +
            "Исполнитель: Руководитель-1 (Org.1) (  - AUTOTEST ORG 1)\n" +
            " "
    val statusSendToWorkFromReg1ToExec1Text = "text= Автор резолюции: Регистратор-1 (Org.1) ( - AUTOTEST ORG 1) \n" +
            "Исполнитель: Исполнитель-1 (Org.1) (  - AUTOTEST ORG 1)\n" +
            " "
    val statusSendToWorkFromChief1ToExec1Text = "text= Автор резолюции: Руководитель-1 (Org.1) ( - AUTOTEST ORG 1) \n" +
            "Исполнитель: Исполнитель-1 (Org.1) (  - AUTOTEST ORG 1)\n" +
            " "
    val statusSendToWorkFromChief1ToExec2Text = "text= Автор резолюции: Руководитель-1 (Org.1) ( - AUTOTEST ORG 1) \n" +
            "Исполнитель: Исполнитель-2 (Org.1) (  - AUTOTEST ORG 1)\n" +
            " "
    val statusSendToWorkFromChief1ToExec1AndExec2Text = "text= Автор резолюции: Руководитель-1 (Org.1) ( - AUTOTEST ORG 1) \n" +
            "Исполнитель: Исполнитель-1 (Org.1) (  - AUTOTEST ORG 1)\n" +
            "Соисполнитель: Исполнитель-2 (Org.1) (  - AUTOTEST ORG 1) "
    val statusSendToWorkFromChief1ToExec1AndExec3Text = "text= Автор резолюции: Руководитель-1 (Org.1) ( - AUTOTEST ORG 1) \n" +
            "Исполнитель: Исполнитель-1 (Org.1) (  - AUTOTEST ORG 1)\n" +
            "Соисполнитель: Исполнитель-2 (Org.1) (  - AUTOTEST ORG 1) "
    val statusAligned = "#kt_content > div > div > app-executor-appeal-view > div.row > div.col-md-5.col-xxl-4 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--CHECK_93_FIXED.is--IN_PROGRESS > div.i2-timeline__status"
    val statusRevokedByRegistrar = "#kt_content > div > div > app-appeal-registrar-view > div.row > div.col-md-5.col-xxl-4 > div > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--FINISHED.is--REVOKED.ng-star-inserted > div.i2-timeline__status"
    val statusRevokedByExecutor = "#kt_content > div > div > app-executor-appeal-view > div.row > div.col-md-5.col-xxl-4 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--FINISHED.is--REVOKED > div.i2-timeline__status"
    val statusRevokeByTSONOperator = "#kt_content > div > div > app-appeal-view > div.row > div.col-md-5.col-xxl-4.mb-8 > div > app-appeal-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--FINISHED.is--REVOKED.ng-star-inserted > div.i2-timeline__status"
}
