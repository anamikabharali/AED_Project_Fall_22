/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author srivaishnaviaekkati
 */
public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username,sword with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://avaproject.database.windows.net:1433;"
                + "database=avaproject;"
                + "user=avaproject;"
                + "password=Ava@2022;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        
        ResultSet resultSet = null;
        
        try (Connection connection = DriverManager.getConnection(connectionUrl);
           Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

