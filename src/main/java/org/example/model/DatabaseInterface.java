package org.example.model;

import org.example.User;

import java.util.ArrayList;

public interface DatabaseInterface {
    public void init();
    public void addDB();
    public void getWithDB();
    public User getUserFromDB(String requestDB);
    public void remove();
}
