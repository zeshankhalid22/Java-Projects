package org.example.util;

public class Queries {
    public static final String VALID_USER_QUERY = "SELECT * FROM USERS WHERE username=? AND password=?";
    public static final String ADD_USER_QUERY = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
}
