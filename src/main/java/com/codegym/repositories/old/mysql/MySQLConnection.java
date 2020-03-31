package com.codegym.repositories.old.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
    private static MySQLConnection mySQLConnection;
    Connection conn;

    private MySQLConnection() { }

    public static MySQLConnection getInstance() throws SQLException, ClassNotFoundException {
        if (mySQLConnection == null) {
            mySQLConnection = new MySQLConnection();
            mySQLConnection.getConnection();
        }

        return mySQLConnection;
    }

    Connection getConnection() throws ClassNotFoundException, SQLException {
        if (this.conn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentmangement";
            this.conn = DriverManager.getConnection(url, "root", "123456");
        }
        return conn;
    }

    public Statement getStatement() throws SQLException {
        return this.conn.createStatement();
    }
}
