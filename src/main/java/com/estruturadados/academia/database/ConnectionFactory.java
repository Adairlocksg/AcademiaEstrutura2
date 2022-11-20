package com.estruturadados.academia.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://" + "containers-us-west-113.railway.app" + ":" + "7495" + "/" + "sensei_academia", "postgres", "a0ntsHHN5PCrMmCittts");
    }

}
