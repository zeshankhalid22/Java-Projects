package org.example.dao;

import org.example.dao.User;

public interface UserDao {
    boolean isValidUser(String username, String password);

    boolean addUser(User user);
}
