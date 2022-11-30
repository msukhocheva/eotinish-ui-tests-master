package helpers

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

private val statement: Statement = connectDB().createStatement()

fun connectDB(): Connection {
    return DriverManager.getConnection(
        "jdbc:postgresql://localhost:3333/eotinish",
        "eotinish",
        "MDg3YWUzNWI4N2IzYTQxMzgzMDAxMWU0"
    )
}

fun insertDataToDB (sqlString: String) {
    statement.execute(sqlString)
}

fun getDataFromDB(sqlString: String, columnIndex: Int) : String {
    var data = ""
    val resultSet: ResultSet = statement.executeQuery(sqlString)
    while (resultSet.next()) {
        data = resultSet.getString(columnIndex)
    }
    return data
}

fun getAppealIDFromDB(sqlString: String) : Int {
    var regNumber = 0
    val resultSet: ResultSet = statement.executeQuery(sqlString)
    while (resultSet.next()) {
        regNumber = resultSet.getInt(1)
    }
    return regNumber
}

