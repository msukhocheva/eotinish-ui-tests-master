package helpers

import lists.listOfAppealAndComplaintIDs
import java.io.File
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*


fun createAppealInDB(
    appealType: String? = ArrayList(listOfAppealAndComplaintIDs.keys)[4],
    appealTypeID: String? = listOfAppealAndComplaintIDs[appealType]) : String
{
    val appealId = getAppealId()
    val randomUUID = getRandomUUID()
    val currentDir = Paths.get("").toAbsolutePath().toString()
    val fileName = "$currentDir/src/test/kotlin/helpers/AppealData.sql"

    if (appealType == ArrayList(listOfAppealAndComplaintIDs.keys)[0] ||
        appealType == ArrayList(listOfAppealAndComplaintIDs.keys)[1] ||
        appealType == ArrayList(listOfAppealAndComplaintIDs.keys)[2] ||
        appealType == ArrayList(listOfAppealAndComplaintIDs.keys)[3]) {
        val sqlString = File(fileName).readText(Charsets.UTF_8)
            //appeals_applications
            .replace("#ID_AA#", appealId)
            .replace("#APPLICANT_ID_AA#", randomUUID)
            .replace("#CREATED_DATE_AA#", Dates().getCurrentDate())
            .replace("#MODIFIED_DATE_AA#", Dates().getCurrentDate())
            .replace("#TYPE_ID_AA#", "$appealTypeID")
            .replace("#COMPLAINT_LOCATION_ID_AA#", "35")
            .replace("#COMPLAINT_ORGANIZATION_ID_AA#", "19899")
            .replace("#COMPLAINT_TYPE_ID_AA#", "'c153d46b-f4cd-413e-bfd8-01005f8fcc92'")
            //appeals_history
            .replace("#ID_AH#", randomUUID)
            .replace("#APPEAL_ID_AH#", appealId)
            .replace("#CREATED_DATE_AH#", Dates().getCurrentDate())
            .replace("#MODIFIED_DATE_AH#", Dates().getCurrentDate())
            .replace("#DATE_AH#", Dates().getCurrentDate())
            //appeals
            .replace("#ID_A#", appealId)
            .replace("#REG_NUMBER_A#", "ЖТ-2022-${appealId.substring(6)}")
            .replace("#SID_A#", randomUUID)
            .replace("#CREATED_DATE_A#", Dates().getCurrentDate())
            .replace("#MODIFIED_DATE_A#", Dates().getCurrentDate())
            .replace("#START_DATE_A#", Dates().getStartDate())
            .replace("#DEADLINE_A#", Dates().transformDate(Dates().calculateAppealDeadline(appealType)))
            //applicants
            .replace("#ID_APPLICANTS#", randomUUID)
            .replace("#CREATED_DATE_APPLICANTS#", Dates().getCurrentDate())
            .replace("#MODIFIED_DATE_APPLICANTS#", Dates().getCurrentDate())

        insertDataToDB(sqlString)
//        println("ЖТ-2022-${appealId.substring(6)}")
    } else {
        val sqlString = File(fileName).readText(Charsets.UTF_8)
            //appeals_applications
            .replace("#ID_AA#", appealId)
            .replace("#APPLICANT_ID_AA#", randomUUID)
            .replace("#CREATED_DATE_AA#", Dates().getCurrentDate())
            .replace("#MODIFIED_DATE_AA#", Dates().getCurrentDate())
            .replace("#TYPE_ID_AA#", "$appealTypeID")
            .replace("#COMPLAINT_LOCATION_ID_AA#", "null")
            .replace("#COMPLAINT_ORGANIZATION_ID_AA#", "null")
            .replace("#COMPLAINT_TYPE_ID_AA#", "null")
            //appeals_history
            .replace("#ID_AH#", randomUUID)
            .replace("#APPEAL_ID_AH#", appealId)
            .replace("#CREATED_DATE_AH#", Dates().getCurrentDate())
            .replace("#MODIFIED_DATE_AH#", Dates().getCurrentDate())
            .replace("#DATE_AH#", Dates().getCurrentDate())
            //appeals
            .replace("#ID_A#", appealId)
            .replace("#REG_NUMBER_A#", "ЖТ-2022-${appealId.substring(6)}")
            .replace("#SID_A#", randomUUID)
            .replace("#CREATED_DATE_A#", Dates().getCurrentDate())
            .replace("#MODIFIED_DATE_A#", Dates().getCurrentDate())
            .replace("#START_DATE_A#", Dates().getStartDate())
            .replace("#DEADLINE_A#", Dates().transformDate(Dates().calculateAppealDeadline(appealType)))
            //applicants
            .replace("#ID_APPLICANTS#", randomUUID)
            .replace("#CREATED_DATE_APPLICANTS#", Dates().getCurrentDate())
            .replace("#MODIFIED_DATE_APPLICANTS#", Dates().getCurrentDate())

        insertDataToDB(sqlString)
//        println("ЖТ-2022-${appealId.substring(6)}")
    }

    return getDataFromDB("SELECT x.* FROM public.appeals x WHERE id = '$appealId'", 2).substring(8)

}

private fun getRandomUUID(): String = UUID.randomUUID().toString()

private fun getAppealId(): String {
    val calendar = Calendar.getInstance()
    val date = SimpleDateFormat("yyMMdd").format(calendar.time)
    val counter = getAppealCounter()
    return "$date$counter"
}

private fun getAppealCounter(): String {
    val counter = getAppealIDFromDB("select nextval('registration_number_seq')")
    insertDataToDB("select nextval('appeal_serial_number_seq')")
    return counter.toString().padStart(8, '0')
}
