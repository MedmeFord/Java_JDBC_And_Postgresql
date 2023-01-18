package org.example;

import org.example.model.ConnectDB;
import org.example.model.DBLoader;
import org.example.model.DatabaseLogical;
import org.postgresql.Driver;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectDB dbPool = new DBLoader("jdbc:postgresql://localhost/myDBTest", "test", "root", "false");
        dbPool.connectDB();
        DatabaseLogical dataLogic = new DatabaseLogical(dbPool);

        User user = dataLogic.getUserFromDB("select * from users where id = 2");
        System.out.println("ID: " + user.getId() +
                "\nName: " + user.getName() +
                "\nAge: " + user.getAge() +
                "\nEmail: " + user.getEmail());

//        System.out.println(n);
//        dataLogic.getNameFullDB();
        dbPool.closeDB();
    }
}
