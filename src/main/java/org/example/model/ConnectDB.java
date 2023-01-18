package org.example.model;

import java.sql.Connection;

public interface ConnectDB {
    public void connectDB();
    public Connection getConnect();
    public void closeDB();
}
