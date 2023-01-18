package org.example.model;

import org.example.User;

import javax.jws.soap.SOAPBinding;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DatabaseLogical implements DatabaseInterface {
    private static Connection poolDB;
    private Statement stmt;

    public DatabaseLogical (ConnectDB connectedDB) {
        this.poolDB = connectedDB.getConnect();

        try {
            stmt = poolDB.createStatement();
        } catch (SQLException err) {
            System.err.println("Ошибка создания statement");
        }
    }

    public void init() {

    }

    public User getUserFromDB(String requestDB) {
//        String searchUser = "select id from users";
        User user = new User();
        try {
            ResultSet rs = stmt.executeQuery(requestDB);
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getInt("age"));
            }
            return user;
        } catch (SQLException err) {
            System.err.println("Ошибка поиска максимального айди");
            System.exit(1);
        }
        return user;
    }

    public void addDB() {

    }

    public void getWithDB() {

    }

    public void getNameFullDB() {
        try {
//            Statement stmt = poolDB.createStatement();

            String SearchName = "SELECT name FROM users";

            ResultSet rs = stmt.executeQuery(SearchName);
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }
        } catch (SQLException err) {
            System.err.println("Нет подключения к базе данных");
        }

    }

    public void remove() {

    }
}
