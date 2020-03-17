package com.HW3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

    private static Connection connection = null;

    public Connection jdbcConnection() {

        Object s = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_group?useUnicode=true&serverTimezone=UTC", "root", "root");
        } catch (
                SQLException var13) {
            var13.printStackTrace();
        } catch (ClassNotFoundException var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    ((Statement) s).close();
                }

                if (connection != null) {
//                    connection.close();
                }
            } catch (SQLException var12) {
                var12.printStackTrace();
            }
        }
        return connection;
    }

}
