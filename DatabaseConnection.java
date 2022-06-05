package com.example.asitakipprogrami;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private Statement statement;

    public Statement getStatement(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proje", "root", "Zeynep12345*");
            statement = connection.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }
}
