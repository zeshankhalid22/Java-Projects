package org.example.app.services;

import org.example.app.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
     User saveUser(User user);
     Optional<User> getUserById(String id);
     Optional<User> updateUser(User user);
     void deleteUser(String id);
     boolean isUSerExist(String userId);
     boolean isUserExistByUseEmail(String email);
     List<User> getAllUsers();
}
