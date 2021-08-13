package example

import java.sql.DriverManager
import java.sql.Connection

object ScalaJdbcConnectSelect {
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/menagerie?useSSL=false"
  val username = "root"
  val password = "passsword123"

  // there's probably a better way to do this
  var connection:Connection = null

  try {
    // make the connection
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)

    // create the statement, and run the select query
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT name, owner FROM pet")
    while ( resultSet.next() ) {
      val host = resultSet.getString("name")
      val user = resultSet.getString("owner")
      println("host, user = " + host + ", " + user)
    }
  } catch {
    case e => e.printStackTrace()
  }
  connection.close()
}

