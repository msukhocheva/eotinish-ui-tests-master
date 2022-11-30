package tests

import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AllTests {
    @Test
    fun test_1_1() {
        Login().loginTest()
    }

     @Test
     fun test_1_2() {
         LoginWithEDS().loginTest()
     }

     @Test
     fun test_2_1() {
         Logout().logoutTest()
     }

     @Test
     fun test_3_1_1_1() {
         CreateAppealByRegistrar().createAppealTest()
     }

     @Test
     fun test_3_1_1_2() {
         CreateAppealByTSONOperator().createAppealTest()
     }

     @Test
     fun test_3_1_2_1() {
         CreateComplaintByRegistrar().createComplaintTest()
     }

     @Test
     fun test_3_1_2_2() {
         CreateComplaintByTSONOperator().createComplaintTest()
     }

     @Test
     fun test_3_2_1() {
         SendToWorkByRegistrarToChief().sendToWorkTest()
     }

     @Test
     fun test_3_2_2() {
         SendToWorkByRegistrarToExecutor().sendToWorkTest()
     }

     @Test
     fun test_3_2_3() {
         SendToWorkByChiefToExecutor().sendToWorkTest()
     }

     @Test
     fun test_3_2_4() {
         SendToWorkByChiefToExecutorAndCoExecutor().sendToWorkTest()
     }

    @Test
    fun test_3_2_5() {
        ReassignExecutor().reassignExecutor()
    }

    @Test
    fun test_3_2_6() {
        ReassignCoExecutor().reassignCoExecutor()
    }

    @Test
    fun test_3_2_7() {
        ReassignExecutorAndCoExecutor().reassignExecutorAndCoExecutor()
    }

    @Test
    fun test_3_2_8() {
        CancelAllResolutions().cancelAllResolutions()
    }

    @Test
    fun test_3_3_1_1(){
         ExecuteAppealsGroupOneWithHearing().executeAppealsGroupOneWithHearing()
     }

    @Test
    fun test_3_3_1_2(){
         ExecuteAppealsGroupTwoWithHearing().executeAppealsGroupTwoWithHearing()
     }

    @Test
    fun test_3_3_2_1(){
         ExecuteAppealsGroupOneWithoutHearing().executeAppealsGroupOneWithoutHearing()
     }

    @Test
    fun test_3_3_2_2(){
         ExecuteAppealsGroupTwoWithoutHearing().executeAppealsGroupTwoWithoutHearing()
     }

    @Test
    fun test_3_4_1(){
        ExecuteComplaintsWithHearing().executeComplaintsWithHearing()
    }

    @Test
    fun test_3_4_2(){
        ExecuteComplaintsWithoutHearing().executeComplaintsWithoutHearing()
    }

    @Test
    fun test_3_5_1(){
        ForwardAppeal().forwardAppealTest()
    }

    @Test
    fun test_3_5_2(){
        ForwardComplaint().forwardComplaintTest()
    }

    @Test
    fun test_3_6_1(){
        Appeal63TSON().appeal63TSONTest()
    }

    @Test
    fun test_3_6_2(){
        Appeal63Registrar().appeal63RegistrarTest()
    }

    @Test
    fun test_3_7_1(){
        Complaint93TSON().complaint93TSONTest()
    }

    @Test
    fun test_3_7_2(){
        Complaint93Registrar().complaint93RegistrarTest()
    }

    @Test
    fun test_3_8_1(){
        ChangeAppealByRegistrar().changeAppealByRegistrarTest()
    }

    @Test
    fun test_3_8_2(){
        ChangeAppealByExecutor().changeAppealByExecutorTest()
    }

    @Test
    fun test_3_10_1(){
        RevokeAppealByRegistrar().revokeAppealByRegistrarTest()
    }

    @Test
    fun test_3_10_2(){
        CancelAppealExecutionAfterRevoke().cancelAppealExecutionAfterRevokeTest()
    }

    @Test
    fun test_3_10_3(){
        ContinueAppealExecutionAfterRevoke().continueAppealExecutionAfterRevokeTest()
    }

    @Test
    fun test_3_10_4(){
        RevokeAppealByTSONOperator().revokeAppealByTSONOperatorTest()
    }

    @Test
    fun test_4_1(){
        CreateAssignmentByRegistrar().createAssignmentByRegistrarTest()
    }

    @Test
    fun test_4_2_1(){
        SendAssignmentToWork1().sendAssignmentToWorkTest()
    }

    @Test
    fun test_4_2_2(){
        SendAssignmentToWork2().sendAssignmentToWorkTest()
    }

    @Test
    fun test_4_2_3(){
        SendAssignmentToWork3().sendAssignmentToWorkTest()
    }

    @Test
    fun test_4_2_4(){
        SendAssignmentToWork4().sendAssignmentToWorkTest()
    }
}
