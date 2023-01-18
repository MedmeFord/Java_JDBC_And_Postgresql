package org.example.model;

import java.sql.*;
import java.util.Properties;

public class DBLoader implements ConnectDB {
    private String urlDB;
    private static Connection poolDB;
    private Properties props;

    public Connection getConnectionDB() {
        return poolDB;
    }

    public DBLoader(String urlDB, String user, String userPassword, String sslBoolean) {
        this.urlDB = urlDB;

        this.props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", userPassword);
        props.setProperty("ssl", sslBoolean);
        connectDB();
    }
    public void connectDB() {
//        String url = "jdbc:postgresql://localhost/myDBTest";
//        props.setProperty("options", "-c statement_timeout=5min");

        try {
            poolDB = DriverManager.getConnection(urlDB, props);

        } catch (SQLException err) {
            System.err.println("Ошибка подключения к базе данных ");
        }
    }

    public Connection getConnect() {
        return poolDB;
    }

    public void closeDB() {
        try {
            poolDB.close();
        } catch (SQLException err) {
            System.err.println("Не удалось закрыть пулл соеденение с базой данных");
        }

    }
}
